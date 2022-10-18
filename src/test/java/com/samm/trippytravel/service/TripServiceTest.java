package com.samm.trippytravel.service;

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

    @BeforeEach
    void setUp() {
        this.tripService = new TripService(this.tripRepository);
    }

    @Test
    void getTrips() {
        tripService.getTrips();
        verify(tripRepository).findAll();
    }
}
