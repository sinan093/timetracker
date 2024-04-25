package timetracker.company.dto;

import lombok.Data;

@Data
public class CompanyFilterDto {
    private String name;

    private String zipcode;

    private String city;

    private String address;
}
