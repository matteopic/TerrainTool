/*
 * CoordinateSystem.java
 *
 * Created on 05 July 2005, 17:17
 *
 */
package mccombe.mapping;

/**
 * Abstract base class for coordinate systems in general. 
 * 
 * Each instance of CoordinateSystem contains a Position and references to the 
 * Ellipsoid and Datum from which the coordinates are derived. The position itself is 
 * independent of Ellipsoid and Datum.
 * @author Mike McCombe
 */
public abstract class CoordinateSystem {

    /**
     * Creates a new instance of CoordinateSystem using the default Ellipsoid and Datum
     */
    protected CoordinateSystem() {
    }

    /**
     * <p>Create a new instance of CoordinateSystem for a specific Position, Ellipsoid and Datum</p>
     * @param pos Position of the point in this CoordinateSystem
     * @param e Ellipsoid to be used in this CoordinateSystem
     * @param d Datum for this instance of CopordinateSystem
     */
    public CoordinateSystem(Position pos, Ellipsoid e, Datum d) {
        locus = pos;
        sph = e;
        ref = d;
    }

    /**
     * Get the Latitude & Longitude for this point. <B>Note the result is referred to the current datum and ellipsoid</B>
     * @return LatLong object containing latitude and longitude
     */
    public LatLong toLatLong() {
        return locus.toLatLong(sph, ref);
    }

    /**
     * Return a String containing values of Latitude & Longitude.<B>referred to the current Ellipsoid & Datum</B>
     * @return String containing Latitude & Longitude in degrees. North or East are represented by positive values, South or West are negative.
     */
    public String toLatLongString() {
        LatLong geog = locus.toLatLong(sph, ref);
        String res = String.format(java.util.Locale.UK, "%10.6f %11.6f", geog.lat(), geog.lon());
        return res;
    }

    /**
     * Get the Datum used by this point
     * @return The Datum associated with this point
     */
    public Datum getDatum() {
        return ref;
    }

    /**
     * Get the Ellipsoid used by this point
     * @return Ellipsoid
     */
    public Ellipsoid getEllipsoid() {
        return sph;
    }

    /**
     * <p>Get the name of this CoordinateSystem. By default, this method returns the short name of the 
     * class. For example, an instance of <code>mccombe.mapping.IrishGrid</code> returns the name "IrishGrid".</p>
     * <p>Implementers of sub-classes of CoordinateSystem are encouraged to override this method if a 
     * more descriptive name is needed</p>
     * @return The name of the CoordinateSystem
     */
    public String getName() {
        String fullName = getClass().getName();
        int i = fullName.lastIndexOf(".");
        String name = fullName.substring(i + 1);
        return name;
    }

    /**
     * Get the Position of this point
     * @return The Position of this point
     */
    public Position getPosition() {
        return locus;
    }

    /**
     * Get the "absolute" cartesian coordinates for this location. These are based on the WGS-84 datum and coordinate system.
     * @return XYZ object containing the cartesian coordinates for this point.
     */
    public XYZ getWGS84() {
        return locus.coords(Datum.WGS_1984);
    }

    /**
     * The default Ellipsoid used by instances of this CoordinateSystem
     * 
     * For example, a CoordinateSystem of type OSGB has the AirySphere as its default Ellipsoid
     * @return The Ellipsoid used as the deafult for this CoordinateSystem
     */
    public abstract Ellipsoid defaultEllipsoid();

    /**
     * Get the defaul Datum for an instance of CoordinateSystem.
     * 
     * For example, instances of OSGB usually use the OSGB 1936 datum.
     * @return The default Datum used by this instance of CoordinateSystem
     */
    public abstract Datum defaultDatum();

    /**
     * Provide a String representing the position in a correct format for the 
     * CoordinateSystem
     * @return String  
     */
    public abstract String toString();
    /*
     * Parse a String for a double value using the current locale
     */

    protected static double parseDouble(String s) throws java.text.ParseException {
        java.text.NumberFormat nf = java.text.NumberFormat.getInstance();
        return nf.parse(s.trim()).doubleValue();
    }
    /**
     * The Position of this Coordinate
     */
    protected Position locus;
    /**
     * The Ellipsoid for this point
     */
    protected Ellipsoid sph;
    /**
     * The Datum for this point
     */
    protected Datum ref;
}
