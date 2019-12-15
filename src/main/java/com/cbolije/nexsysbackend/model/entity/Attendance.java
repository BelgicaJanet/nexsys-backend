package com.cbolije.nexsysbackend.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Attendance implements Serializable{

    private enum Status {
        PENDING, REGISTERED;
    }

    @EmbeddedId
    private AttendanceId id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "eventId")
    @MapsId("eventId")
    private Event event;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personId")
    @MapsId("personId")
    private Person person;
    private String comments;
    private Status status;
    private Date registerDate;

    public Attendance() {

    }

    public Attendance(Event event, Person person, Date registerDate) {
        this.event = event;
        this.person = person;
        this.registerDate = registerDate;
        this.id = new AttendanceId(event.getId(), person.getId());
    }

    public AttendanceId getId() {
        return id;
    }

    public void setId(AttendanceId id) {
        this.id = id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }
}
