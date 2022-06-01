package com.example.WorkOUT.Service;

import com.example.WorkOUT.Class.Event;
import com.example.WorkOUT.Class.User;
import com.example.WorkOUT.Repository.EventRepository;
import com.example.WorkOUT.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class EventService {

    // Event repository call
    private final EventRepository eventRepository;

    // User repository call
    private final UserRepository userRepository;

    // Get all events from all users endpoint
    public Iterable<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    // Add new event from a user endpoint
    public ResponseEntity<Event> addNewEvent(Event event) {
        try {
            validateEvent(event);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
        }
        User user = userRepository.findSingleUserByUsername(event.getUsername());
        if (user == null) {
            return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
        }
        eventRepository.save(event);
        user.addEventToCreateEventList(event);
        return new ResponseEntity<>(event, HttpStatus.OK);
    }

    // Get all events created by a user endpoint
    public ResponseEntity<List<Event>> allEventsCreatedByAUser(User user) {
        user.setMyCreatedEvents(eventRepository.findEventsByUsername(user.getUsername()));
        if (user.getMyCreatedEvents().isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
        } else {
            return new ResponseEntity<>(user.getMyCreatedEvents(), HttpStatus.OK);
        }
    }

    // Validate event creation
    private void validateEvent(Event event) throws Exception {
        if (event.getStartTime().isAfter(event.getEndTime())) {
            System.out.println("Error: Start time can't be before the end time!");
            throw new Exception("Error: Start time can't be before the end time!");
        }
        if (event.getEndTime().isBefore(event.getStartTime())) {
            System.out.println("Error: End time can't be before the start time!");
            throw new Exception("Error: End time can't be before the start time!");
        }
        if (event.getEventName() == null || event.getEventName().isBlank() || event.getEventName().isEmpty()) {
            System.out.println("Error: Event name can't be empty!");
            throw new Exception("Error: Event name can't be empty!");
        }
    }
}
