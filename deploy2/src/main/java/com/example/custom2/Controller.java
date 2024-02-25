package com.example.custom2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class Controller {
    @GetMapping("/sum")
    public String getSum() {
        int a = (int) (Math.random() * 100);
        int b = (int) (Math.random() * 100);
        return "La somma di " + a + " + " + b + " = " + (a + b);
    }
}
