package com.adepuu.eventservice.controller;

import com.adepuu.eventservice.dto.RegisterRequest;
import com.adepuu.eventservice.dto.RegisterResponse;
import com.adepuu.eventservice.service.UserService;
import lombok.extern.java.Log;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Log
@Controller
public class UserResolver {
    private final UserService userService;

    public UserResolver(UserService userService) {
        this.userService = userService;
    }

    @MutationMapping(value = "createUser")
    public RegisterResponse create(@Argument RegisterRequest input) {
        log.info("Handling request for user with username: " + input.getUsername() + " and email: " + input.getEmail());
        return userService.register(input.getUsername(), input.getPassword(), input.getEmail());
    }
}
