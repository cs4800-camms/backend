package com.samm.trippytravel.data;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class TripList {

    List<TripDetails> createdTrips;

    public static TripList getTrips(TripList list) {
        return TripList.builder()
                .createdTrips(list.getCreatedTrips())
                .build();
    }

}
