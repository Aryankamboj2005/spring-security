package com.Aryan.Spring_Security.controller;

import com.Aryan.Spring_Security.model.Users;
import com.Aryan.Spring_Security.repo.userRepo;
import com.Aryan.Spring_Security.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userController {
    @Autowired
    private userService service;
    @PostMapping("/register")
    public Users register(@RequestBody Users user) {
        return service.register(user);
    }
}
