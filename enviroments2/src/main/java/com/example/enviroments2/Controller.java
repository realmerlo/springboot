package com.example.enviroments2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greetings")
public class Controller {
    @Autowired
    private Enviroments2Application environmentVariables2Application;

    @Value("${myCustomVarTree.welcomeMsg}")
    private String welcomeMsg;

    @GetMapping("/greeting")
    public String greeting() {
        return welcomeMsg;
    }
}
