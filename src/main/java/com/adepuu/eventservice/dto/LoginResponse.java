package com.adepuu.eventservice.dto;

import com.adepuu.eventservice.entity.UserRoles;
import lombok.Data;
import org.springframework.graphql.data.method.annotation.SchemaMapping;

@Data
@SchemaMapping(typeName = "AuthPayload")
public class LoginResponse {
    private String token;
    private UserRoles role;
}
