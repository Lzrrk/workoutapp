package com.example.WorkOUT.Controller;

import com.example.WorkOUT.Class.User;
import com.example.WorkOUT.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/user")
@AllArgsConstructor
public class UserController {

    // User service class
    private final UserService userService;

    // List of all users
    @GetMapping(path = "/all")
    public Iterable<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // User login
    @PostMapping(path = "/login", consumes = "application/json", produces = "application/json")
    public ResponseEntity<User> loginUser(@RequestBody User user) {
        return userService.loginUser(user);
    }

    // Creating a new user
    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public ResponseEntity<User> addNewUser(@RequestBody User user) {
        return userService.addNewUser(user);
    }
}
