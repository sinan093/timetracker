package timetracker.company.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import timetracker.company.dto.CompanyDto;
import timetracker.company.service.CompanyService;

import java.util.List;

@RestController("/company")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping("/get-all-companies")
    public List<CompanyDto> getAllEmployees() {
        return companyService.getAllCompanies();
    }

    @PostMapping("/create-company")
    public void createCompany(@RequestBody CompanyDto companyDto) {
        companyService.saveCompany(companyDto);
    }

    @DeleteMapping("/delete-company/{id}")
    public void deleteCompany(@PathVariable Long id) {
        companyService.deleteCompany(id);
    }

}