package timetracker.project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@Entity
@Table(name = "project", schema = "project_data")
public class ProjectEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "capacity_in_hours")
    private String capacityInHours;

    @Column(name = "budget")
    private String budget;
}
