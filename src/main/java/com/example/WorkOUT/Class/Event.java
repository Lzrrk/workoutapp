package com.example.WorkOUT.Class;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Event {

    // List of participants
    @OneToMany
    List<User> participants = new ArrayList<>();
    // Event variables
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int eventID;
    private String eventName;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String eventLocation;
    private String describeEvent;
    private String numberOfParticipants;
    private String workoutGoals;
    private String username;

    // Event Constructor
    public Event(String eventName, LocalDateTime startTime, LocalDateTime endTime, String eventLocation, String describeEvent, String numberOfParticipants, String workoutGoals, String username) {
        this.eventName = eventName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.eventLocation = eventLocation;
        this.describeEvent = describeEvent;
        this.numberOfParticipants = numberOfParticipants;
        this.workoutGoals = workoutGoals;
        this.username = username;
    }

    // No getters and setters written with the help of lombok
}