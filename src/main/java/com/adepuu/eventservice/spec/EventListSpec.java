package com.adepuu.eventservice.spec;

import com.adepuu.eventservice.entity.Category;
import com.adepuu.eventservice.entity.Event;
import com.adepuu.eventservice.entity.User;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

public class EventListSpec {

  public static Specification<Event> byEventName(String eventName){
    return ((root, query, cb) -> {
      if(eventName == null){
        return cb.conjunction();
      }
      if(eventName.isEmpty()){
        return cb.equal(root.get("eventName"),"");
      }
      return cb.like(cb.lower(root.get("name")),"%" + eventName.toLowerCase() + "%");
    });
  }

  public static Specification<Event> byCategoryId(Integer categoryId){
    return((root, query, cb) -> {
      if(categoryId == null){
        return cb.conjunction();
      }
      Join<Event, Category> categoryJoin = root.join("category", JoinType.LEFT);
      return cb.equal(categoryJoin.get("id"), categoryId);
    });
  }

  public static Specification<Event> byOrganizerId(Integer organizerId){
    return((root, query, cb) -> {
      if(organizerId == null){
        return cb.conjunction();
      }
      Join<Event, User> categoryJoin = root.join("organizer", JoinType.LEFT);
      return cb.equal(categoryJoin.get("organizer_id"), organizerId);
    });
  }
}
