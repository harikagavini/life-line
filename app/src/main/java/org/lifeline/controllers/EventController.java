package org.lifeline.controllers;

import org.lifeline.model.Events;
import org.lifeline.service.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lifeline/events")
public class EventController {

    @Autowired
    private EventsService eventsService;

    @PostMapping("/create")
    public ResponseEntity<Events> createEvent(@RequestBody Events event) {
        Events createdEvent = eventsService.createEvent(event);
        return new ResponseEntity<>(createdEvent, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Events>> getAllEvents() {
        List<Events> events = eventsService.getAllEvents();
        return new ResponseEntity<>(events, HttpStatus.OK);
    }


    @PutMapping("/{event_id}")
    public ResponseEntity<Events> updateEvent(@PathVariable Long event_id,
                                             @RequestParam String name,
                                             @RequestParam String bb_id,
                                             @RequestParam String street,
                                             @RequestParam String city,
                                             @RequestParam String state,
                                             @RequestParam String zip) {

        Events updatedEvent = eventsService.updateEvent(event_id, name, bb_id, street, city, state, zip);

        return updatedEvent != null ? ResponseEntity.ok(updatedEvent) : ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{eventId}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long event_id) {
        eventsService.deleteEvent(event_id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
