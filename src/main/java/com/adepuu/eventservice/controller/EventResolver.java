package com.adepuu.eventservice.controller;

import com.adepuu.eventservice.helpers.JwtClaims;
import lombok.extern.java.Log;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

@Log
@Controller
public class EventResolver {
  @QueryMapping(value = "secrit")
  @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
  public String getSecrit() {
    log.info(JwtClaims.getClaimsFromJwt().toString());
    return "This is a secret message!";
  }
}
