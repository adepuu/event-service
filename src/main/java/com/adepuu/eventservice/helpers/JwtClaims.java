package com.adepuu.eventservice.helpers;

import lombok.extern.java.Log;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.Map;

@Log
public class JwtClaims {
  public static Map<String, Object> getClaimsFromJwt() {
    SecurityContext context = SecurityContextHolder.getContext();
    Authentication authentication = context.getAuthentication();

    log.info(authentication.toString());
    Jwt jwt = (Jwt) authentication.getPrincipal();
    return jwt.getClaims();
  }
}