package timetracker.employee.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import timetracker.employee.dto.EmployeeDto;
import timetracker.employee.entity.EmployeeEntity;
import timetracker.employee.mapper.EmployeeMapper;
import timetracker.employee.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final EmployeeMapper employeeMapper;

    public List<EmployeeDto> getAllEmployees() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        return employeeMapper.mapToEmployeeDtoList(employeeEntities);
    }

    public void createEmployee(EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = employeeMapper.mapToEmployeeEntity(employeeDto);
        employeeRepository.save(employeeEntity);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

}
