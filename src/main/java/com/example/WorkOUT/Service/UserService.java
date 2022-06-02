package com.example.WorkOUT.Service;

import com.example.WorkOUT.Class.User;
import com.example.WorkOUT.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@AllArgsConstructor
@Service
public class UserService {

    // User repository call
    private final UserRepository userRepository;

    // Create new user
    public ResponseEntity<User> addNewUser(User user) {
        try {
            validateUser(user);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
        }

        User createdUser = userRepository.save(user);
        return new ResponseEntity<>(createdUser, HttpStatus.OK);
    }

    // Get all users
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Login to app endpoint
    public ResponseEntity<User> loginUser(@RequestBody User user) {
        User newUser = userRepository.findUserByEmailAndPassword(user.getEmail(), user.getPassword());
        if (newUser == null) {
            return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
        } else {
            return new ResponseEntity<>(newUser, HttpStatus.OK);
        }
    }

    // Validate user creation
    private void validateUser(User user) throws Exception {
        boolean emailExists = userRepository.existsByEmail(user.getEmail());
        if (emailExists) {
            user = userRepository.findUserByEmail(user.getEmail()).get(0);
            throw new Exception("There is no User with email: " + user.getEmail());
        }
        boolean usernameExists = userRepository.existsByUsername(user.getUsername());
        if (usernameExists || user.getUsername() == null) {
            user = userRepository.findUserByUsername(user.getUsername()).get(0);
            throw new Exception("There is no User with username: " + user.getUsername());
        }
    }
}