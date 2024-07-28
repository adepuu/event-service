package com.adepuu.eventservice.dto;

import lombok.Data;
import org.springframework.graphql.data.method.annotation.SchemaMapping;

@Data
@SchemaMapping(typeName = "CreateUserInput")
public class RegisterRequest {
    private String username;
    private String email;
    private String password;
}
