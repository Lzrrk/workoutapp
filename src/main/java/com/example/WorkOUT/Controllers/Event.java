package com.example.WorkOUT.Controllers;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer eventID;
    private String eventName;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String eventLocation;
    private String describeEvent;
    private String numberOfParticipants;
    private String workoutGoals;
    private String eventHost;


    @ManyToMany
    List<User> participants = new ArrayList<>();


    public Event(){

    }

    public Event(Integer eventID, String eventName, LocalDateTime startTime, LocalDateTime endTime, String eventLocation, String describeEvent, String numberOfParticipants, String workoutGoals, String eventHost) {
        this.eventID = eventID;
        this.eventName = eventName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.eventLocation = eventLocation;
        this.describeEvent = describeEvent;
        this.numberOfParticipants = numberOfParticipants;
        this.workoutGoals = workoutGoals;
        this.eventHost = eventHost;
    }

    public Integer getEventID() {
        return eventID;
    }

    public void setEventID(Integer eventID) {
        this.eventID = eventID;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public LocalDateTime getStartTime() {
        return LocalDateTime.parse(startTime.toString());
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return LocalDateTime.parse(endTime.toString());
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public String getDescribeEvent() {
        return describeEvent;
    }

    public void setDescribeEvent(String describeEvent) {
        this.describeEvent = describeEvent;
    }

    public String getNumberOfParticipants() {
        return numberOfParticipants;
    }

    public void setNumberOfParticipants(String numberOfParticipants) {
        this.numberOfParticipants = numberOfParticipants;
    }

    public String getWorkoutGoals() {
        return workoutGoals;
    }

    public void setWorkoutGoals(String workoutLevel) {
        this.workoutGoals = workoutLevel;
    }

    public String getEventHost(){ return eventHost; }

    public void setEventHost(String newHost ){
        eventHost = newHost;
    }
}
