package timetracker.project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ProjectDto {

    private String projectName;

    private String capacityInHours;

    private String budget;
}
