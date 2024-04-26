package timetracker.employee.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import timetracker.employee.dto.EmployeeDto;
import timetracker.employee.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<EmployeeDto> getAllEmployees() {
        return new ArrayList<>();
    }

    public void createEmployee(EmployeeDto employeeDto) {

    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

}
