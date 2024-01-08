package com.example.es1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class ciao {
    @GetMapping(path = "ciao")
    public String ciao(String nome, String provincia) {
        return "Ciao " + nome + ", com'è il tempo in " + provincia + " ?";
    }
}

//Scrivi una applicazione web Spring Boot che alla endpoint
// GET v1/ciao?nome=Giuseppe&provincia=Lombardia risponde con "Ciao Giuseppe, com'è il tempo in Lombardia?"