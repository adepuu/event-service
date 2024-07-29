package com.adepuu.eventservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class EventListResponse {
  private List<EventResponse> events;
  private Integer pageSize;
  private Integer currentPage;
  private Integer totalPages;
  private Integer totalEvents;
  private Boolean hasNext;
  private Boolean hasPrevious;
}
