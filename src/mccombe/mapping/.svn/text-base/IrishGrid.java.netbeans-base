/*
 * IrishGrid.java
 *
 *
 * Created on 24 August 2005, 18:12
 *
 */
package mccombe.mapping;

/**
 * Implementation of the Irish Grid. Note that this is used throughout the island of Ireland,
 * North and South and that the OSGB grid is not applicable.
 *
 *
 * For a complete description of the Irish Grid, see  http://www.osni.gov.uk/2.1_the_irish_grid.pdf
 * @author Mike McCombe
 */
public class IrishGrid extends TransverseMercator {

    /**
     * Create a new IrishGrid point for a specific Position, Ellipsoid and Datum.
     * @param p Position
     * @param e Ellipsoid to use with this instance
     * @param d Datum to use
     */
    public IrishGrid(Position p, Ellipsoid e, Datum d) {
        super(p, e, d);
    }

    /**
     * Create a new IrishGrid point for a specific pair of Eastings and Northings, Ellipsoid and Datum.
     * @param point ENPair containing the easting and northing values
     * @param e Ellipsoid to use with this instance
     * @param d Datum to use
     */
    public IrishGrid(ENPair point, Ellipsoid e, Datum d) {
        super(point, e, d);
    }

    /**
     * Create a new IrishGrid point for a specific pair of Eastings and Northings. Default values of Ellipsoid
     * and Datum are used.
     * @param point ENPair containing the easting and northing values
     */
    public IrishGrid(ENPair point) {
        this(point, Ellipsoid.MODIFIED_AIRY, Datum.IRELAND_1965);
    }

    /**
     * Factory method to create a new IrishGrid point using a String containing
     * a grid reference.
     * @param gridref A valid Irish grid reference String (e.g. R 212 712)
     * @param e Ellipsoid to use
     * @param d Datum to use
     * @return A new IrishGrid point for the specified point, Ellipsoid and Datum
     * @throws mccombe.mapping.GridFormatException In case of syntax error in he grid reference
     */
    public static IrishGrid makePoint(String gridref, Ellipsoid e, Datum d) throws GridFormatException {
        ENPair point = getEN(gridref);
        return new IrishGrid(point, e, d);
    }

    private static ENPair getEN(String gridRef) throws GridFormatException {
        String target = gridRef.toUpperCase().trim();
        String eastDigits = "";
        String northDigits = "";
        String gridLetter = "";
        java.util.regex.Matcher match = pattern.matcher(target);
        if (match.matches()) {
            int n = match.groupCount();
            gridLetter = match.group(1);
            if (match.group(3) == null) {
                String digits = match.group(2);
                int m = digits.length();
                if (m % 2 != 0) {
                    throw new GridFormatException("Invalid grid format - odd no. of digits");
                }
                eastDigits = digits.substring(0, m / 2);
                northDigits = digits.substring(m / 2);
            } else {
                eastDigits = match.group(2);
                northDigits = match.group(3);
                if (eastDigits.length() != northDigits.length()) {
                    throw new GridFormatException("Invalid grid format - easting and northing must have same no. of digits");
                }
            }
        } else {
            throw new GridFormatException("Invalid grid reference format");
        }
        try {
            double e = Double.parseDouble(justify(eastDigits));
            double n = Double.parseDouble(justify(northDigits));
            if (gridLetter.length() == 1) {
                int k = gridLetters.indexOf(gridLetter);
                int kn = k / 5;
                int ke = k % 5;
                e += ke * 100000;
                n += kn * 100000;
            }
            return new ENPair(e, n);
        } catch (NumberFormatException exc) {
            throw new GridFormatException("Invalid grid format - incorrect digits");
        }
    }

    private static String justify(String s) {
        String padding = "00000";
        int i = s.length();
        if (i < 5) {
            int n = 5 - i;
            return s + padding.substring(0, n);
        } else if (i > 5) {
            return s.substring(0, 5) + "." + s.substring(5);
        }
        return s;
    }

    /**
     * Defines the default Datum for this system
     * @return Datum.Ireland_1965
     */
    public Datum defaultDatum() {
        return Datum.IRELAND_1965;
    }

    /**
     * Define the default Ellipsoid for this system
     * @return Ellipsoid.MODIFIED_AIRY
     */
    public Ellipsoid defaultEllipsoid() {
        return Ellipsoid.MODIFIED_AIRY;
    }

    /**
     * Provide a String representation for this IrishGrid
     * @return A 10-figure Irish grid reference, with grid letter (e.g. R 21235 71262)
     */
    public String toString() {
        ENPair en = this.toEN();
        int e = (int) Math.round(en.east());
        int n = (int) Math.round(en.north());
        int j = e / 100000;
        int k = n / 100000;
        int m = 5 * k + j;
        String sq = gridLetters.substring(m, m + 1);
        j = e % 100000;
        k = n % 100000;
        return String.format("%s %05d %05d", sq, j, k);

    }

    /**
     * The central meridian
     * @return The central meridian (degrees)
     */
    public double lamda0() {
        return Math.toRadians(-8.0);
    }

    /**
     * False Eastimg (metres)
     * @return False easting value (metres)
     */
    public double e0() { return 200000.0;
    }

    /**
     * Define false northing
     * @return False northing value (metres)
     */
    public double n0() { return 250000.0;
    }
    /**
     * Define latitude of true origin
     * @return Latitude of true origin (degrees)
     */
    public double phi0() { return Math.toRadians(53.5);
    }

    /**
     * Define scale factor
     * @return Scale factor at central meridian
     */
    public double f0() { return 1.000035;
    }

    private static final String gridLetters = "VWXYZQRSTULMNOPFGHJKABCDE";
    private static final String regex = "([A-HJ-Z])\\p{javaWhitespace}*([0-9]+)\\p{javaWhitespace}*([0-9]+)??";
    private static final java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);

    protected static boolean validateEN(ENPair p) {
        double x = p.east();
        double y = p.north();
        return (x >= MIN_E && x < MAX_E && y >= MIN_N && y < MAX_N);

    }
    private static final double MAX_E = 500000.0;
    private static final double MIN_E = 0.0;
    private static final double MAX_N = 500000.0;
    private static final double MIN_N = 0.0;
}
