package com.example.restservice;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Trip {

    private final long id;
    private final String name;
    private final String destination;
}
