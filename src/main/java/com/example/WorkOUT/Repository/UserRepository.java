package com.example.WorkOUT.Repository;

import com.example.WorkOUT.Class.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    // Check if users exists by email
    boolean existsByEmail(String email);

    // Check if users exists by email and password
    boolean existsByEmailAndPassword(String email, String password);

    // Check if users exists by username
    boolean existsByUsername(String username);

    // Find list of users by e-mail
    List<User> findUserByEmail(String email);

    // Find the exact user in the list of all users
    List<User> findUserByUsername(String username);

    // Find single user by username
    User findSingleUserByUsername(String username);

    // Find the user by e-mail and password
    User findUserByEmailAndPassword(String email, String password);
}
