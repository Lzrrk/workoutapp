package com.example.WorkOUT.Service;

import com.example.WorkOUT.Class.Event;
import com.example.WorkOUT.Class.User;
import com.example.WorkOUT.Repository.EventRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
class EventServiceTest {

    // Event service call
    @Autowired
    private EventService eventService;

    // Event repository call
    @Autowired
    private EventRepository eventRepository;

    // User service call
    @Autowired
    private UserService userService;

    // Delete repository after each test
    @AfterEach
    void tearDown() {
        eventRepository.deleteAll();
    }


    // Test creating two events and see if the list has two events in it
    @Test
    void getAllEvents() {
        User user = getSimpleUser();
        userService.addNewUser(user);
        Event event1 = getSimpleEvent();
        Event event2 = getSimpleEvent();
        event2.setEventName("eventName2");
        event2.setEventLocation("eventLocation2");
        Event createdEvent1 = eventService.addNewEvent(event1).getBody();
        Event createdEvent2 = eventService.addNewEvent(event2).getBody();
        assertNotNull(createdEvent1);
        assertNotNull(createdEvent2);
        List<Event> allEvents = (List<Event>) eventService.getAllEvents();
        assertNotNull(allEvents);
        assertEquals(2, allEvents.size());
    }

    // Test successful creation of an event
    @Test
    void testAddNewEventSuccess() {
        User user = getSimpleUser();
        userService.addNewUser(user);
        Event event = getSimpleEvent();
        Event createdEvent = eventService.addNewEvent(event).getBody();
        assertNotNull(createdEvent);
        Event foundEvent = eventRepository.findEventByUsername("User123");
        assertEquals("eventName",foundEvent.getEventName());
        assertEquals(LocalDateTime.of(2022, 6, 1, 14, 0),foundEvent.getStartTime());
        assertEquals(LocalDateTime.of(2022, 6, 1, 15, 0),foundEvent.getEndTime());
        assertEquals("eventLocation",foundEvent.getEventLocation());
        assertEquals("eventDescription",foundEvent.getDescribeEvent());
        assertEquals("10",foundEvent.getNumberOfParticipants());
        assertEquals("workoutGoal",foundEvent.getWorkoutGoals());
        assertEquals("User123",foundEvent.getUsername());
    }

    // Test listing all events created by a user
    @Test
    void allEventsCreatedByAUser() {
        User user = getSimpleUser();
        userService.addNewUser(user);
        Event event = getSimpleEvent();
        Event createdEvent = eventService.addNewEvent(event).getBody();
        assertNotNull(createdEvent);
        ResponseEntity<List<Event>> response = eventService.allEventsCreatedByAUser(user);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());

    }

    // Help method using builder for creation of an event
    private Event getSimpleEvent(){
        return Event.builder()
                .eventName("eventName")
                .startTime(LocalDateTime.of(2022, 6, 1, 14, 0))
                .endTime(LocalDateTime.of(2022, 6, 1, 15, 0))
                .eventLocation("eventLocation")
                .describeEvent("eventDescription")
                .numberOfParticipants("10")
                .workoutGoals("workoutGoal")
                .username("User123")
                .build();
    }

    // Help method using builder for creation of a user
    private User getSimpleUser() {
        return User.builder()
                .username("User123")
                .email("user@user.com")
                .password("password123")
                .gender("Male")
                .yearOfBirth(1995)
                .userGoals("goal")
                .socialMediaUrl("userURL")
                .build();
    }
}