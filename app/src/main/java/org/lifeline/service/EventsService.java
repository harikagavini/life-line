package org.lifeline.service;

import org.lifeline.model.Events;

import java.util.Date;
import java.util.List;

public interface EventsService {

    public Events createEvent(Events event);
    public List<Events> getAllEvents();
    public Events updateEvent(Long event_id, String name, String bb_id, String street, String city, String state, String zip)   ;
    public void deleteEvent(Long event_id);
}
