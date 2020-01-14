/*
 * Lambert93.java
 *
 * Created on 24 October 2006, 22:49
 *
 */

package mccombe.mapping;

/**
 * A non-abstract class implementing the Lambert Conformal Conical (LCC) projection
 * for the French Lambert-93 system. Unlike previous French LCC implementations, this one
 * uses GRS80/WGS84 ellipsoid and datum by default.
 *
 * @author Mike McCombe
 */
public class Lambert93 extends Lambert{
    
    /**
     * Create an instance of Lambert93 from Position, Ellipsoid and Datum
     * @param p the position of this point
     * @param e The Ellipsoid to use
     * @param d The datum to be used
     */
    public Lambert93(Position p, Ellipsoid e, Datum d){
        super(p, e, d);
    }
    /**
     * Create an instance of Lambert93 from easting and northing distances, Ellipsoid and Datum
     * @param en Easting and Northing distances
     * @param e Ellipsoid to use
     * @param d Datum to use
     */
    public Lambert93(ENPair en, Ellipsoid e, Datum d){
        super(en, e, d);
    }
    /**
     * Static factory method to create an instance of Lambert93 from a grid reference String
     * @param gridref A grid reference of the form "X=... Y=..." where the values are easting and
     * northing distances in km.
     * @param e Ellipsoid to use in conversions
     * @param d Datum to use in conversions
     * @throws mccombe.mapping.GridFormatException thrown in case of format error in the grid reference
     * @return A new LambertI instance
     */
    public static Lambert93 makePoint(String gridref, Ellipsoid e, Datum d)throws GridFormatException {
        ENPair en = getEN(gridref);
        return new Lambert93(en, e, d);
    }
    /**
     * Define default Datum for this system
     * @return the default Datum (Datum.WGS_1984)
     */
    public mccombe.mapping.Datum defaultDatum() { return Datum.WGS_1984 ; }
    /**
     * Define the default Ellipsoid for this system
     * @return the default Ellipsoid (Ellipsoid.GRS80)
     */
    public mccombe.mapping.Ellipsoid defaultEllipsoid() { return Ellipsoid.GRS80 ; }
    
    // Projection constants
    /**
     * Define Upper standard parallel for this conical projection
     * @return Upper Standard Parallel (radians)
     */
    protected double phiU() { return Math.toRadians(49.0);}  //Upper parallel
    /**
     * Define lower standard parallel for this projection
     * @return Lower Standard Parallel (radians)
     */
    protected double phiL() { return Math.toRadians(44.0);}  //Lower parallel
    /**
     * Define latitude of false origin
     * @return Latitude of false origin (radians)
     */
    protected double phiB() { return  Math.toRadians(46.5);} //Latitude of false grid origin
    /**
     * Define longitude of grid origin
     * @return Longitude of grid origin (radians)
     */
    protected double lamda0() { return  Math.toRadians(3.0);}//Longitude grid origin
    /**
     * Define false easting value
     * @return False easting (m)
     */
    protected double e0() { return  700000.0;}               //False easting
    /**
     * Define false northing
     * @return False northing distance (m)
     */
    protected double n0() { return  6600000.0 ;}             //False northing
}
