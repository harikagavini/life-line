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
    private EventsRepository eventsRepo;

    @Override
    public Events createEvent(Events events) {
        return eventsRepo.save(events);
    }
    @Override
    public List<Events> getAllEvents() {
        return eventsRepo.findAll();
    }


    @Override
    public Events updateEvent(Long event_id, String name, String bb_id, String street, String city, String state, String zip) {
        Optional<Events> event = eventsRepo.findById(event_id);

        if (event.isPresent()) {
            Events eventupdate = event.get();
            eventupdate.setName(name);
            eventupdate.setBb_id(bb_id);
            eventupdate.setStreet(street);
            eventupdate.setCity(city);
            eventupdate.setState(state);
            eventupdate.setZip(zip);  // Default to system date if eventDate is null
            return eventsRepo.save(eventupdate);
        }
        return null;
    }

    @Override
    public void deleteEvent(Long event_id) {
        eventsRepo.deleteById(event_id);
    }



}
