package com.riwi.events.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riwi.events.entities.Event;
import com.riwi.events.repositories.EventRepository;
import com.riwi.events.services.abstract_service.IEventService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EventService implements IEventService {

    @Autowired
    public final EventRepository objEventRepository;

    @Override
    public Event save(Event objEvent) {
        return objEvent.getCapacidad() > 0 && objEvent.getFecha().isAfter(LocalDate.now())
                ? this.objEventRepository.save(objEvent)
                : null;
    }

    @Override
    public List<Event> getAll() {
        return this.objEventRepository.findAll();
    }

    @Override
    public Event getById(String id) {
        return this.objEventRepository.findById(id).orElseThrow();
    }

    @Override
    public void delete(String id) {
        this.objEventRepository.deleteById(id);
    }

    @Override
    public Event update(Event objEvent) {
        return this.objEventRepository.save(objEvent);
    }

}
