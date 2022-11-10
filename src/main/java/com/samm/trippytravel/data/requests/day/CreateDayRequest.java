package com.samm.trippytravel.data.requests.day;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.bson.types.ObjectId;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Builder
@Getter
@AllArgsConstructor
public class CreateDayRequest {
    @NotBlank
    @JsonProperty("trip_id")
    private final ObjectId trip_id;

    @NotBlank
    @JsonProperty("name")
    private final String name;

    @NotBlank
    @JsonProperty("date")
    private final Date date;
}
