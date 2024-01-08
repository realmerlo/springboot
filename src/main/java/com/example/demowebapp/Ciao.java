package com.example.demowebapp;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class Ciao {
    @GetMapping(path = "/Ciao")
    public String ciao ( @RequestParam String nome, @RequestParam String provincia){
        return "Ciao " + nome + " , com'è il tempo in " + provincia + " ?";
    }
}
//Scrivi una applicazione web Spring Boot
// che alla endpoint GET v1/ciao?nome=Giuseppe&provincia=Lombardia risponde con
// "Ciao Giuseppe, com'è il tempo in Lombardia?"