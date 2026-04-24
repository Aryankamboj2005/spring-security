package com.Aryan.Spring_Security.controller;

import com.Aryan.Spring_Security.model.Users;
import com.Aryan.Spring_Security.repo.userRepo;
import com.Aryan.Spring_Security.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userController {
    @Autowired
    private userService service;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    // FOR ENCRYPTING THE PASSWORD HAT STORE IN THE DATABASE and 12 means 12 round of encryption

    @PostMapping("/register")
    public Users register(@RequestBody Users user) {
        user.setPassword(encoder.encode(user.getPassword())); // this is encryt the password
                // and encrypted message is stored in the database
        return service.register(user);
    }
    @PostMapping("/login")
    public String login(@RequestBody Users user) {

    return service.verify(user);
    }
}
