package com.example.custom2.flight.controllers;

import com.example.custom2.flight.entities.Flight;
import com.example.custom2.flight.entities.Status;
import com.example.custom2.flight.repository.FlightRepo;
import com.example.custom2.flight.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/flights")
public class FlightController {
    @Autowired
    private FlightService flightService;

    @GetMapping("/show/list")
    public List<Flight> showList() {
        return flightService.findAll();
    }

    @GetMapping("/generate/list")
    public List<Flight> generateList(@RequestParam(name = "n", defaultValue = "100") int n) {
        return flightService.findAllProvision(n);
    }

    @GetMapping("/show/on-time")
    public List<Flight> showOnTime() {
        return flightService.findOnTimeFlights();
    }

    @GetMapping("/paged")
    public Page<Flight> getPagedFlights(@RequestParam(name = "page", defaultValue = "0") int page,
                                        @RequestParam(name = "size", defaultValue = "10") int size) {
        return flightService.getPagedFlights(page, size);
    }

    @GetMapping("/show/delayedcancelled")
    public List<Flight> getDelayedOrCancelledFlights() {
        return flightService.getDelayedOrCancelledFlights();
    }

    @GetMapping("/show/customstatus")
    public List<Flight> getCustomStatusFlights(@RequestParam(name = "p1") String p1,
                                               @RequestParam(name = "p2") String p2) {
        Status status1 = Status.valueOf(p1); // Converte la stringa in Status
        Status status2 = Status.valueOf(p2); // Converte la stringa in Status
        return flightService.getCustomStatusFlights(status1, status2);
    }
}
