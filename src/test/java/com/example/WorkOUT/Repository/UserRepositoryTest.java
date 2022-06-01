package com.example.WorkOUT.Repository;

import com.example.WorkOUT.Class.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class UserRepositoryTest {

    // User repository call
    @Autowired
    private UserRepository userRepo;

    // Delete repository after each test
    @AfterEach
    void tearDown() {
        userRepo.deleteAll();
    }

    // Create user in H2 database & check if user exists in repository
    @Test
    void checkWhenUserExistsWhenEmailAndPassword() {
        User user = new User(
                "username", "email@test.com", "password",
                "gender", 1990, "goal", "url.com");
        userRepo.save(user);
        Boolean expected = userRepo.existsByEmailAndPassword("email@test.com", "password");
        assertThat(expected).isTrue();
    }

    // Check if the user does not exist in repository
    @Test
    void checkWhenUserDoesNotExistByEmailAndPassword() {
        Boolean expected = userRepo.existsByEmailAndPassword("email@test.com", "password");
        assertThat(expected).isFalse();
    }
}