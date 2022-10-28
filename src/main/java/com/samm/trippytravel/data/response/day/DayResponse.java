package com.samm.trippytravel.data.response.day;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
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
