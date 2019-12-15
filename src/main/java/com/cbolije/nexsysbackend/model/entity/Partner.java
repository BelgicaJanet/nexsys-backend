package com.cbolije.nexsysbackend.model.entity;

import javax.persistence.*;

@Entity
public class Partner {

    @Id
    @SequenceGenerator(name = "partner_generator", sequenceName = "sq_partner")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "partner_generator")
    private long id;
    private String name;
    private String domain;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}
