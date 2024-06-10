package timetracker.timer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import timetracker.company.service.CompanyService;
import timetracker.employee.service.EmployeeService;
import timetracker.project.dto.ProjectDto;
import timetracker.project.service.ProjectService;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class TimerService {

    private final ProjectService projectService;

    private final CompanyService companyService;

    private final EmployeeService employeeService;


    public BigDecimal calculateRemainingBudget(String projectName) {
        ProjectDto projectDto = projectService.getByProjectName(projectName);
        BigDecimal budgetBigDecimal = new BigDecimal(projectDto.getBudget());
        return budgetBigDecimal.subtract(new BigDecimal(projectDto.getSpentHours())).multiply(projectService.getAvgHourlyCostForProject(projectName));
    }

    public Integer calculateRemainingTime(String projectName) {
        ProjectDto projectDto = projectService.getByProjectName(projectName);
        return projectDto.getCapacityInHours() - projectDto.getSpentHours();
    }

    public void bookSpentTimeToProject(String projectName, Integer spentTime) {
        projectService.bookToProject(projectName, spentTime);
    }

}
