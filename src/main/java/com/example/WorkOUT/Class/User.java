package com.example.WorkOUT.Class;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    // User variables
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userID;
    private String username;
    private String email;
    private String password;
    private String gender;
    private int yearOfBirth;
    private String userGoals;
    private String socialMediaUrl;

    // List of user personal created events
    @OneToMany(fetch = FetchType.EAGER)
    private
    List<Event> myCreatedEvents = new ArrayList<>();

    // User constructor
    public User(String username, String email, String password, String gender, int yearOfBirth, String userGoals, String socialMediaUrl) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.yearOfBirth = yearOfBirth;
        this.userGoals = userGoals;
        this.socialMediaUrl = socialMediaUrl;
    }

    // Add event to user created events
    public void addEventToCreateEventList(Event event) {
        myCreatedEvents.add(event);
    }

    // No getters and setters written with the help of lombok
}