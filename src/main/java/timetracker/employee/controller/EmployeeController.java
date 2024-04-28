package timetracker.employee.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import timetracker.employee.dto.EmployeeDto;
import timetracker.employee.service.EmployeeService;

import java.util.List;

@RestController("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/get-all-employees")
    public List<EmployeeDto> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping("/create-employee")
    public void createEmployee(EmployeeDto employeeDto) {
        employeeService.createEmployee(employeeDto);
    }

    @DeleteMapping("/delete-employee/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }
}
