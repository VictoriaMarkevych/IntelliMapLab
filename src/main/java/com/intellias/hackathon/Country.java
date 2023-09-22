package com.intellias.hackathon;

import java.util.List;

public class Country {

    private final String name;

    private final List<Coordinate> borders;

    public Country(String name, List<Coordinate> borders) {
        this.name = name;
        this.borders = borders;
    }

    public String getName() {
        return name;
    }

    public List<Coordinate> getBorders() {
        return borders;
    }
}
