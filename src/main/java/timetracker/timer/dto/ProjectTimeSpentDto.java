package timetracker.timer.dto;

import lombok.Data;

@Data
public class ProjectTimeSpentDto {
    private String projectName;
    private Integer spentTimeInHours;
}
