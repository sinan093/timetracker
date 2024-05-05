package timetracker.address.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import timetracker.address.dto.AddressDto;
import timetracker.address.entity.AddressEntity;
import timetracker.address.mapper.AddressMapper;
import timetracker.address.repository.AddressRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;

    private final AddressMapper addressMapper;

    public List<AddressDto> getAllAddresses() {
        List<AddressEntity> addressEntities = addressRepository.findAll();
        return addressMapper.mapToAddressDtos(addressEntities);
    }

    public void createAddress(AddressDto addressDto) {
        AddressEntity addressEntity = addressMapper.mapToAddressEntity(addressDto);
        addressRepository.save(addressEntity);
    }

    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }
}
