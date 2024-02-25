package com.example.custom1.flight.controllers;

import com.example.custom1.flight.entities.Flight;
import com.example.custom1.flight.entities.Status;
import com.example.custom1.flight.repository.FlightRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/flights")
public class FlightController {
    @Autowired
    private FlightRepo flightRepo;

    @GetMapping("/provision")
    public List<Flight> provisionFlights() {
        List<Flight> flights = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 50; i++) {
            Flight flight = new Flight();
            flight.setDescription("Flight " + i);
            flight.setFromAirport(generateRandomString());
            flight.setToAirport(generateRandomString());
            flight.setStatus(Status.ONTIME);
            flights.add(flight);
        }

        return flightRepo.saveAll(flights);
    }

    @GetMapping("/getAll")
    public List<Flight> getAllFlights() {
        return flightRepo.findAll();
    }

    private String generateRandomString() {
        Random random = new Random();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            char randomChar = alphabet.charAt(random.nextInt(alphabet.length()));
            sb.append(randomChar);
        }

        return sb.toString();
    }
}
