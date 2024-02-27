package com.example.custom1.flight.service;

import com.example.custom1.flight.entities.Flight;
import com.example.custom1.flight.entities.Status;
import com.example.custom1.flight.repository.FlightRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class FlightService {
    @Autowired
    private FlightRepo flightRepo;

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

        flightRepo.saveAllCustom(flights);
        System.out.println("**Volo generati e salvati con successo!**");
        return flights;
    }

    public List<Flight> getAllFlights() {
        return flightRepo.findFlights();
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
