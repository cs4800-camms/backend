package com.samm.trippytravel.repo;

import com.samm.trippytravel.data.domain.Trip;
import com.samm.trippytravel.repository.TripRepository;
import org.junit.jupiter.api.BeforeEach;
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

    private Trip addedTrip;

    @BeforeEach
    void setUp() {
        this.addedTrip = tripRepository.insert(Trip.builder()
                .userId(1)
                .name("Family Trip")
                .destination("Tokyo, Japan")
                .build());
    }

    @Test
    void isTripAdded() {
        assertThat(Trip.builder()
                ._id(addedTrip.get_id())
                .userId(addedTrip.getUserId())
                .name(addedTrip.getName())
                .destination(addedTrip.getDestination())
                .build())
                .isEqualTo(addedTrip);
    }

    @Test
    void isTripDeleted() {
        Trip deletedTrip = tripRepository.deleteById(addedTrip.get_id());
        assertThat(addedTrip).isEqualTo(deletedTrip);
    }
}
