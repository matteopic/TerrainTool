/*
 * ENPair.java
 *
 * Created on 05 July 2005, 16:56
 *
 */

package mccombe.mapping;

/**
 * An ENPair represents a 2-dimensional coordinate pair used to define position on
 * a map in terms of "easting" and "northing" distances.
 * @author Mike McCombe
 */
public class ENPair {
    
    /** Creates a new instance of ENPair */
    public ENPair() {
    }
    /**
     * Create an ENPair from two double values
     * @param east Easting distance (m)
     * @param north Northing distance (m)
     */
    public ENPair(double east, double north){
        x = east ;
        y = north ;
    }
    /**
     * Provide a String representation of the ENPair
     * @return A String showing Easting and Northing distances
     */
    public String toString() { return String.format("%9.0f %9.0f",x,y);}
    /**
     * Access the Easting distance
     * @return the Easting distance(m)
     */
    public double east() { return x ; }
    /**
     * Access the Northing distance
     * @return the Northing distance (m)
     */
    public double north() { return y ; }
    private double x = 0.0 ;
    private double y = 0.0 ;
}
