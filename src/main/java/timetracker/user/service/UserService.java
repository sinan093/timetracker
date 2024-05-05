package timetracker.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import timetracker.user.dto.UserDto;
import timetracker.user.entity.UserEntity;
import timetracker.user.mapper.UserMapper;
import timetracker.user.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public List<UserDto> getAllUsers() {
        List<UserEntity> userEntities = userRepository.findAll();
        return userMapper.mapToUserDtos(userEntities);
    }

    public void createUser(UserDto userDto) {
        UserEntity userEntity = userMapper.mapToUserEntity(userDto);
        userRepository.save(userEntity);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
