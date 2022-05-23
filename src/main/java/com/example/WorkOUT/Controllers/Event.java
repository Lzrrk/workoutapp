package com.example.WorkOUT.Controllers;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer eventID;
    private String eventName;
    private String startDate;
    private String startTimeAndEndTime;
    private String eventLocation;
    private String describeEvent;
    private String numberOfParticipants;
    private String workoutLevel;

    @ManyToMany
    Set<User> participants;

    public Event(){

    }

    public Event(Integer eventID, String eventName, String startDate, String startTimeAndEndTime, String eventLocation, String describeEvent, String numberOfParticipants, String workoutLevel) {
        this.eventID = eventID;
        this.eventName = eventName;
        this.startDate = startDate;
        this.startTimeAndEndTime = startTimeAndEndTime;
        this.eventLocation = eventLocation;
        this.describeEvent = describeEvent;
        this.numberOfParticipants = numberOfParticipants;
        this.workoutLevel = workoutLevel;
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStartTimeAndEndTime() {
        return startTimeAndEndTime;
    }

    public void setStartTimeAndEndTime(String startTimeAndEndTime) {
        this.startTimeAndEndTime = startTimeAndEndTime;
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

    public String getWorkoutLevel() {
        return workoutLevel;
    }

    public void setWorkoutLevel(String workoutLevel) {
        this.workoutLevel = workoutLevel;
    }
}
