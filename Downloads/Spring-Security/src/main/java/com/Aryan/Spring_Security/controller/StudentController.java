package com.Aryan.Spring_Security.controller;

import com.Aryan.Spring_Security.model.student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class StudentController {

    private List<student> s1=new ArrayList<>(List.of(
           new student("Aryan",1,22),
            new student("kamboj",2,21)

    ));

@GetMapping("/token")
    public CsrfToken token(HttpServletRequest request) {
    return (CsrfToken) request.getAttribute("_csrf");
    // this is used to get the token to add the data

    }

     @GetMapping("/students")
        public List<student> getStudents(){
        return s1;
        }

     @PostMapping("/students")
     public student addStudent(@RequestBody student s){
        s1.add(s);
        return s;
         }



}
