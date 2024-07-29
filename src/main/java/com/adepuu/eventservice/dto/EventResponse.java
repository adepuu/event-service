package com.adepuu.eventservice.dto;

import lombok.Builder;
import lombok.Value;

import java.time.Instant;

@Value
@Builder
public class EventResponse {
  private Integer id;
  private String title;
  private String description;
  private Instant startTime;
  private Instant endTime;
  private VenueResponse venue;
  private CategoryResponse category;
  private Integer organizerId;
  private String coverImage;
}
