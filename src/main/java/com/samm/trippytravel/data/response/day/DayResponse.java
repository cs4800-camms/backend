package com.samm.trippytravel.data.response.day;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Builder
@Getter
@AllArgsConstructor
public class DayResponse {
    @Id
    @NotBlank
    private final String _id;

    @NotBlank
    private final String trip_id;

    @NotBlank
    private final String name;

    @NotBlank
    private final Date date;
}
