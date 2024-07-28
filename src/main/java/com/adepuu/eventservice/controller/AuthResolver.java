package com.adepuu.eventservice.controller;

import com.adepuu.eventservice.dto.LoginResponse;
import com.adepuu.eventservice.service.AuthService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class AuthResolver {
    private final AuthService authService;

    public AuthResolver(AuthService authService) {
        this.authService = authService;
    }

    @MutationMapping(value = "login")
    public LoginResponse create(@Argument String username, @Argument String password) {
        return authService.usernameAndPasswordLogin(username, password);
    }
}
