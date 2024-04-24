package com.riwi.events.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.events.entities.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, String> {
}
