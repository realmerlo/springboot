package com.example.custom2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    private Environment environment;

    @GetMapping
    public String deploy(){
        return environment.getRequiredProperty("myCustomVarTree.customVar");
    }
}
