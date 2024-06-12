package timetracker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;
import org.springframework.security.oauth2.core.oidc.user.OidcUserAuthority;
import org.springframework.security.oauth2.core.user.OAuth2UserAuthority;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class KeycloakSecurityConfig {

    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }

    @Bean
    public SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new RegisterSessionAuthenticationStrategy(sessionRegistry());
    }

    @Bean
    public HttpSessionEventPublisher httpSessionEventPublisher() {
        return new HttpSessionEventPublisher();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        //TODO think about relevant roles for rest api calls
        // with .hasRole on the requestMatchers
        httpSecurity.authorizeHttpRequests(auth -> auth.requestMatchers(
                new AntPathRequestMatcher("/*"))
                .permitAll().anyRequest().authenticated());
        httpSecurity.oauth2ResourceServer((oauth2) -> oauth2.jwt(Customizer.withDefaults()));
        return httpSecurity.build();
    }

    @Bean
    public GrantedAuthoritiesMapper userAuthoritiesMapper() {
        return authorities -> {
            Set<GrantedAuthority> mappedAuthorities = new HashSet<>();
            GrantedAuthority authority = authorities.iterator().next();

            if(authority instanceof OidcUserAuthority) {
                OidcUserAuthority oidcUserAuthority = (OidcUserAuthority) authority;
                OidcUserInfo oidcUserInfo = oidcUserAuthority.getUserInfo();

                if(oidcUserInfo.hasClaim("realm_access")) {
                    Map<String, Object> realmAccessMap = oidcUserInfo.getClaimAsMap("realm_access");
                    Collection<String> roles = (Collection<String>) realmAccessMap.get("roles");
                    mappedAuthorities.addAll(generateAuthoritiesFromClaim(roles));
                } else if (oidcUserInfo.hasClaim("groups")) {
                    Collection<String> roles = oidcUserInfo.getClaim("groups");
                    mappedAuthorities.addAll(generateAuthoritiesFromClaim(roles));
                } else {
                    OAuth2UserAuthority oauth2UserAuthority = (OAuth2UserAuthority) authority;
                    Map<String, Object> userAttributes = oauth2UserAuthority.getAttributes();

                    if(userAttributes.containsKey("realm_access")) {
                        Map<String, Object> realmAccess = (Map<String, Object>) userAttributes.get("realm_access");
                        Collection<String> roles = (Collection<String>) realmAccess.get("roles");
                        mappedAuthorities.addAll(generateAuthoritiesFromClaim(roles));
                    }
                }
            }
            return mappedAuthorities;
        };
    }

    private Collection<GrantedAuthority> generateAuthoritiesFromClaim(Collection<String> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role)).collect(Collectors.toList());
    }

}
