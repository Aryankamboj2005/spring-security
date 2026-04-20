package com.Aryan.Spring_Security.service;

import com.Aryan.Spring_Security.model.UserPrinciple;
import com.Aryan.Spring_Security.model.Users;
import com.Aryan.Spring_Security.repo.userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailSeavice implements UserDetailsService {
    @Autowired
    private userRepo Repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users  user =  Repo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        return new UserPrinciple(user);
    }
}
