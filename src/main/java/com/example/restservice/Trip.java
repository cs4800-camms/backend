package com.example.restservice;

public class Trip {
    private final long id;
    private final String name;
    private final String destination;

    public Trip(long id, String name, String destination) {
        this.id = id;
        this.name = name;
        this.destination = destination;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDestination() {
        return destination;
    }
}
