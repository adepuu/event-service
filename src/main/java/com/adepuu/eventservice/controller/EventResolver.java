package com.adepuu.eventservice.controller;

import com.adepuu.eventservice.dto.EventListResponse;
import com.adepuu.eventservice.helpers.JwtClaims;
import com.adepuu.eventservice.service.EventService;
import lombok.extern.java.Log;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

@Log
@Controller
public class EventResolver {
  private final EventService eventService;

  public EventResolver(EventService eventService) {
    this.eventService = eventService;
  }

  @QueryMapping(value = "events")
  public EventListResponse getEvents(@Argument Integer page, @Argument Integer size, @Argument String sort, @Argument String eventName, @Argument Integer categoryId, @Argument Integer organizerId) {
    Pageable pageable = PageRequest.of(page, size);
    log.info("Handling request for events with page: " + page + " and size: " + size);
    var result = eventService.getAllEvents(pageable, eventName, categoryId, organizerId);
    log.info("Returning " + result.getTotalElements() + " events");
    var resp = new EventListResponse();
    resp.setEvents(result.getContent());
    resp.setPageSize(result.getSize());
    resp.setCurrentPage(result.getNumber());
    resp.setTotalPages(result.getTotalPages());
    resp.setTotalEvents((int) result.getTotalElements());
    resp.setHasNext(result.hasNext());
    resp.setHasPrevious(result.hasPrevious());

    return resp;
  }

  @QueryMapping(value = "secrit")
  @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
  public String getSecrit() {
    log.info(JwtClaims.getClaimsFromJwt().toString());
    return "This is a secret message!";
  }
}
