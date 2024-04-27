package timetracker.project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import timetracker.project.dto.ProjectDto;
import timetracker.project.repository.ProjectRepository;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    public void getAllProjects() {

    }

    public void createProject(ProjectDto projectDto) {

    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

}
