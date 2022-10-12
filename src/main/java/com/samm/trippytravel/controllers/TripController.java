package com.samm.trippytravel.controllers;

import com.samm.trippytravel.data.domain.Trip;
import com.samm.trippytravel.data.requests.CreateTripRequest;
import com.samm.trippytravel.repository.TripRepository;
import com.samm.trippytravel.services.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/trips")
public class TripController {
    private final TripService tripService;
    private final TripRepository tripRepository;

    @GetMapping("/active")
    public ResponseEntity<List<Trip>> getTrips() {
        return new ResponseEntity<>(tripService.getTrips(), HttpStatus.OK);
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<Trip> createTrip(
            @RequestBody CreateTripRequest createTripRequest) {
        return new ResponseEntity<>(tripService.addTrip(createTripRequest), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public void deleteTrip() {
        tripRepository.deleteAll();
    }

}
