package timetracker.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import timetracker.user.dto.UserDto;
import timetracker.user.service.UserService;

import java.util.List;

@RestController("user")
@RequiredArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping("/get-all-users")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/create-user")
    public void createUser(@RequestBody UserDto userDto) {
        userService.createUser(userDto);
    }

    @DeleteMapping("/delete-user/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }


}
