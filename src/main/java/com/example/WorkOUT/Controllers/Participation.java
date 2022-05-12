package com.example.WorkOUT.Controllers;


import javax.persistence.*;

@Entity
@Table
public class Participation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long participationID;

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
        return participationID;
    }

    public void setId(Long id) {
        this.participationID = id;
    }

    public Event getEventID() {
        return eventID;
    }
}
