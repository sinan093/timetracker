package timetracker.customer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import timetracker.customer.dto.CustomerDto;
import timetracker.customer.entity.CustomerEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDto mapToCustomerDto(CustomerEntity customerEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "addressEntity", ignore = true)
    @Mapping(target = "projectEntity", ignore = true)
    CustomerEntity mapToCustomerEntity(CustomerDto customerDto);

    List<CustomerDto> mapToCustomerDtos(List<CustomerEntity> customerEntities);

    @Mapping(target = "id", ignore = true)
    List<CustomerEntity> mapToCustomerEntity(List<CustomerDto> customerDtos);
}
