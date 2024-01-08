package com.example.es2;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v2")

public class ciao {
    @GetMapping(path= "/ciao/{provincia}")
    public User ciao(
            @PathVariable String provincia,
            @RequestParam String nome){

        return new User (nome, provincia);
    }
}