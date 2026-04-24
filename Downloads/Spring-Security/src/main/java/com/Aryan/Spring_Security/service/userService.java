package com.Aryan.Spring_Security.service;

import com.Aryan.Spring_Security.model.Users;
import com.Aryan.Spring_Security.repo.userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class userService {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    private userRepo repo;
    public Users register(Users user) {
        return repo.save(user);
    }

    public String verify(Users user) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
              // check the user name and the password

        if(authentication.isAuthenticated()) { // check if user exist or not
            return "success";
        }
        else{
            return "fail";
        }
    }
}
