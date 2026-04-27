package com.AryanDemoProject.OAuth2;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/")
    public String greet() {
        return "Welcome to the Public Home Page!";
    }

    @GetMapping("/secured")
    public String secured() {
        return "Congratulations! You have accessed a secured endpoint via OAuth2.";
    }
}
