package timetracker.address.dto;

import lombok.Data;

@Data
public class AddressDto {

    private String country;

    private String zipCode;

    private String city;

    private String street;

    private String houseNumber;
}
