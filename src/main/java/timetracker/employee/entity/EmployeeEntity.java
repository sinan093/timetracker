package timetracker.employee.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import timetracker.address.entity.AddressEntity;

@Data
@Builder
@AllArgsConstructor
@Entity
@Table(name = "employee", schema = "user_data")
public class EmployeeEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "last_name")
    private String lastname;

    @Column(name = "first_name")
    private String firstname;

    @Column(name = "birthday")
    private String birthday;

    @Column(name = "hourly_payment")
    private String hourlyPayment;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private AddressEntity addressEntity;

}
