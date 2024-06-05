package timetracker.timer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import timetracker.company.service.CompanyService;
import timetracker.project.dto.ProjectDto;
import timetracker.project.service.ProjectService;

@Service
@RequiredArgsConstructor
public class TimerService {

    private final ProjectService projectService;

    private final CompanyService companyService;


    public void calculateRemainingBudget(String projectName) {
        ProjectDto projectDto = projectService.getByProjectName(projectName);
        String budgetString = projectDto.getBudget();

    }

    public void calculateRemainingTime() {

    }

}
