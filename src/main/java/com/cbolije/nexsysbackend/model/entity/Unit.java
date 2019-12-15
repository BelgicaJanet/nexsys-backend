package com.cbolije.nexsysbackend.model.entity;

import javax.persistence.*;

@Entity
public class Unit {

    @Id
    @SequenceGenerator(name = "unit_generator", sequenceName = "sq_unit")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "unit_generator")
    private long id;
    private String name;

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
}
