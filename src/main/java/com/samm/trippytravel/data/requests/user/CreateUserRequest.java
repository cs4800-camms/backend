package com.samm.trippytravel.data.requests.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Builder
@Getter
@AllArgsConstructor
public class CreateUserRequest {
    @NotBlank
    @JsonProperty("firstName")
    private final String firstName;

    @NotBlank
    @JsonProperty("lastName")
    private final String lastName;

    @NotBlank
    @JsonProperty("email")
    private final String email;

    @NotBlank
    @JsonProperty("password")
    private final String password;
}
