package org.lifeline.service;

import org.lifeline.dto.EventDTO;
import org.lifeline.model.Events;

import java.util.List;

public interface EventsService {
    public Events saveEvent(Events event);
    public List<Events> getAllEvents();
    public Events updateEvent(EventDTO eventDTO);   ;
    public void deleteEvent(Long event_id);
}
