package com.example.WorkOUT.Controllers;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    boolean existsByUserID(int userId);
    boolean existsByEmail(String email);
    boolean existsByEmailAndPassword(String email, String password);
    boolean existsByUsername(String username);
    List<User> findUserByEmail(String email);
    List<User> findUserByUsername(String username);
    User findByEmailAndPassword(String email, String password);
}
