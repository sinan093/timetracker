package timetracker.employee.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class EmployeeDto {

    private String lastname;

    private String firstname;

    private String birthday;

    private String hourlyPayment;
}
