package com.example.es2;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v2")

public class Controller {
    @GetMapping(path= "/ciao/{provincia}")
    public User1 wewe(
            @PathVariable String provincia,
            @RequestParam (value = "nome") String nome){

        String saluto = "Ciao " + nome + ", com'è il tempo in " + provincia + " ?";

        return new User1 (nome, provincia, saluto);

    }
}