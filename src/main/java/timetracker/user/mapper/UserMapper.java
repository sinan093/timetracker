package timetracker.user.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import timetracker.user.dto.UserDto;
import timetracker.user.entity.UserEntity;

import java.util.List;

@Mapper
public interface UserMapper {


    UserDto mapToUserDto(UserEntity userEntity);

    @Mapping(target = "id", ignore = true)
    UserEntity mapToUserEntity(UserDto userDto);

    List<UserDto> mapToUserDtos(List<UserEntity> userEntities);

    @Mapping(target = "id", ignore = true)
    List<UserEntity> mapToUserEntities(List<UserDto> userDtos);
}
