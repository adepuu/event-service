package com.adepuu.eventservice.repository;

import com.adepuu.eventservice.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EventRepo extends JpaRepository<Event, Integer>, JpaSpecificationExecutor<Event> {
}
