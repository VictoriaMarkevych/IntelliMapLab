package com.intellias.hackathon;

import org.locationtech.jts.geom.GeometryFactory;

import java.util.List;

/**
 * Wrapper for JTS Polygon class. It can check point coverage by polygon.
 */
public class Polygon {

    private static final GeometryFactory GEOMETRY_FACTORY = new GeometryFactory();
    private final org.locationtech.jts.geom.Polygon polygon;

    /**
     * Create polygon based on coordinates.
     * @param coordinates list of coordinate, last coordinate should be equal to first to create polygon
     */
    public Polygon(List<Coordinate> coordinates) {
        this.polygon = GEOMETRY_FACTORY.createPolygon(coordinates
                .stream()
                .map(Polygon::convertCoordinate)
                .toArray(org.locationtech.jts.geom.Coordinate[]::new));
    }

    /**
     * If provided coordinate is located inside polygon then returns true
     * @param coordinate coordinate that need to be checked
     * @return information about coordinate coverage by polygon
     */
    public boolean isCoordinateInside(Coordinate coordinate) {
        return polygon.covers(GEOMETRY_FACTORY.createPoint(convertCoordinate(coordinate)));
    }

    private static org.locationtech.jts.geom.Coordinate convertCoordinate(Coordinate coordinate) {
        return new org.locationtech.jts.geom.Coordinate(coordinate.getX(), coordinate.getY());
    }
}
