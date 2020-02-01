package com.cbolije.nexsysbackend.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class GraphEvent {

    @JsonProperty("iCalUId")
    private String iCalUId;
    @JsonProperty("subject")
    private String subject;
    @JsonProperty("isCancelled")
    private boolean isCancelled;
    @JsonProperty("attendees")
    private List<GraphAttendee> attendees;
    @JsonProperty("organizer")
    private GraphAttendee organizer;
    @JsonProperty("start")
    private GraphEventDate start;
    @JsonProperty("createdDateTime")
    private GraphEventCreationDate createdDateTime;

    @JsonIgnore
    private String partnerDomain;
    @JsonIgnore
    private Date eventDate;

    public static class GraphEventDate {
        @JsonProperty("dateTime")
        private Date dateTime;

        public void setDateTime(Date dateTime) {
            this.dateTime = dateTime;
        }

        public Date getDateTime() {
            return dateTime;
        }
    }

    public static class GraphEventCreationDate {
        @JsonProperty("hourOfDay")
        private int hourOfDay;
        @JsonProperty("minute")
        private int minute;
        @JsonProperty("second")
        private int second;
        @JsonProperty("dayOfMonth")
        private int dayOfMonth;
        @JsonProperty("month")
        private int month;
        @JsonProperty("year")
        private int year;

        public int getHourOfDay() {
            return hourOfDay;
        }

        public void setHourOfDay(int hourOfDay) {
            this.hourOfDay = hourOfDay;
        }

        public int getMinute() {
            return minute;
        }

        public void setMinute(int minute) {
            this.minute = minute;
        }

        public int getSecond() {
            return second;
        }

        public void setSecond(int second) {
            this.second = second;
        }

        public int getDayOfMonth() {
            return dayOfMonth;
        }

        public void setDayOfMonth(int dayOfMonth) {
            this.dayOfMonth = dayOfMonth;
        }

        public int getMonth() {
            return month;
        }

        public void setMonth(int month) {
            this.month = month;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public Date getDate() {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, this.year);
            calendar.set(Calendar.MONTH, this.month - 1);
            calendar.set(Calendar.DAY_OF_MONTH, this.dayOfMonth);
            calendar.set(Calendar.HOUR, this.hourOfDay);
            calendar.set(Calendar.MINUTE, this.minute);
            calendar.set(Calendar.SECOND, this.second);

            return calendar.getTime();
        }

    }

    public String getiCalUId() {
        return iCalUId;
    }

    public void setiCalUId(String iCalUId) {
        this.iCalUId = iCalUId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public void setCancelled(boolean cancelled) {
        isCancelled = cancelled;
    }

    public List<GraphAttendee> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<GraphAttendee> attendees) {
        this.attendees = attendees;
    }

    public GraphAttendee getOrganizer() {
        return organizer;
    }

    public void setOrganizer(GraphAttendee organizer) {
        this.organizer = organizer;
    }

    public GraphEventDate getStart() {
        return start;
    }

    public void setStart(GraphEventDate start) {
        this.start = start;
    }

    public GraphEventCreationDate getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(GraphEventCreationDate createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public String getPartnerDomain() {
        return partnerDomain;
    }

    public void setPartnerDomain(String partnerDomain) {
        this.partnerDomain = partnerDomain;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }
}
