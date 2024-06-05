package timetracker.employee.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import timetracker.address.entity.AddressEntity;
import timetracker.project.entity.ProjectEntity;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@Entity
@Table(name = "employee", schema = "user_data")
public class EmployeeEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birthday")
    private String birthday;

    @Column(name = "hourly_payment")
    private String hourlyPayment;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private AddressEntity addressEntity;

    @ManyToMany
    @JoinTable(name = "employee_project_map",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private List <ProjectEntity> projectEntities;

}
