package timetracker.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import timetracker.employee.entity.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

}
