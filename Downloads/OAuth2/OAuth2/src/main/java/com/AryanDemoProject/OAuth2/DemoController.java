package com.AryanDemoProject.OAuth2;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/")
    public String greet() {
        return "Welcome to OAuth2 Login Demo!";
    }
}
