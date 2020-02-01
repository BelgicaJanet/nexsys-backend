package com.cbolije.nexsysbackend.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GraphAttendee {

    @JsonProperty("emailAddress")
    private GraphEmail emailAddress;

    public GraphEmail getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(GraphEmail emailAddress) {
        this.emailAddress = emailAddress;
    }
}
