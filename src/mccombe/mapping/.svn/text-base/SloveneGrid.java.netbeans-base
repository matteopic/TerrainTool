
package mccombe.mapping;

/**
 *
 * @author Mike
 */
public class SloveneGrid extends mccombe.mapping.TransverseMercator{
    public SloveneGrid(Position p, Ellipsoid e, Datum d){
        super(p, e, d);
    }
    public SloveneGrid(ENPair en, Ellipsoid e, Datum d){
        super(en, e, d);
    }
    public static SloveneGrid makePoint(String gridRef, Ellipsoid e, Datum d)throws GridFormatException {
        String arg = gridRef.toUpperCase().trim();
        java.util.regex.Matcher matcher = pattern.matcher(arg);
        if (matcher.find()) {
            String eastingNum = matcher.group(1);
            String northingNum = matcher.group(2);
            try {
                double xCoord = Double.parseDouble(eastingNum);
                double yCoord = Double.parseDouble(northingNum);
                ENPair pa = new ENPair(xCoord, yCoord);
                return new SloveneGrid(pa, e, d);
            } catch (NumberFormatException ee) {
                throw new GridFormatException("Illegal Slovene grid format");
            }
        }
        throw new GridFormatException("Invalid Slovene grid reference");
    }
    @Override
    public Datum defaultDatum() { return Datum.MGI_SLOV; }
    @Override
    public Ellipsoid defaultEllipsoid() { return Ellipsoid.BESSEL;}
    /**
     * Provide a String representation of this point in Slovene coordinates
     * @return A Slovene coordinate String
     */
    public String toString() {
        ENPair pa = toEN();
        return String.format("%8.0f %8.0f",  pa.east(), pa.north());
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
        return 0.9999 ;
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
    @Override
    public double e0() {
        return 500000.0 ;
    }
    public double phi0() {
        return 0;
    }     //Latitude of true origin ;
    /**
     * lamda0() defines the longitude (in radians) of the true origin also
     * known as the "Central Meridian".
     * @return The central meridian (radians)
     */
    @Override
    public double lamda0() {
        return Math.toRadians(15.0);
    }
    private static final String validationRegex1 = "\\s*(\\d+\\.?\\d*)\\s*(\\d+\\.?\\d*)$";
    private static final java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(validationRegex1);

   
}
