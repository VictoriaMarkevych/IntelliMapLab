package com.intellias.hackathon;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class AirportFinder {
    private List<Country> countries;
    private List<Airport> airports;
    public AirportFinder(List<Country> countries, List<Airport> airports) {
        this.countries = countries;
        this.airports = airports;
    }

    /**
     * Should find the nearest airport in the specific country by coordinate
     *
     * @param coordinate location from which distance should be measured
     * @return found POI or empty optional if there is no such airport
     */
    public Optional<Airport> findNearestAirport(Coordinate coordinate) {
        Optional<Country> country = countries.stream()
                .filter(c -> new Polygon(c.getBorders()).isCoordinateInside(coordinate))
                .findAny();

        List<Airport> airportsInsideCounrty = airports.stream()
                .filter(a -> new Polygon(country.orElseThrow().getBorders()).isCoordinateInside(a.getPosition()))
                .collect(Collectors.toList());

        OptionalDouble min = airportsInsideCounrty.stream()
                .mapToDouble(a -> Math.sqrt(Math.pow(a.getPosition().getX() - coordinate.getX(), 2) +
                        Math.pow(a.getPosition().getY() - coordinate.getY(), 2)))
                .min();
        Optional<Airport> airport = airportsInsideCounrty.stream()
                .filter(a -> Math.sqrt(Math.pow(a.getPosition().getX() - coordinate.getX(), 2) +
                        Math.pow(a.getPosition().getY() - coordinate.getY(), 2)) == min.getAsDouble())
                .findAny();

        return airport;
    }
}
