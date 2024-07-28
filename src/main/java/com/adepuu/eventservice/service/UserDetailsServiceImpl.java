package com.adepuu.eventservice.service;

import com.adepuu.eventservice.entity.AuthUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserService userSvc;

    public UserDetailsServiceImpl(UserService userSvc) {
        this.userSvc = userSvc;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var userData = userSvc.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new AuthUserDetails(
                userData.getUsername(),
                userData.getPassword(),
                userData.getRole()
        );
    }
}

