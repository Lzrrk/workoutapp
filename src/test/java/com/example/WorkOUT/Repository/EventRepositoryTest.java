package com.example.WorkOUT.Repository;

import com.example.WorkOUT.Class.Event;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class EventRepositoryTest {

    // Event repository call
    @Autowired
    private EventRepository eventRepo;

    // Delete repository after each test
    @AfterEach
    void tearDown() {
        eventRepo.deleteAll();
    }

    // Create event in H2 Database & check if user exists in repository
    @Test
    void checkIfEventExistsByEventID() {
        LocalDateTime startTime = LocalDateTime.of(2022, 6, 1, 14, 0);
        LocalDateTime endTime = LocalDateTime.of(2022, 6, 1, 15, 0);
        Event event = new Event(
                "eventName", startTime, endTime, "eventLocation", "eventDescription", "10", "Goal", "eventUser");
        eventRepo.save(event);
        Boolean expected = eventRepo.existsByUsername("eventUser");
        assertThat(expected).isTrue();
    }

    // Check if the event does not exist in repository
    @Test
    void checkIfEventDoesNotExistByEventIDAndEventName() {
        Boolean expected = eventRepo.existsByUsername("eventUser");
        assertThat(expected).isFalse();
    }
}