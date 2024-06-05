package timetracker.project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import timetracker.project.dto.ProjectDto;
import timetracker.project.service.ProjectService;

import java.util.List;

@RestController("/project")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping("/get-all-projects")
    public List<ProjectDto> getAllProjects() {
        return projectService.getAllProjects();
    }

    @PostMapping("/create-project")
    public void createProject(ProjectDto projectDto) {
        projectService.createProject(projectDto);
    }

    @DeleteMapping("/delete-project/{id}")
    public void deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
    }

}
