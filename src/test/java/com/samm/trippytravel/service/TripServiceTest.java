package com.samm.trippytravel.service;

import com.samm.trippytravel.data.domain.Trip;
import com.samm.trippytravel.data.requests.CreateTripRequest;
import com.samm.trippytravel.repository.TripRepository;
import com.samm.trippytravel.services.TripService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.verify;

@SpringBootTest
public class TripServiceTest {

    @Mock
    private TripRepository tripRepository;

    private TripService tripService;

    private CreateTripRequest createTripRequest;

    private Trip trip;

    @BeforeEach
    void setUp() {
        this.tripService = new TripService(this.tripRepository);
        this.createTripRequest= CreateTripRequest.builder()
                .userId(3)
                .name("Mary")
                .destination("Rome")
                .build();
        this.trip = Trip.builder()
                .userId(3)
                .name("Mary")
                .destination("Rome")
                .build();
    }

    @Test
    void getTrips() {
        tripService.getTrips();
        verify(tripRepository).findAll();
    }

    @Test
    void addTrip() {
        tripService.addTrip(createTripRequest);
        verify(tripRepository).insert(trip);
    }
}
