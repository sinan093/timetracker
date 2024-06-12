package timetracker.project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import timetracker.employee.entity.EmployeeEntity;
import timetracker.project.dto.ProjectDto;
import timetracker.project.entity.ProjectEntity;
import timetracker.project.exception.SpentHoursNegativeException;
import timetracker.project.mapper.ProjectMapper;
import timetracker.project.repository.ProjectRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    private final ProjectMapper projectMapper;

    public List<ProjectDto> getAllProjects() {
        List<ProjectEntity> projectEntities = projectRepository.findAll();
        return projectMapper.mapToProjectDtos(projectEntities);
    }

    public void createProject(ProjectDto projectDto) {
        ProjectEntity projectEntity = projectMapper.mapToProjectEntity(projectDto);
        projectRepository.save(projectEntity);
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

    public ProjectDto getByProjectName(String projectName) {
        ProjectEntity projectEntity = projectRepository.findByProjectName(projectName);
        return projectMapper.mapToProjectDto(projectEntity);
    }

    public void bookToProject(String projectName, Integer spentHours) {
        ProjectEntity projectEntity = projectRepository.findByProjectName(projectName);
        if(spentHours > 0) {
            Integer spentHoursSum = projectEntity.getSpentHours() + spentHours;
            projectEntity.setSpentHours(spentHoursSum);
            projectRepository.save(projectEntity);
        } else {
            throw new SpentHoursNegativeException();
        }
    }

    public BigDecimal getAvgHourlyCostForProject(String projectName) {
        ProjectEntity projectEntity = projectRepository.findByProjectName(projectName);
        BigDecimal avgHourlyCost = new BigDecimal("0");
        List<EmployeeEntity> employeeEntities = projectEntity.getEmployeeEntities();
        for (EmployeeEntity employeeEntity : employeeEntities) {
            avgHourlyCost = avgHourlyCost.add(new BigDecimal(employeeEntity.getHourlyPayment()));
        }
        return avgHourlyCost.divide(new BigDecimal(employeeEntities.size() - 1));
    }

}
