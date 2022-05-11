package com.example.WorkOUT.Controllers;

import javax.persistence.*;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer eventID;
    private String eventName;
    private int eventHost;
    private String eventStartTime;
    private String eventEndTime;
    private String eventLocation; // Not sure of variable type
    private String eventCategory;
    private String eventDescription;
    private int eventMinPartic;
    private int eventMaxPartic;
    private int eventTotalPartic;

    public Integer getEventID() {
        return eventID;
    }

    public String getEventName() {
        return eventName;
    }

    public int getEventHost() {
        return eventHost;
    }

    public String getEventStartTime() {
        return eventStartTime;
    }

    public String getEventEndTime() {
        return eventEndTime;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public String getEventCategory() {
        return eventCategory;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public int getEventMinPartic() {
        return eventMinPartic;
    }

    public int getEventMaxPartic() {
        return eventMaxPartic;
    }

    public int getEventTotalPartic() {
        return eventTotalPartic;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setEventHost(int eventHost) {
        this.eventHost = eventHost;
    }

    public void setEventStartTime(String eventStartTime) {
        this.eventStartTime = eventStartTime;
    }

    public void setEventEndTime(String eventEndTime) {
        this.eventEndTime = eventEndTime;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public void setEventCategory(String eventCategory) {
        this.eventCategory = eventCategory;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public void setEventMinPartic(int eventMinPartic) {
        this.eventMinPartic = eventMinPartic;
    }

    public void setEventMaxPartic(int eventMaxPartic) {
        this.eventMaxPartic = eventMaxPartic;
    }

    public void setEventTotalPartic(int eventTotalPartic) {
        this.eventTotalPartic = eventTotalPartic;
    }
}
