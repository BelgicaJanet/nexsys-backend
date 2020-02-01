package com.cbolije.nexsysbackend.model.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AttendanceId implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "meetingId")
    private long meetingId;
    @Column(name = "personId")
    private long personId;

    public AttendanceId() {
    }

    public AttendanceId(long meetingId, long personId) {
        this.meetingId = meetingId;
        this.personId = personId;
    }

    public long getEventId() {
        return meetingId;
    }

    public void setEventId(long eventId) {
        this.meetingId = eventId;
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
        return meetingId == that.meetingId &&
                personId == that.personId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(meetingId, personId);
    }
}
