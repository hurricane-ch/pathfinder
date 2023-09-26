package bg.softuni.pathfinder.controller;

import bg.softuni.pathfinder.model.User;
import bg.softuni.pathfinder.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class UserController {

    private final UserService userService;

    @GetMapping(path = "/all")
    public List<User> getAll() {
        return userService.getAll();
    }

}
