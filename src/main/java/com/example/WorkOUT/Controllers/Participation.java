package com.example.WorkOUT.Controllers;


import javax.persistence.*;

@Entity
@Table
public class Participation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "user_user_id")
    private User userID;

    public User getUserID() {
        return userID;
    }

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "event_id_event_id")
    private Event eventID;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Event getEventID() {
        return eventID;
    }
}
