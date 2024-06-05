package timetracker.project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import timetracker.employee.entity.EmployeeEntity;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class ProjectDto {

    private String projectName;

    private String capacityInHours;

    private String budget;

    private ProjectDto projectDto;

    private List<EmployeeEntity> employeeEntityList;
}
