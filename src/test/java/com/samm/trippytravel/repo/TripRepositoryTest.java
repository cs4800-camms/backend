package com.samm.trippytravel.repo;

import com.samm.trippytravel.data.domain.Trip;
import com.samm.trippytravel.repository.TripRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TripRepositoryTest {

    @Autowired
    @Mock
    private TripRepository tripRepository;

    @Test
    void isTripAdded() {
        Trip trip = Trip.builder()
                .userId(1)
                .name("Family Trip")
                .destination("Tokyo, Japan")
                .build();

        Trip addedTrip = tripRepository.insert(trip);

        assertThat(Trip.builder()
                ._id(addedTrip.get_id())
                .userId(addedTrip.getUserId())
                .name(addedTrip.getName())
                .destination(addedTrip.getDestination())
                .build())
                .isEqualTo(addedTrip);
    }
}
