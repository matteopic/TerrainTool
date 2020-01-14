/*
 */

package mccombe.mapping;

/**
 * Abstract base class for the Austrian BMN (Bundesmeldnetz) coordinate system
 *
 * @author Mike
 */
public abstract class BMN extends TransverseMercator {
    public BMN(Position p, Ellipsoid e, Datum d){
        super(p, e, d);
    }
    public BMN(ENPair en, Ellipsoid e, Datum d){
        super(en, e, d);
    }
    @Override
    public Datum defaultDatum() { return Datum.MGI; }
    @Override
    public Ellipsoid defaultEllipsoid() { return Ellipsoid.BESSEL;}
    /**
     * Provide a String representation of this UTM point in UTM coordinates
     * @return A UTM coordinate String
     */
    public String toString() {
        ENPair pa = toEN();
        return String.format("%s %8.0f %8.0f", zonename,  pa.east(), pa.north());
    }
     /**
     * The scale factor on the Central Meridian. Generally, Transverse Mercator
     * projections increasingly exaggerate distances further from the central
     * meridian. It is usual to reduce the scale factor at the central meridian
     * to compensate for this effect and optimise the scale over the area of interest.
     * @return the value of the ScaleFactor at the central meridian.
     */
    @Override
    public double f0() {
        return 1.0000 ;
    }  
    /**
     * n0() defines the "false northing" distance of the projection. False origins
     * are usually used with TM projections to ensure that easting and northing
     * distances are always positive over the area of interest. n0() is used as an
     * offset to the grid so that the "true origin" appears to have a northing value
     * equal to n0().
     *
     * @return The false northing distance (double)
     */
    @Override
    public double n0() {
        return -5000000.0;
    }
    /**
     * phi0() defines the latitude of the true origin of the projection.
     *
     * Note, however, that many Transverse Mercator projections employ a
     * false origin. See n0() and e0() .
     *
     *
     * @return The latitude of the true origin (radians)
     */
    public double phi0() {
        return 0;
    }     //Latitude of true origin ;
    protected String zonename = "XXX" ;
}
