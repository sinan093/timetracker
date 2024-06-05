package timetracker.company.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import timetracker.address.dto.AddressDto;
import timetracker.project.dto.ProjectDto;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class CompanyDto {

    private Long id;

    private String name;

    private AddressDto addressDto;

    private List<ProjectDto> projectDtos;

}
