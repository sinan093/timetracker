package timetracker.company.entity;

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
@Table(name = "company", schema = "user_data")
public class CompanyEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "zipcode")
    private String zipcode;

    @Column(name = "city")
    private String city;

    @Column(name = "address")
    private String address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private AddressEntity addressEntity;

    @OneToMany(mappedBy = "company")
    private List<ProjectEntity> projectEntities;
}
