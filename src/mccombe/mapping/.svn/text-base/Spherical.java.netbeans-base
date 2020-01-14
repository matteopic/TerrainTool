/*
 * Spherical.java
 *
 * Created on 16 July 2005, 13:07
 *
 * This is a simple spherical coordinate system using latitude and longitude to define position
 *
 */

package mccombe.mapping;

/**
 * Spherical Coordinates - an implementation of positional coordinates based on 
 * Latitude and Longitude. Whilst often not explicitly stated in practice, these
 * are relative to a specified datum and ellipsoid.
 * @author Mike McCombe
 */
public class Spherical extends CoordinateSystem {
    
    /** Creates a new instance of Spherical */
    protected Spherical() {
    }
    
    /**
     * Create a new Spherical Coordinate set based on Lat/Lon, the Ellipsoid and Datum
     * @param latLon A LatLong object containing the Latitude and Longitude of the point
     * @param e The Ellipsoid used to define Lat & Lon
     * @param d The Datum used to determine the Lat / Lon
     */
    public Spherical(LatLong latLon, Ellipsoid e, Datum d){
        super(new Position(latLon, 0.0, e, d), e, d);
    }
    /**
     * Create a new Spherical Coordinate set based on a specific Position, Ellipsoid and Datum
     * @param p The Position
     * @param e The Ellipsoid to use when translating this Position
     * @param d The Datum to use when representing this point.
     */
    public Spherical(Position p, Ellipsoid e, Datum d){
        super(p, e, d);
    }
    
    /**
     * Define the DefaultDatum for this coordinate set
     * @return The Default Datum
     */
    public Datum defaultDatum() {
        return Datum.WGS_1984 ;
    }
    
    /**
     * Define the Default Ellipsoid for this point
     * @return The Default Ellipsoid
     */
    public Ellipsoid defaultEllipsoid() {
        return  Ellipsoid.GRS80 ;
    }
    /**
     * Provide a String representing this coordinate set
     * @return The String representation of the coordinates (in Lat/Lon format)
     */
    public String toString() {
        LatLong geog = locus.toLatLong(sph, ref);
        return geog.toString();
    }
}
