package com.intellias.hackathon;

import java.util.List;

class AirportFinderTest {

    Country ukraine = new Country("Ukraine", List.of(
            new Coordinate(0, 0),
            new Coordinate(100, 0),
            new Coordinate(100, 100),
            new Coordinate(0, 100),
            new Coordinate(0, 0)
    ));

    Country hungary = new Country("Hungary", List.of(
            new Coordinate(0, 0),
            new Coordinate(-100, 0),
            new Coordinate(-100, -100),
            new Coordinate(0, -100),
            new Coordinate(0, 0)
    ));

    Country poland = new Country("Poland", List.of(
            new Coordinate(0, 0),
            new Coordinate(-100, 0),
            new Coordinate(-100, 100),
            new Coordinate(0, 100),
            new Coordinate(0, 0)
    ));

    Country romania = new Country("Romania", List.of(
            new Coordinate(0, 0),
            new Coordinate(100, 0),
            new Coordinate(100, -100),
            new Coordinate(0, -100),
            new Coordinate(0, 0)
    ));

}