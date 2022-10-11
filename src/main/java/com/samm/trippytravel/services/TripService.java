package com.samm.trippytravel.services;

import com.samm.trippytravel.data.Trip;
import com.samm.trippytravel.repository.TripRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TripService {

    private final TripRepository tripRepository;

    public ResponseEntity<Trip> addTrip() {

        Trip trip = Trip.builder()
                .id(1)
                .name("Family Trip")
                .destination("Tokyo, Japan")
                .build();

        tripRepository.save(trip);

        return new ResponseEntity<>(trip, HttpStatus.OK);
    }

    public ResponseEntity<List<Trip>> getTrips() {

        List<Trip> trips = new ArrayList<>(tripRepository.findAll());

        return new ResponseEntity<>(trips, HttpStatus.OK);
    }
}
