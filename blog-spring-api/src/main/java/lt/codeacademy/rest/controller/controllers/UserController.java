package lt.codeacademy.rest.controller.controllers;

import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lt.codeacademy.rest.entities.Role;
import lt.codeacademy.rest.entities.User;
import lt.codeacademy.rest.services.UserDetailsServiceImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import java.util.Set;
import java.util.stream.Collectors;


@RestController("UserController")
@RequestMapping("/user")
@CrossOrigin("http://localhost:3000")
public class UserController {

    private final UserDetailsServiceImpl userDetailsService;

    public UserController(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @GetMapping
    @ApiOperation(value = "Get user")
    public UserDto getUser(@AuthenticationPrincipal User user) {
        return new UserDto(user);
    }

    @Data
    private static class UserDto {
        private String name;
        private String lastName;
        private Set<String> roles;

        UserDto(User user) {
            this.name = user.getName();
            this.lastName = user.getLastName();
            this.roles = user.getRoles().stream()
                    .map(Role::getRole)
                    .collect(Collectors.toSet());
        }
    }
}
