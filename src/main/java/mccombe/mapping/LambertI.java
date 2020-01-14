/*
 * LambertI.java
 *
 * Created on 19 July 2005, 09:30
 *
 */

package mccombe.mapping;

/**
 * A non-abstract class implementing the Lambert Conformal Conical projection 
 * for Zone 1 (Northern France between latitudes 48.15 and 51.3 degrees N)
 * @author Mike McCombe
 */
public class LambertI extends Lambert {
    
    /**
     * Create an instance of LambertI from Position, Ellipsoid and Datum
     * @param p the position of this point
     * @param e The Ellipsoid to use
     * @param d The datum to be used
     */
     public LambertI(Position p, Ellipsoid e, Datum d){
        super(p, e, d);
    }
    /**
     * Create an instance of LambertI from easting and northing distances, Ellipsoid and Datum
     * @param en Easting and Northing distances
     * @param e Ellipsoid to use
     * @param d Datum to use
     */
    public LambertI(ENPair en, Ellipsoid e, Datum d){
        super(en, e, d);
    }
    /**
     * Static factory method to create an instance of LambertI from a grid reference String
     * @param gridref A grid reference of the form "X=... Y=..." where the values are easting and 
     * northing distances in km. French convention sometimes includes the zone number as the first
     * digit of the Y (northing) coordinate (e.g. "Y=1210.98" denoting a northing distance of 210.98km 
     * in zone 1). If present, this is ignored.
     * @param e Ellipsoid to use in conversions
     * @param d Datum to use in conversions
     * @throws mccombe.mapping.GridFormatException thrown in case of format error in the grid reference
     * @return A new LambertI instance
     */
    public static LambertI makePoint(String gridref, Ellipsoid e, Datum d)throws GridFormatException {
        ENPair en = getEN(gridref);
        double y = en.north();
        if(y>=1000000.0 && y<2000000.0) {
            y -=1000000.0;
            double x = en.east();
            en = new ENPair(x,y);
        }
        return new LambertI(en, e, d);
    }
   // Projection constants
    /**
     * Define Upper standard parallel for this conical projection
     * @return Upper Standard Parallel (radians)
     */
    protected double phiU() { return Math.toRadians(50.39591167);}  //Upper parallel
    /**
     * Define lower standard parallel for this projection
     * @return Lower Standard Parallel (radians)
     */
    protected double phiL() { return Math.toRadians(48.59852278);}  //Lower parallel
   /**
     * Define latitude of false origin
     * @return Latitude of false origin (radians)
     */
    protected double phiB() { return  Math.toRadians(49.5);}        //Latitude of false grid origin
    /**
     * Define longitude of grid origin
     * @return Longitude of grid origin (radians)
     */
    protected double lamda0() { return  Math.toRadians(2.337229167);} //Longitude grid origin
    /**
     * Define false easting value
     * @return False easting (m)
     */
    protected double e0() { return  600000 ;}                       //False easting
    /**
     * Define false northing
     * @return False northing distance (m)
     */
    protected double n0() { return  200000 ;}                       //False northing
    
}
