package org.lifeline.controllers;

import org.lifeline.model.Events;
import org.lifeline.response.EventResponse;
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
    public EventResponse saveEvent(@RequestBody Events event) {
        eventsService.saveEvent(event);
        EventResponse eventResponse = new EventResponse();
        eventResponse.setMessage("Event created");
        eventResponse.setSuccess(true);
        return eventResponse;
    }

    @GetMapping
    public ResponseEntity<List<Events>> getAllEvents() {
        List<Events> events = eventsService.getAllEvents();
        return new ResponseEntity<>(events, HttpStatus.OK);
    }


    @PutMapping("/{eventId}")
    public ResponseEntity<Events> updateEvent(@PathVariable Long eventId,
                                             @RequestParam String name,
                                             @RequestParam String bb_id,
                                             @RequestParam String street,
                                             @RequestParam String city,
                                             @RequestParam String state,
                                             @RequestParam String zip) {

        Events updatedEvent = eventsService.updateEvent(eventId, name, bb_id, street, city, state, zip);

        return updatedEvent != null ? ResponseEntity.ok(updatedEvent) : ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{eventId}")
    public EventResponse deleteEvent(@PathVariable Long eventId) {
        eventsService.deleteEvent(eventId);
        EventResponse eventResponse = new EventResponse();
        eventResponse.setMessage("Event Deleted");
        eventResponse.setSuccess(true);
        return eventResponse;
    }
}
