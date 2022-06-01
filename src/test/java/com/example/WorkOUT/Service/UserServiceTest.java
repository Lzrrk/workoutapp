package com.example.WorkOUT.Service;

import com.example.WorkOUT.Class.User;
import com.example.WorkOUT.Repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceTest {

    // User service call
    @Autowired
    private UserService userService;

    // User repository call
    @Autowired
    private UserRepository userRepository;

    // Delete repository after each test
    @AfterEach
    void tearDown() {
        userRepository.deleteAll();
    }

    // Create new user test
    @Test
    public void testAddNewUserSuccess() {
        User user = getSimpleUser();
        User createdUser = userService.addNewUser(user).getBody();
        assertNotNull(createdUser);
        User foundUser = userRepository.findUserByUsername("User123").get(0);
        assertEquals("User123", foundUser.getUsername());
        assertEquals("user@user.com", foundUser.getEmail());
        assertEquals("password123", foundUser.getPassword());
        assertEquals("Male", foundUser.getGender());
        assertEquals(1995, foundUser.getYearOfBirth());
        assertEquals("goal", foundUser.getUserGoals());
        assertEquals("userURL", foundUser.getSocialMediaUrl());
    }

    // Test a successful login
    @Test
    public void testLoginUserSuccess() {
        User user = getSimpleUser();
        User createdUser = userService.addNewUser(user).getBody();
        assertNotNull(createdUser);
        ResponseEntity<User> response = userService.loginUser(user);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    // Test a unsuccessful login
    @Test
    public void testLoginUserFail() {
        User user = getSimpleUser();
        ResponseEntity<User> response = userService.loginUser(user);
        assertEquals(HttpStatus.FORBIDDEN, response.getStatusCode());
        assertNull(response.getBody());
    }

    // Test creating two users and see if the list has two users in it
    @Test
    public void testGetAllUsers() {
        User user1 = getSimpleUser();
        User user2 = getSimpleUser();
        user2.setUsername("User456");
        user2.setEmail("user2@user.com");
        User createdUser1 = userService.addNewUser(user1).getBody();
        User createdUser2 = userService.addNewUser(user2).getBody();
        assertNotNull(createdUser1);
        assertNotNull(createdUser2);
        List<User> userList = (List<User>) userService.getAllUsers();
        assertNotNull(userList);
        assertEquals(2, userList.size());
    }

    // Help method using builder for creation of a user
    private User getSimpleUser() {
        return User.builder()
                .username("User123")
                .email("user@user.com")
                .password("password123")
                .gender("Male")
                .yearOfBirth(1995)
                .userGoals("goal")
                .socialMediaUrl("userURL")
                .build();
    }
}