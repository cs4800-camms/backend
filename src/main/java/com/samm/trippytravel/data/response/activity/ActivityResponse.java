package com.samm.trippytravel.data.response.activity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@Getter
@AllArgsConstructor
public class ActivityResponse {
    @Id
    @NotBlank
    private final String _id;

    @NotBlank
    private final String day_id;

    @NotNull
    private final boolean checked;

    @NotBlank
    private final String name;

    @NotBlank
    private final String location;
}
