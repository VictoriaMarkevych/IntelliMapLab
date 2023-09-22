package com.intellias.hackathon;

public class Airport {

    private final String name;

    private final Coordinate position;

    public Airport(String name, Coordinate position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public Coordinate getPosition() {
        return position;
    }
}
