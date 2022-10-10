package com.samm.trippytravel.data;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class TripDetails {

    List<DayDetails> tripDays;

}
