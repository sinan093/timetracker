package timetracker.employee.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import timetracker.employee.dto.EmployeeDto;

@RestController("/employee")
public class EmployeeController {

    @GetMapping("/get-all-employees")
    public void getAllEmployees() {

    }

    @PostMapping("/create-employee")
    public void createEmployee(EmployeeDto employeeDto) {

    }

    @DeleteMapping("/delete-employee")
    public void deleteEmployee() {

    }
}
