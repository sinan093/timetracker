package timetracker.company.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CompanyDto {

    private Long id;

    private String name;

    private String zipcode;

    private String city;

    private String address;

    public CompanyDto() {}

}
