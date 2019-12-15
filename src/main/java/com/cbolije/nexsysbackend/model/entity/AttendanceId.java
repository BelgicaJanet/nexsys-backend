package com.cbolije.nexsysbackend.model.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AttendanceId implements Serializable{

    @Column(name = "eventId")
    private long eventId;
    @Column(name = "personId")
    private long personId;

    public AttendanceId() {
    }

    public AttendanceId(long eventId, long personId) {
        this.eventId = eventId;
        this.personId = personId;
    }

    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttendanceId that = (AttendanceId) o;
        return eventId == that.eventId &&
                personId == that.personId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId, personId);
    }
}
