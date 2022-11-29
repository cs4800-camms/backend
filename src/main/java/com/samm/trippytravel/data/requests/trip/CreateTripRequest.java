package com.samm.trippytravel.data.requests.trip;

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
public class CreateTripRequest {
    @NotBlank
    @JsonProperty("userId")
    private final ObjectId userId;

    @NotBlank
    @JsonProperty("name")
    private final String name;

    @NotBlank
    @JsonProperty("destination")
    private final String destination;

    @NotBlank
    @JsonProperty("startDate")
    private final Date startDate;

    @NotBlank
    @JsonProperty("endDate")
    private final Date endDate;
}
