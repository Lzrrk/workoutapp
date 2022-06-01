package com.example.WorkOUT.Controller;

import com.example.WorkOUT.Class.Event;
import com.example.WorkOUT.Class.User;
import com.example.WorkOUT.Service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/event")
@AllArgsConstructor
public class EventController {

    private final EventService eventService;

    // List of all events
    @GetMapping(path = "/all")
    public Iterable<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    // Add a new event
    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Event> addNewEvent(@RequestBody Event event) {
        return eventService.addNewEvent(event);
    }

    // List of all created events
    @PostMapping(path = "/usercreatedevents", consumes = "application/json", produces = "application/json")
    public ResponseEntity<List<Event>> allEventsCreatedByAUser(@RequestBody User user) {
        return eventService.allEventsCreatedByAUser(user);
    }
}