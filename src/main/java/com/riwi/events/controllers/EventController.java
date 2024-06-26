package com.riwi.events.controllers;

import java.util.List;

import org.hibernate.engine.spi.Resolution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.events.entities.Event;
import com.riwi.events.services.abstract_service.IEventService;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/events")
@AllArgsConstructor
public class EventController {
    @Autowired
    public final IEventService objIEventService;

    @GetMapping()
    public ResponseEntity<List<Event>> getAll() {
        return ResponseEntity.ok(this.objIEventService.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Event> getById(@PathVariable String id) {
        return ResponseEntity.ok(this.objIEventService.getById(id));
    }

    @PostMapping()
    public ResponseEntity<Event> insert(@RequestBody Event objEvent) {
        return ResponseEntity.ok(this.objIEventService.save(objEvent));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Event> update(@RequestBody Event objEvent, @PathVariable String id) {
        objEvent.setId(id);
        return ResponseEntity.ok(this.objIEventService.update(objEvent));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        this.objIEventService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
