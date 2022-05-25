package com.example.WorkOUT.Controllers;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


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
    List<Event> myCreatedEvents = new ArrayList<>();

    @ManyToMany
    List<Event> myUpcomingEvents = new ArrayList<>();



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

    public void addEventToCreateEventList(Event event){
        myCreatedEvents.add(event);
    }
}