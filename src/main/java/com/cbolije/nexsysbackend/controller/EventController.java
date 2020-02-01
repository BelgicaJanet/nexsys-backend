package com.cbolije.nexsysbackend.controller;

import com.cbolije.nexsysbackend.model.dto.GraphEvent;
import com.cbolije.nexsysbackend.model.entity.Person;
import com.cbolije.nexsysbackend.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/events")
public class EventController {

    private EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getEvents(@PathVariable("id") long id) {
        return ResponseEntity.ok(eventService.getEventsByUser(id));
    }


    @PostMapping("/process")
    public ResponseEntity<?> processData(@RequestBody List<GraphEvent> events ) {
        eventService.processEventData(events);
        return ResponseEntity.ok("");
    }

    @GetMapping(value = "/dummy")
    public Person getUser() {
        Person p = new Person();
        p.setId(1);
        p.setName("Cristian");

        return p;
    }
}
