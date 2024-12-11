package org.lifeline.service;

import org.lifeline.dto.EventDTO;
import org.lifeline.model.Events;
import org.lifeline.repository.EventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventsServiceImpl implements EventsService {

    @Autowired
    private EventsRepository eventsRepository;



    @Override
    public Events saveEvent(Events events) {

        if(events.getName()== null || events.getEventDate() == null){
            throw new IllegalArgumentException("Event name or date cannot be empty");
        }

        return eventsRepository.save(events);
    }
    @Override
    public List<Events> getAllEvents() {
        return eventsRepository.findAll();
    }


    @Override
    public Events updateEvent(EventDTO eventDTO) {
        Optional<Events> event = eventsRepository.findById(eventDTO.getEventId());

        if (event.isPresent()) {
            Events eventUpdate = new Events();
            eventUpdate.setEventDate(eventDTO.getEventDate());
            eventUpdate.setStreet(eventDTO.getStreet());
            eventUpdate.setCity(eventDTO.getCity());
            eventUpdate.setState(eventDTO.getState());
            eventUpdate.setZip(eventDTO.getZip());  // Default to system date if eventDate is null
            return eventsRepository.save(eventUpdate);
        }
        return null;
    }

    @Override
    public void deleteEvent(Long event_id) {
        eventsRepository.deleteById(event_id);
    }
}
