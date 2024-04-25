package timetracker.company.repository;

import lombok.RequiredArgsConstructor;
import timetracker.company.dto.CompanyDto;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import timetracker.company.dto.CompanyFilterDto;

import java.util.List;

@RequiredArgsConstructor
public class CompanyRepositoryImpl implements CompanyRepositoryCustom {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<CompanyDto> findByFilter(CompanyFilterDto companyFilterDto) {

        return null;
    }
}
