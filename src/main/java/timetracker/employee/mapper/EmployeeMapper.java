package timetracker.employee.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import timetracker.employee.dto.EmployeeDto;
import timetracker.employee.entity.EmployeeEntity;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    EmployeeDto mapToEmployeeDto(EmployeeEntity employeeEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "addressEntity", ignore = true)
    EmployeeEntity mapToEmployeeEntity(EmployeeDto employeeDto);

    List<EmployeeDto> mapToEmployeeDtoList(List<EmployeeEntity> employeeEntities);

    @Mapping(target = "id", ignore = true)
    List<EmployeeEntity> mapToEmployeeEntityList(List<EmployeeDto> employeeDtos);

}
