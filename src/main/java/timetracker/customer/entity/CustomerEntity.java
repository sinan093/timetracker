package timetracker.customer.entity;

import jakarta.persistence.*;
import lombok.Data;
import timetracker.address.entity.AddressEntity;
import timetracker.project.entity.ProjectEntity;

@Entity
@Table(schema = "customer_data", name = "customer")
@Data
public class CustomerEntity {

    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "budget")
    private String budget;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private AddressEntity addressEntity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id")
    private ProjectEntity projectEntity;
}
