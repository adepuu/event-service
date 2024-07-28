package com.adepuu.eventservice.dto;

import com.adepuu.eventservice.entity.UserRoles;
import lombok.Data;
import org.springframework.graphql.data.method.annotation.SchemaMapping;

@Data
@SchemaMapping(typeName = "User")
public class RegisterResponse {
    private String id;
    private String username;
    private String email;
    private UserRoles role;
}
