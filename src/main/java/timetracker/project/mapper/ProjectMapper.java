package timetracker.project.mapper;

import org.mapstruct.Mapper;
import timetracker.project.dto.ProjectDto;
import timetracker.project.entity.ProjectEntity;

import java.util.List;

@Mapper
public interface ProjectMapper {

    ProjectDto mapToProjectDto(ProjectEntity projectEntity);

    ProjectEntity mapToProjectEntity(ProjectDto projectDto);

    List<ProjectDto> mapToProjectDtos(List<ProjectEntity> projectEntities);

    List<ProjectEntity> mapToProjectEntities(List<ProjectDto> projectDtos);
}
