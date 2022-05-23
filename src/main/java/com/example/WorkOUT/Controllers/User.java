package com.example.WorkOUT.Controllers;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/*

spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://mysql.dsv.su.se/josa5094
spring.datasource.username=josa5094
spring.datasource.password=quoh2luuXeeH

 */


@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userID;
    private String username;
    private String email;
    private String password;
    private String gender;
    private String describe;

    @ManyToMany
    Set<Event> createEvents;

    public User(String username, String email, String password, String gender, String describe) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.describe = describe;
    }

    public User() {

    }


    public Integer getId() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDescribe(){ return describe; }

    public void setDescribe(String newDescribe){ this.describe = newDescribe; }
}