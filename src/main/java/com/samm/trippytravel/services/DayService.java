package com.samm.trippytravel.services;

import com.samm.trippytravel.data.domain.Day;
import com.samm.trippytravel.data.requests.day.CreateDayRequest;
import com.samm.trippytravel.data.response.day.DayResponse;
import com.samm.trippytravel.repository.DayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DayService {
    private final DayRepository dayRepository;

    public DayResponse addDay(CreateDayRequest createDayRequest) {
        return toDayResponse(dayRepository.insert(Day.builder()
                .trip_id(createDayRequest.getTrip_id())
                .name(createDayRequest.getName())
                .date(createDayRequest.getDate())
                .build()));
    }

    public List<DayResponse> getDaysForTrip(String tripIdNumber) {
        return toListDayResponse(dayRepository.getDaysByTripId(tripIdNumber));
    }

    public DayResponse deleteDay(String dayIdNumber) {
        return toDayResponse(dayRepository.deleteById(dayIdNumber));
    }

    private DayResponse toDayResponse(Day day) {
        return DayResponse.builder()
                ._id(day.get_id())
                .trip_id(day.getTrip_id().toString())
                .name(day.getName())
                .date(day.getDate())
                .build();
    }

    private List<DayResponse> toListDayResponse(List<Day> dayList) {
        return dayList.stream()
                .map(this::toDayResponse)
                .collect(toList());
    }
}
