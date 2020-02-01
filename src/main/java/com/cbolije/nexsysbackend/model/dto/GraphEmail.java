package com.cbolije.nexsysbackend.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GraphEmail {
    @JsonProperty("name")
    private String name;
    @JsonProperty("address")
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
