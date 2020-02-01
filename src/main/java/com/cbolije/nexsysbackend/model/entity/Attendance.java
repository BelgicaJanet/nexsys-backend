package com.cbolije.nexsysbackend.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Attendance implements Serializable{

	private static final long serialVersionUID = 1L;

	private enum Status {
        PENDING, REGISTERED;
    }

    @EmbeddedId
    private AttendanceId id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meetingId")
    @MapsId("meetingId")
    private Meeting meeting;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personId")
    @MapsId("personId")
    private Person person;
    private String observations;
    private Status status;
    private Date registerDate;

    public Attendance() {

    }

    public Attendance(Meeting meeting, Person person, Date registerDate) {
        this.meeting = meeting;
        this.person = person;
        this.registerDate = registerDate;
        this.id = new AttendanceId(meeting.getId(), person.getId());
    }

    public AttendanceId getId() {
        return id;
    }

    public void setId(AttendanceId id) {
        this.id = id;
    }

    public Meeting getMeeting() {
        return meeting;
    }

    public void setMeeting(Meeting meeting) {
        this.meeting = meeting;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String comments) {
        this.observations = comments;
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
