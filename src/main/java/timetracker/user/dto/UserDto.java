package timetracker.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserDto {

    private String userName;

    private String firstName;

    private String lastName;

    private String birthday;

    private String emailAddress;

    private String password;
}
