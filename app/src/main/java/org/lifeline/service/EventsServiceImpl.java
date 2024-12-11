package org.lifeline.service;

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
    public Events updateEvent(Long event_id, String name, String bb_id, String street, String city, String state, String zip) {
        Optional<Events> event = eventsRepository.findById(event_id);

        if (event.isPresent()) {
            Events eventupdate = event.get();
            eventupdate.setName(name);
            eventupdate.setBranchId(bb_id);
            eventupdate.setStreet(street);
            eventupdate.setCity(city);
            eventupdate.setState(state);
            eventupdate.setZip(zip);  // Default to system date if eventDate is null
            return eventsRepository.save(eventupdate);
        }
        return null;
    }

    @Override
    public void deleteEvent(Long event_id) {

        eventsRepository.deleteById(event_id);
    }



}
