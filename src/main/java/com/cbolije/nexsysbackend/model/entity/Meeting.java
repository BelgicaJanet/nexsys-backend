package com.cbolije.nexsysbackend.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Meeting {

    @Id
    @SequenceGenerator(name = "meeting_generator", sequenceName = "sq_meeting")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "meeting_generator")
    private long id;
    private String subject;
    private Date date;
    private String graphId;
    private boolean active;
    @ManyToOne
    @JoinColumn(name = "partnerId")
    private Partner partner;
    @ManyToOne
    @JoinColumn(name = "organizerId")
    private Person organizer;

    @OneToMany(
            mappedBy = "meeting",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Attendance> attendances = new ArrayList<>();

    public Meeting() {

    }

    public Meeting(long id, String subject) {
        this.id = id;
        this.subject = subject;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getGraphId() {
        return graphId;
    }

    public void setGraphId(String graphId) {
        this.graphId = graphId;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    public List<Attendance> getAttendances() {
        return attendances;
    }

    public Person getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Person organizer) {
        this.organizer = organizer;
    }

    public void setAttendances(List<Attendance> attendances) {
        this.attendances = attendances;
    }

    public void addAttendace(Person person, Date createdTime) {
        Attendance attendance = new Attendance(this, person, createdTime);
        attendances.add(attendance);
        person.getAttendances().add(attendance);
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meeting meeting = (Meeting) o;
        return  Objects.equals(graphId, meeting.graphId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(graphId);
    }
}
