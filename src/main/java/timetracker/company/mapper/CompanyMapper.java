package timetracker.company.mapper;

import org.mapstruct.Mapper;
import timetracker.company.dto.CompanyDto;
import timetracker.company.entity.CompanyEntity;

import java.util.List;

@Mapper
public interface CompanyMapper {

    CompanyDto mapToCompanyDto(CompanyEntity companyEntity);

    CompanyEntity mapToCompanyEntity(CompanyDto companyDto);

    List<CompanyDto> mapToCompanyDtos(List<CompanyEntity> companyEntities);

    List<CompanyEntity> mapToCompanyEntities(List<CompanyDto> companyDtos);
}
