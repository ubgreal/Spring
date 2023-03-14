package com.example.sesiones._5_6.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping ("/hello")
    public String holaMundo(){
        return "Hello World";
    }
}
