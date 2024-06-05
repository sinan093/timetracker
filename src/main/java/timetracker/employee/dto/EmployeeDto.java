package timetracker.employee.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import timetracker.address.dto.AddressDto;
import timetracker.project.dto.ProjectDto;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class EmployeeDto {

    private String lastname;

    private String firstname;

    private String birthday;

    private String hourlyPayment;

    private AddressDto addressDto;

    private List<ProjectDto> projectDtos;
}
