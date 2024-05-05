package timetracker.address.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import timetracker.address.dto.AddressDto;
import timetracker.address.entity.AddressEntity;

import java.util.List;

@Mapper
public interface AddressMapper {

    AddressDto mapToAddressDto(AddressEntity addressEntity);

    @Mapping(target = "id", ignore = true)
    AddressEntity mapToAddressEntity(AddressDto addressDto);

    List<AddressDto> mapToAddressDtos(List<AddressEntity> addressEntities);

    @Mapping(target = "id", ignore = true)
    List<AddressEntity> mapToAddressEntities(List<AddressDto> addressDtos);

}
