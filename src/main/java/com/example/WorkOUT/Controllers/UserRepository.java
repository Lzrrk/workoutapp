package com.example.WorkOUT.Controllers;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    boolean existsByUserID(int userId);
    boolean existsByEmail(String email);
    boolean existsByEmailAndPassword(String email, String password);

}
