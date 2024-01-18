package com.example.es5;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class Controller {

    @GetMapping("/name")
    public String name(@RequestParam String name) {
        return name;
    }

    @PostMapping("/reverse-name")
    public String reverseName(@RequestParam String name) {
        return new StringBuilder(name).reverse().toString();
    }

}