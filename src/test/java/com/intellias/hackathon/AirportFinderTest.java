package com.intellias.hackathon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.locationtech.jts.util.Assert;
import java.util.List;

class AirportFinderTest {
    private AirportFinder airportFinder;
    private List<Country> countries;
    private List<Airport> airports;

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
    Airport airport = new Airport("airportInUkraine1", new Coordinate(50,50));
    Airport airport1 = new Airport("airportInUkraine2", new Coordinate(4,2));
    Airport airport2 = new Airport("airportInPoland1", new Coordinate(-50,50));
    Airport airport3 = new Airport("airportInPoland2", new Coordinate(-4,2));

    @BeforeEach
    void setUp() {
        countries = List.of(ukraine,poland, hungary, romania);
        airports = List.of(airport, airport1, airport2, airport3);
        airportFinder = new AirportFinder(countries, airports);
    }

    @Test
    void findNearestAirport_UKFirstAirport_Ok() {
        Assert.equals(airportFinder.findNearestAirport(new Coordinate(55,55)).orElseThrow().getName(), airport.getName());
    }

    @Test
    void findNearestAirport_UKSecondAirport_Ok() {
        Assert.equals(airportFinder.findNearestAirport(new Coordinate(15,15)).orElseThrow().getName(), airport1.getName());
    }

    @Test
    void findNearestAirport_PolandFirstAirport_Ok() {
        Assert.equals(airportFinder.findNearestAirport(new Coordinate(-55,55)).orElseThrow().getName(), airport2.getName());
    }

    @Test
    void findNearestAirport_PolandSecondAirport_Ok() {
        Assert.equals(airportFinder.findNearestAirport(new Coordinate(-15,15)).orElseThrow().getName(), airport3.getName());
    }


}