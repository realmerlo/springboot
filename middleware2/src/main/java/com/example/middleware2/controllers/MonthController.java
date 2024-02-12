package com.example.middleware2.controllers;

import com.example.middleware2.entities.Month;
import com.example.middleware2.fakeDB.FakeDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/months")
public class MonthController {

    @Autowired
    private FakeDB fakeDB;

    @GetMapping("/get")
    public ResponseEntity<Month> getMonth(@RequestHeader(name = "monthNumber", required = false) int monthNumber) {
        if (monthNumber < 1 || monthNumber > 12) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Month foundMonth = fakeDB.findMonth(monthNumber);

        if (foundMonth != null) {
            return ResponseEntity.ok(foundMonth);
        }
        return null;
    }
}