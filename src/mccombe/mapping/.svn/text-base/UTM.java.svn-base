/*
 * UTM.java
 *
 * Created on 13 July 2005, 11:50
 *
 */
package mccombe.mapping;

/**
 * The Universal Transverse Mercator coordinate system
 * @author Mike McCombe
 */
public class UTM extends TransverseMercator {

    /**
     * Create a new instance from Position, Ellipsoid and Datum. The UTM zone is calculated 
     * automatically from the Position's longitude (relative to the specified Ellipsoid and Datum).
     * @param p Position
     * @param e Ellipsoid to use
     * @param d Datum to use
     */
    public UTM(Position p, Ellipsoid e, Datum d) {
        super(p, e, d);
        LatLong geo = p.toLatLong(e, d);
        zone = getZone(geo.lon());
    }

    /**
     * Create a new instance of UTM from Position, UTM zone, Ellipsoid and Datum.
     * @param p Position
     * @param z The UTM zone number
     * @param e Ellipsoid to use
     * @param d The Datum for this point
     */
    public UTM(Position p, int z, Ellipsoid e, Datum d) {
        super(p, e, d);
        zone = z;
    }

    /**
     * Create a new UTM object from easting and northing values, zone number, Ellipsoid and Datum
     * @param en Easting and northing values (m)
     * @param z Zone number (0-59)
     * @param sphere Ellipsoid for this point
     * @param datum Datu for this point
     * @param hemisphere - true if point is in the NOrthern Hemisphere
     */
    public UTM(ENPair en, int z, Ellipsoid sphere, Datum datum, boolean hemisphere) {
        super(en, z, sphere, datum, hemisphere);
        zone = z;
    }
    /**
     * Create a new UTM object from easting and northing values, zone number, Ellipsoid and Datum
     * @param en Easting and northing values (m)
     * @param z Zone number (0-59)
     * @param sphere Ellipsoid for this point
     * @param datum Datu for this point
     */
    public UTM(ENPair en, int z, Ellipsoid sphere, Datum datum) {
        super(en, z, sphere, datum, true);
   }

    /**
     * This constructor is provided for test purposes only (because it has a common interface with
     * other sub-classes of Projection). 
     * Its use is @deprecated Use the UTM(ENPair, int, Ellipsoid, Datum) instead.
     * @param en Easting and northing values (m). Zone number is assumed to be 0.
     * @deprecated 
     */
    @Deprecated
    public UTM(ENPair en) {
        super(en, Ellipsoid.GRS80, Datum.WGS_1984);
        zone = 0;
    }

    /**
     * Static factory method to create a UTM instance from a grid reference String
     * @param gridRef Grid reference String e.g. "32T 31577 202576"
     * @param e Ellipsoid for this instance
     * @param d Datum for this instance
     * @throws mccombe.mapping.GridFormatException if the grid rference String is invalid
     * @return A new instance of UTM for the specified point.
     */
    public static UTM makePoint(String gridRef, Ellipsoid e, Datum d) throws GridFormatException {
        String arg = gridRef.toUpperCase().trim();
        java.util.regex.Matcher matcher = pattern.matcher(arg);
        if (matcher.find()) {
            String zoneNumber = matcher.group(1);
            String zoneLetter = matcher.group(2);
            String eastingNum = matcher.group(3);
            String northingNum = matcher.group(4);
            boolean hemisphere = latZones.indexOf(zoneLetter) >= 10 ;
            try {
                int z = Integer.parseInt(zoneNumber);
                double xCoord = Double.parseDouble(eastingNum);
                double yCoord = Double.parseDouble(northingNum);
                ENPair pa = new ENPair(xCoord, yCoord);
                return new UTM(pa, z, e, d, hemisphere);
            } catch (NumberFormatException ee) {
                throw new GridFormatException("Illegal UTM format");
            }
        }
        throw new GridFormatException("Invalid UTM grid reference");
    }

    /**
     * Get the default datum for this type of CoordinateSystem
     * @return The default Datum (WGS84)
     */
    public mccombe.mapping.Datum defaultDatum() {
        return Datum.WGS_1984;
    }

    /**
     * Get the default Ellipsoid for this CoordinateSystem
     * @return Default Ellipsoid (GRS80)
     */
    public mccombe.mapping.Ellipsoid defaultEllipsoid() {
        return Ellipsoid.GRS80;
    }

    /**
     * Provide a String representation of this UTM point in UTM coordinates
     * @return A UTM coordinate String
     */
    public String toString() {
        ENPair pa = toEN();
        /*        
        java.text.DecimalFormat fm1 = new java.text.DecimalFormat("00");
        java.text.DecimalFormat fm2 = new java.text.DecimalFormat("000000");
        String s1 = fm1.format(zone);
        String s2 = fm2.format(pa.east());
        String s3 = fm2.format(pa.north());
        return s1 + " " + s2 + " " +s3 ;
         */
        return String.format("%02d%1s %8.0f %8.0f", zone, latZone(), pa.east(), pa.north());
    }

    /**
     * A static method to calculate the correct zone number for a specified longitude.
     * @param lon Longitude (degrees)
     * @return Zone number (0-59)
     */
    public static int getZone(double lon) {
        int z = 31 + (int) Math.round((lon - 3) / 6);
        return z;
    }
    /**
     * Get the zone number of this point
     * @return Zone number (0-59)
     */
    public  int getZone() {
        return zone;
    }
    /**
     * Check if this point is in the northern hemisphere
     * @return true if this point is north of the equator
     */
    public boolean getNorthernHemisphere(){
        return northernHemisphere ;
    }
    /**
     * The scale factor on the Central Meridian. Generally, Transverse Mercator
     * projections increasingly exagerate distances further from the central
     * meridian. It is usual to reduce the scale factor at the central meridian
     * to compensate for this effect and optimise the scale over the area of interest.
     * @return the value of the ScaleFactor at the central meridian.
     */
    public double f0() {
        return 0.9996;
    }  //Scale factor on central meridian

    /**
     * e0() defines the "false easting" distance of the projection. False origins
     * are usually used with TM projections to ensure that easting and northing
     * distances are always positive over the area of interest. e0() is used as an
     * offset to the grid so that the "true origin" appears to have an easting value
     * equal to e0().
     *
     * @return The false easting distance (double)
     */
    public double e0() {
        return 500000;
    }  //Easting of true origin

    /**
     * n0() defines the "false northing" distance of the projection. False origins
     * are usually used with TM projections to ensure that easting and northing
     * distances are always positive over the area of interest. n0() is used as an
     * offset to the grid so that the "true origin" appears to have a northing value
     * equal to n0().
     *
     * @return The false northing distance (double)
     */
    public double n0() {
        if (!northernHemisphere) {
            return 10000000.0;
        }
        return 0;
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
        return 0.0;
    }     //Latitude of true origin ;

    /**
     * lamda0() defines the longitude (in radians) of the true origin also
     * known as the "Central Meridian".
     * @return The central meridian (radians)
     */
    public double lamda0() {                //Longitude of true origin
        double deg = (zone - 31.0) * 6 + 3.0;
        return Math.toRadians(deg);
    }

    private String latZone() {
        String res = " ";
        LatLong geog = locus.toLatLong(sph, ref);
        double lat = geog.lat();
        int lz = (int) lat ;
        if (lz > -80 && lz < 84) {
            int j = (lz + 80) / 8;
            res = latZones.substring(j, j + 1);
        }
        return res;
    }
    private static final String latZones = "CDEFGHJKLMNPQRSTUVWXX";
    private static final String validationRegex1 = "(\\d\\d)\\s*([C-HJ-NP-X])\\s*(\\d+\\.?\\d*)\\s*(\\d+\\.?\\d*)$";
    private static final java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(validationRegex1);
}
