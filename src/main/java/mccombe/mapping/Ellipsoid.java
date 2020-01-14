/*
 * Ellipsoid.java
 *
 * Created on 05 July 2005, 18:07
 *
 */
package mccombe.mapping;

/**
 * Ellipsoid is the base class used to describe the shape
 * of the earth's surface. It is a biaxial
 * ellipsoid, slightly flattened at the poles. 
 *
 * @author Mike McCombe
 */
public class Ellipsoid {

    /**
     * Create an Ellipsoid with specified major and minor exes.
     * @param name Defines the name of this Ellipsoid
     * @param major Major axis (m)
     *
     * @param minor Minor axis (m)
     */
    protected Ellipsoid(String name, double major, double minor) {
        majoraxis = major;
        minoraxis = minor;
        majsq = majoraxis * majoraxis;
        minsq = minoraxis * minoraxis;
        eccsq = (majsq - minsq) / majsq; //eccentricity ^ 2
        ecc4 = eccsq * eccsq;
        ecc6 = eccsq * ecc4;
        ecc2sq = (majsq - minsq) / minsq;  //second eccentricity ^2
        ellipsoidName = name;
    }

    /**
     * Major Axis (m) of the spheroid
     * @return The major axis of the Ellipsoid
     */
    public double majoraxis() {
        return majoraxis;
    }

    /**
     * Minor axis (m) of the spheroid
     * @return The minor axis (m) of the Ellipsoid
     */
    public double minoraxis() {
        return minoraxis;
    }

    /**
     * The eccentricity squared for this Ellipsoid.
     * @return the eccentricity squared ( i.e. (a^2 - b^2)/(a^2)
     */
    protected double eccsq() {
        return eccsq;
    }

    /**
     * Provide a String identifying this Ellipsoid
     * @return The name of this Ellipsoid
     */
    @Override
    public String toString() {
        return ellipsoidName;
    }
    /**
     * The Airy Sphere 1830 - "best fit" Ellipsoid for Great Britain
     */
    public static final Ellipsoid AIRY = new Ellipsoid("Airy Sphere 1830", 6377563.396, 6356256.910);
    /**
     * The Clarke (1880) Ellipsoid. Used in France with the NTF Datum and
     * Lambert Conformal Conical (LCC) projection
     */
    public static final Ellipsoid CLARKE = new Ellipsoid("Clarke 1880", 6378249.200, 6356515.000);
    /**
     * The Hayford (1909) Ellipsoid. Typically used with he European 1950 (ED50) Datum
     */
    public static final Ellipsoid HAYFORD = new Ellipsoid("Hayford 1909", 6378388.000, 6356911.946);
    /**
     * The GRS80 Ellipsoid - "Best fit" ellipsoid for the whole Earth. Defined for Global
     * Positioning System (GPS) and used with the WGS84 Datum.
     */
    public static final Ellipsoid GRS80 = new Ellipsoid("GRS80", 6378137.0000, 6356752.3141);
    /**
     * The "Modified Airy" ellipsoid. The "best fit" Ellipsoid for Ireland and used with the Irish Grid.
     */
    public static final Ellipsoid MODIFIED_AIRY = new Ellipsoid("Airy 1830 Modified", 6377340.189, 6356034.447);
    /**
     * The Bessel 1841 Ellipsoid. Used with the Austrian Grid
     */
    public static final Ellipsoid BESSEL = new Ellipsoid("Bessel 1841", 6377397.155, 6356078.962818);
    /**
     * The Bessel 1841 Ellipsoid. Used with the Austrian Grid
     */
    public static final Ellipsoid INTERNATIONAL = new Ellipsoid("International 1924", 6378388, 6356911.9461);

    private double majoraxis = 0.0;  //The majoraxis of this Ellipsoid
    private double minoraxis = 0.0;  //The minoraxis of this Ellipsoid
    private double majsq = majoraxis * majoraxis;
    private double minsq = minoraxis * minoraxis;
    private double eccsq = (majsq - minsq) / majsq; //eccentricity ^ 2
    private double ecc4 = eccsq * eccsq;
    private double ecc6 = eccsq * ecc4;
    private double ecc2sq = (majsq - minsq) / minsq;  //second eccentricity ^2
    private String ellipsoidName = "";
}
