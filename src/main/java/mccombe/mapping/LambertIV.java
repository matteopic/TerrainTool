/*
 * LambertIV.java
 *
 * Created on 19 July 2005, 09:50
 *
 */

package mccombe.mapping;

/**
 * A non-abstract class implementing the Lambert Conformal Conical projection
 * for Zone 4 (Corsica)
 * @author Mike McCombe
 */
public class LambertIV extends Lambert {
    
    /**
     * Create an instance of LambertIV from Position, Ellipsoid and Datum
     * @param p the position of this point
     * @param e The Ellipsoid to use
     * @param d The datum to be used
     */
    public LambertIV(Position p, Ellipsoid e, Datum d){
        super(p, e, d);
    }
    /**
     * Create an instance of LambertIV from easting and northing distances, Ellipsoid and Datum
     * @param en Easting and Northing distances
     * @param e Ellipsoid to use
     * @param d Datum to use
     */
    public LambertIV(ENPair en, Ellipsoid e, Datum d){
        super(en, e, d);
    }
    /**
     * Static factory method to create an instance of LambertIV from a grid reference String
     * @param gridref A grid reference of the form "X=... Y=..." where the values are easting and
     * northing distances in km. French convention sometimes includes the zone number as the first
     * digit of the Y (northing) coordinate (e.g. "Y=4210.98" denoting a northing distance of 210.98km 
     * in zone 4). If present, this is ignored.
     * @param e Ellipsoid to use in conversions
     * @param d Datum to use in conversions
     * @throws mccombe.mapping.GridFormatException thrown in case of format error in the grid reference
     * @return A new LambertI instance
     */
    public static LambertIV makePoint(String gridref, Ellipsoid e, Datum d)throws GridFormatException {
        ENPair en = getEN(gridref);
        double y = en.north();
        if(y>=4000000.0 && y<5000000.0) {
            y -=4000000.0 ;
            double x = en.east();
            en = new ENPair(x,y);
        }
        return new LambertIV(en, e, d);
    }
    // Projection constants
    /**
     * Define Upper standard parallel for this conical projection
     * @return Upper Standard Parallel (radians)
     */
    protected double phiU() { return Math.toRadians(42.76766333);}  //Upper parallel
    /**
     * Define lower standard parallel for this projection
     * @return Lower Standard Parallel (radians)
     */
    protected double phiL() { return Math.toRadians(41.56038778);}  //Lower parallel
    /**
     * Define latitude of false origin
     * @return Latitude of false origin (radians)
     */
    protected double phiB() { return  Math.toRadians(42.165);}        //Latitude of false grid origin
    /**
     * Define longitude of grid origin
     * @return Longitude of grid origin (radians)
     */
    protected double lamda0() { return  Math.toRadians(2.337229167);} //Longitude grid origin
    /**
     * Define false easting value
     * @return False easting (m)
     */
    protected double e0() { return  234.358 ;}                          //False easting
    /**
     * Define false northing
     * @return False northing distance (m)
     */
    protected double n0() { return  185861.369 ;}                       //False northing
}
