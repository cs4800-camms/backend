package com.samm.trippytravel.repo;

import com.samm.trippytravel.data.domain.Trip;
import com.samm.trippytravel.repository.TripRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
@Slf4j
@ExtendWith(MockitoExtension.class)
public class TripRepositoryTest {

    @Autowired
    @Mock
    private TripRepository tripRepository;
    private Trip addedTrip;
    private Trip trip;

    private final String ID ="abcdefg";
    private final long USER_ID = 1;
    private final String NAME = "Family Trip";
    private final String DESTINATION = "Tokyo, Japan";

    @BeforeEach
    void setUp() {
        this.trip = Trip.builder()
                ._id(ID)
                .userId(USER_ID)
                .name(NAME)
                .destination(DESTINATION)
                .build();

        when(tripRepository.insert(trip)).thenReturn(Trip.builder()
                                ._id(ID)
                                .userId(USER_ID)
                                .name(NAME)
                                .destination(DESTINATION)
                                .build());
        this.addedTrip = this.tripRepository.insert(trip);
    }

    @Test
    void isTripAdded() {
        log.info("addedTrip: " + addedTrip.toString());
        assertThat(this.trip).isEqualTo(this.addedTrip);
    }

    @Test
    void isTripDeleted() {
        when(this.tripRepository.deleteById(ID)).thenReturn(Trip.builder()
                ._id(ID)
                .userId(USER_ID)
                .name(NAME)
                .destination(DESTINATION)
                .build());
        Trip deletedTrip = this.tripRepository.deleteById(ID);

        log.info("deletedTrip: " + deletedTrip.toString());
        assertThat(this.addedTrip).isEqualTo(deletedTrip);
    }
}
