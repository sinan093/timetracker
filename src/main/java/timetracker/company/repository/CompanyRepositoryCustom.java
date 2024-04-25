package timetracker.company.repository;

import timetracker.company.dto.CompanyDto;
import timetracker.company.dto.CompanyFilterDto;

import java.util.List;

public interface CompanyRepositoryCustom {

    List<CompanyDto> findByFilter(CompanyFilterDto companyFilterDto);

}
