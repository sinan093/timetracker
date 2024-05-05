package timetracker.project.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import timetracker.project.dto.ProjectDto;
import timetracker.project.entity.ProjectEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    ProjectDto mapToProjectDto(ProjectEntity projectEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "companyEntity", ignore = true)
    ProjectEntity mapToProjectEntity(ProjectDto projectDto);

    List<ProjectDto> mapToProjectDtos(List<ProjectEntity> projectEntities);

    @Mapping(target = "id", ignore = true)
    List<ProjectEntity> mapToProjectEntities(List<ProjectDto> projectDtos);
}
