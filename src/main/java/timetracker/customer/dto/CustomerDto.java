package timetracker.customer.dto;

import lombok.Data;
import timetracker.address.dto.AddressDto;
import timetracker.project.dto.ProjectDto;

@Data
public class CustomerDto {

    private String name;

    private String address;

    private String budget;

    private ProjectDto projectDto;

    private AddressDto addressDto;
}
