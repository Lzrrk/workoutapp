package com.example.WorkOUT.Controllers;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Repository
public interface EventRepository extends CrudRepository<Event,Integer> {
    boolean existsByEventID(int eventID);
    Event findEventByEventID(int eventID);
    //List<Event> findEventsByEventHostID(String username);

}
