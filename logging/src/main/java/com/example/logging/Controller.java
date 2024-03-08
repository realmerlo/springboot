package com.example.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1)")
public class Controller {
    private final Logger logger = LoggerFactory.getLogger(Controller.class);

    @Autowired
    Environment environment;

    @GetMapping("/welcome")
    public String welcome() {
        logger.info("Welcome message requested");
        return "Welcome to Custom Logging Application";
    }

    @GetMapping("/exp")
    public ResponseEntity<Double[]> calculateExponent() {
        logger.debug("Calcolo iniziato");
        int number1 = Integer.parseInt(environment.getProperty("CustomVar.number1", "2"));
        int number2 = Integer.parseInt(environment.getProperty("CustomVar.number2", "8"));
        double result1 = Math.pow(number1, 2);
        double result2 = Math.pow(number2, 2);
        logger.debug("Calcolo finito");
        return ResponseEntity.ok(new Double[]{result1, result2});
    }

    @GetMapping("/get-errors")
    public ResponseEntity<String> getErrors() {
        logger.error("Errore a caso");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errore");
    }
}
