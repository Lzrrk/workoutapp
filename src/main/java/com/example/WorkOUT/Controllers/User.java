package com.example.WorkOUT.Controllers;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userID;
    private String username;
    private String email;
    private String password;
    private String gender;
    private LocalDate dob;
    private int participationCounter;
    private int hostCounter;

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

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public int getParticipationCounter() {
        return participationCounter;
    }

    public void increaseParticipationCounter() {
        this.participationCounter++;
    }

    public int getHostCounter() {
        return hostCounter;
    }

    public void increaseHostCounter() {
        this.hostCounter++;
    }
}
