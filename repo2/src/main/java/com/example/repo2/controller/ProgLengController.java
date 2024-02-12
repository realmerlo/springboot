package com.example.repo2.controller;

import com.example.repo2.entities.ProgLenguage;
import com.example.repo2.repository.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/progLeng")
public class ProgLengController {

    @Autowired
    private Repo repo;

    @PostMapping("/createLenguage")
    public ProgLenguage createLenguage(@RequestBody ProgLenguage lenguageToAdd) {
        ProgLenguage lenguage = repo.saveAndFlush(lenguageToAdd);
        return lenguage;
    }
}
