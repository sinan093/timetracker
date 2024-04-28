package timetracker.project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import timetracker.project.dto.ProjectDto;
import timetracker.project.entity.ProjectEntity;
import timetracker.project.mapper.ProjectMapper;
import timetracker.project.repository.ProjectRepository;

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

}
