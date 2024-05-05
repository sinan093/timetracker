package timetracker.address.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import timetracker.address.dto.AddressDto;
import timetracker.address.service.AddressService;

import java.util.List;

@RestController("/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @GetMapping("/get-all-addresses")
    public List<AddressDto> getAllAddresses() {
        return addressService.getAllAddresses();
    }

    @PostMapping("/create-address")
    public void createAddress(@RequestBody AddressDto addressDto) {
        addressService.createAddress(addressDto);
    }

    @DeleteMapping("/delete-address/{id}")
    public void deleteAddress(@PathVariable Long id) {
        addressService.deleteAddress(id);
    }


}
