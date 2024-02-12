package com.example.middleware.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
@RestController
@RequestMapping("/time")
public class BaseController {

    @GetMapping
    public String getCurrentTime() {
        return "Data/Ora corrente: " + LocalDateTime.now();
    }
}