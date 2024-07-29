package com.adepuu.eventservice.entity;

import lombok.Data;
import lombok.extern.java.Log;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

@Log
@Data
public class AuthUserDetails implements UserDetails {
    private final String username;
    private final String password;
    private final UserRoles role;

     @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList<GrantedAuthority> authorities = new ArrayList<>();

        authorities.add(() -> this.getRole().toString());
        log.info("Authorities: " + authorities.toString());
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }
}
