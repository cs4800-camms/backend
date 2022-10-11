package com.samm.trippytravel.controllers;

import com.samm.trippytravel.data.Trip;
import com.samm.trippytravel.services.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/trips")
public class TripController {
    private final TripService tripService;

    @GetMapping("/active")
    public ResponseEntity<List<Trip>> getTrips() {
        return tripService.getTrips();
    }

    @PostMapping("/create")
    public ResponseEntity<Trip> createTrip() {
        return tripService.addTrip();
    }

}
