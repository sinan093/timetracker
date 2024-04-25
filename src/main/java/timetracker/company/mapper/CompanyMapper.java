package timetracker.company.mapper;

import timetracker.company.dto.CompanyDto;
import timetracker.company.entity.CompanyEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CompanyMapper {

    public CompanyEntity mapCompanyDtoToEntity(final CompanyDto companyDto) {
        return CompanyEntity.builder()
                .id(companyDto.getId())
                .zipcode(companyDto.getZipcode())
                .city(companyDto.getCity())
                .address(companyDto.getAddress())
                .build();
    }

    public CompanyDto companyEntityToDto(final CompanyEntity companyEntity) {
        return CompanyDto.builder()
                .id(companyEntity.getId())
                .zipcode(companyEntity.getZipcode())
                .city(companyEntity.getZipcode())
                .address(companyEntity.getAddress())
                .build();
    }

    public List<CompanyEntity> mapCompanyDtoListToEntityList(final List<CompanyDto> companyDtoList) {
        List<CompanyEntity> companyEntityList = new ArrayList<>();
        for(CompanyDto companyDto : companyDtoList) {
            CompanyEntity companyEntity = new CompanyEntity();
            companyEntity = this.mapCompanyDtoToEntity(companyDto);
            companyEntityList.add(companyEntity);
        }
        return companyEntityList;
    }

    public List<CompanyDto> mapCompanyEntityListToDtoList(final List<CompanyEntity> companyEntityList) {
        List<CompanyDto> companyDtoList = new ArrayList<>();
        for(CompanyEntity companyEntity : companyEntityList) {
            CompanyDto companyDto = new CompanyDto();
            companyDto = this.companyEntityToDto(companyEntity);
            companyDtoList.add(companyDto);
        }
        return companyDtoList;
    }
}
