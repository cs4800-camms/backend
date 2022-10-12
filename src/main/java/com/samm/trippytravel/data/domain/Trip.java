package com.samm.trippytravel.data.domain;

import lombok.Builder;
import lombok.Value;
import org.springframework.data.mongodb.core.mapping.Document;

@Value
@Builder
@Document("trip")
public class Trip {

    long userId;
    String name;
    String destination;

    public static Trip getTrips(Trip trip) {
        return Trip.builder()
                .userId(trip.getUserId())
                .name(trip.getName())
                .destination(trip.getDestination())
                .build();
    }

}
