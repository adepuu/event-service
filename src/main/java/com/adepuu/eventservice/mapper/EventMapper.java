package com.adepuu.eventservice.mapper;

import com.adepuu.eventservice.dto.EventResponse;
import com.adepuu.eventservice.entity.Event;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EventMapper {
  @Mapping(target = "organizerId", source = "organizer.id")
  EventResponse eventToEventResponse(Event event);
}