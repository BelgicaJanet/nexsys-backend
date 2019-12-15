package com.cbolije.nexsysbackend.controller;

import com.cbolije.nexsysbackend.model.dto.GraphEvent;
import com.cbolije.nexsysbackend.model.entity.Event;
import com.cbolije.nexsysbackend.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/events")
public class EventController {

    private EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/events")
    public Event getEvents() {
        return new Event(1L, "Evento test");
    }


    @PostMapping("/process")
    public ResponseEntity<?> processData(@RequestBody List<GraphEvent> events ) {
        eventService.processEventData(events);
        return ResponseEntity.ok("");
    }

}
