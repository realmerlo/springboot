package com.example.enviroments1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greetings")
public class Controller {
    @Value("${myCustomVarTree.devName}")
    private String devName;

    @Value("${myCustomVarTree.authCode}")
    private String authCode;

    @GetMapping("/greetings")
    public String greetings() {
        return "Hi, developer " + devName + "auth code is: " + authCode;
    }
}
