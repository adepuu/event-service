package com.adepuu.eventservice.service;

import com.adepuu.eventservice.dto.EventResponse;
import com.adepuu.eventservice.entity.Event;
import com.adepuu.eventservice.mapper.EventMapper;
import com.adepuu.eventservice.repository.EventRepo;
import com.adepuu.eventservice.spec.EventListSpec;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

  private final EventRepo eventRepository;
  private final EventMapper eventMapper;

  public EventService(EventRepo eventRepository, EventMapper eventMapper) {
    this.eventRepository = eventRepository;
    this.eventMapper = eventMapper;
  }

  public Page<EventResponse> getAllEvents(Pageable pageable, String eventName, Integer categoryId, Integer organizerId) {
    Specification<Event> specification = Specification.where(EventListSpec.byEventName(eventName).and(EventListSpec.byCategoryId(categoryId)).and(EventListSpec.byOrganizerId(organizerId)));
    Page<Event> events = eventRepository.findAll(specification, pageable);
    List<EventResponse> eventList = events.getContent().stream()
            .map(eventMapper::eventToEventResponse)
            .toList();
    return new PageImpl<>(eventList, pageable, events.getTotalElements());
  }
}
