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
    EmployeeEntity mapToEmployeeEntity(EmployeeDto employeeDto);

    List<EmployeeDto> mapEmployeeDtoList(List<EmployeeEntity> employeeEntities);

    @Mapping(target = "id", ignore = true)
    List<EmployeeEntity> mapEmployeeEntityList(List<EmployeeDto> employeeDtos);

}
