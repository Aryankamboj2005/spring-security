package com.example.demo;

import org.springframework.stereotype.Component;

@Component // use to tell the spring that you have to make the object of
           // this  class so that we can easly used it.
public class HELLO {
    public String hlo(){
        return "Hello World!";
    }
}
