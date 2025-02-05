package com.test_industry.library.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test_industry.library.Models.User;
import com.test_industry.library.Services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public User createUser(@RequestBody String json) {
        System.out.println(json);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            User user = objectMapper.readValue(json, User.class);
            System.out.println("Usuario deserializado: " + user);
            return userService.createUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error deserializando el JSON");
        }
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
