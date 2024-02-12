package com.example.middleware2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    @GetMapping("/")
    public String welcome() {
        return "Benvenuto nella nostra applicazione Spring Boot!";
    }

}