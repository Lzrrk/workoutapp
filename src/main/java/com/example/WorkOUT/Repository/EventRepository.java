package com.example.WorkOUT.Repository;

import com.example.WorkOUT.Class.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {
    // Check if users exists by username
    boolean existsByUsername(String username);

    // Find single event by username
    Event findEventByUsername(String username);

    // Find list of all events by username
    List<Event> findEventsByUsername(String username);
}
