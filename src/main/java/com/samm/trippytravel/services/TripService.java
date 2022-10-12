package com.samm.trippytravel.services;

import com.samm.trippytravel.data.domain.Trip;
import com.samm.trippytravel.data.requests.CreateTripRequest;
import com.samm.trippytravel.repository.TripRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TripService {

    private final TripRepository tripRepository;

    public Trip addTrip(CreateTripRequest createTripRequest) {
        return tripRepository.save(Trip.builder()
                .userId(createTripRequest.getUserId())
                .name(createTripRequest.getName())
                .destination(createTripRequest.getDestination())
                .build());
    }

    public List<Trip> getTrips() {
        return new ArrayList<>(tripRepository.findAll());
    }
}
