package timetracker.company.service;

import lombok.RequiredArgsConstructor;
import timetracker.company.dto.CompanyDto;
import timetracker.company.entity.CompanyEntity;
import timetracker.company.mapper.CompanyMapper;
import timetracker.company.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    public void saveCompany(CompanyDto companyDto) {
        CompanyEntity companyEntity = companyMapper.mapToCompanyEntity(companyDto);
        companyRepository.save(companyEntity);
    }

    public List<CompanyDto> getAllCompanies() {
        List<CompanyEntity> companyEntityList = companyRepository.findAll();
        return companyMapper.mapToCompanyDtos(companyEntityList);
    }

    public void updateCompany(CompanyDto companyDto) {
        CompanyEntity companyEntity = companyRepository.findById(companyDto.getId())
                .orElseThrow();
        companyEntity = companyMapper.mapToCompanyEntity(companyDto);
        companyRepository.save(companyEntity);
    }

    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }


}
