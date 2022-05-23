package com.example.WorkOUT.Controllers;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository<Event,Integer> {
    boolean existsByEventID(int eventID);
    Event findEventByEventID(int eventID);
}
