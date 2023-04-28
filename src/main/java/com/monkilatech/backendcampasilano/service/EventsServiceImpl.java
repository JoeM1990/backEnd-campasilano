package com.monkilatech.backendcampasilano.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monkilatech.backendcampasilano.model.Events;
import com.monkilatech.backendcampasilano.repository.EventsRepo;
import com.monkilatech.backendcampasilano.utils.ValueException;

@Service
public class EventsServiceImpl implements EventsService {

    @Autowired
    private EventsRepo eventsRepo;

    @Override
    public List<Events> getAll() throws Exception {
        List<Events> events = this.eventsRepo.findAll();

        return events;
    }

    @Override
    public Events get(long eventsId) throws Exception {

        return this.eventsRepo.getEventsById(eventsId);
    }

    @Override
    public Events create(Events events) throws Exception {

        return this.eventsRepo.save(events);
    }

    @Override
    public Events update(Events events) throws Exception {

        return this.eventsRepo.save(events);
    }

    @Override
    public boolean delete(long eventsId) throws Exception {

        Events events = this.eventsRepo.getEventsById(eventsId);
        if (events == null)
            throw new ValueException("Aucun Event n'est trouvé avec l'id " + eventsId);

        this.eventsRepo.delete(events);

        Events eventsCheckOut = this.eventsRepo.getEventsById(eventsId);

        if (eventsCheckOut != null)
            return true;
        return false;
    }

}
