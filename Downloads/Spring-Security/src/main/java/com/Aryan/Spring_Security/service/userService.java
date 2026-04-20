package com.Aryan.Spring_Security.service;

import com.Aryan.Spring_Security.model.Users;
import com.Aryan.Spring_Security.repo.userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userService {
    @Autowired
    private userRepo repo;
    public Users register(Users user) {
        return repo.save(user);
    }
}
