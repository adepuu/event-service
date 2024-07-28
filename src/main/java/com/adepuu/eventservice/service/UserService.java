package com.adepuu.eventservice.service;

import com.adepuu.eventservice.dto.RegisterResponse;
import com.adepuu.eventservice.entity.User;
import com.adepuu.eventservice.entity.UserRoles;
import com.adepuu.eventservice.repository.UserRepo;
import lombok.extern.java.Log;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Log
@Service
public class UserService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepo userRepo, @Lazy PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<User> findByUsername(String email) {
        return userRepo.findByUsername(email);
    }

    public RegisterResponse register(String username, String password, String email) {
        log.info("Registering user with username: " + username + " and email: " + email);
        String encodedPassword = passwordEncoder.encode(password);
        User user = new User();
        user.setUsername(username);
        user.setPassword(encodedPassword);
        user.setEmail(email);
        user.setRole(UserRoles.USER);
        userRepo.save(user);
        var newUser = new RegisterResponse();
        newUser.setId(user.getId().toString());
        newUser.setUsername(user.getUsername());
        newUser.setEmail(user.getEmail());
        newUser.setRole(user.getRole());
        return newUser;
    }
}
