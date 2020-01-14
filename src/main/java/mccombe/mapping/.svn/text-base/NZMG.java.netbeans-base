/*
 * New Zealand Mapping Grid - an implementation of a conformal orthomorphic projection
 * See http://www.linz.govt.nz/docs/miscellaneous/nz-map-definition.pdf for a technical description
 * of NZMG
 *
 */
package mccombe.mapping;

/**
 *
 * @author Mike McCombe
 */
public class NZMG extends mccombe.mapping.Orthomorphic {

    /**
     * Create a new NZMG point for a specific Position, Ellipsoid and Datum.
     * @param p Position
     * @param e Ellipsoid to use with this instance
     * @param d Datum to use
     */
    public NZMG(Position p, Ellipsoid e, Datum d) {
        super(p, e, d);
    }

    /**
     * Create a new NZMG point for a specific pair of Eastings and Northings, Ellipsoid and Datum.
     * @param point ENPair containing the easting and northing values
     * @param e Ellipsoid to use with this instance
     * @param d Datum to use
     */
    public NZMG(ENPair point, Ellipsoid e, Datum d) {
        super(point, e, d);
    }

    /**
     * Static factory method to create an instance of NZMG from a grid reference String
     * @param gridref A grid reference of the form "157203 mE 6752091 mN " where the values are easting and
     * northing distances in m
     * @param e Ellipsoid to use in conversions
     * @param d Datum to use in conversions
     * @throws mccombe.mapping.GridFormatException thrown in case of format error in the grid reference
     * @return A new NZMG instance
     */
    public static NZMG makePoint(String gridref, Ellipsoid e, Datum d) throws GridFormatException {
        ENPair en = getEN(gridref);
        return new NZMG(en, e, d);
    }

    /**
     * Parse NZMG coordinates into easting and northing distances
     * @param gridref A pair of NZMG coordinates (e.g. "2487100.638 mE 6751049.719 mN), specified in m.
     * @throws mccombe.mapping.GridFormatException Invalid coordinate format results in a GridFormatException being thrown
     * @return Easting and Northing distances (m)
     */
    protected static ENPair getEN(String gridref) throws GridFormatException {
        double xCoord = 0.0;
        double yCoord = 0.0;
        boolean gotX = false;
        boolean gotY = false;
        try {
            String regex = "[ \tm]+";
            String[] parts = gridref.split(regex);
            int n = parts.length;
            switch (n) {
                case 2: {
                    xCoord = parseDouble(parts[0]);
                    yCoord = parseDouble(parts[1]);
                    break;
                }
                case 4: {
                    for (int i = 1; i < 4; i += 2) {
                        if (parts[i].equalsIgnoreCase("E")) {
                            xCoord = parseDouble(parts[i - 1]);
                            gotX = true;

                        } else if (parts[i].equalsIgnoreCase("N")) {
                            yCoord = parseDouble(parts[i - 1]);
                            gotY = true;
                        }
                    }
                    if (gotX && gotY) {
                        break;
                    }
                }
                default: {
                    throw new GridFormatException("Invalid NZMG Coordinate String");
                }
            }
        } catch (java.util.regex.PatternSyntaxException e) {
            throw new GridFormatException("Invalid NZMG Coordinate String");
        } catch (NumberFormatException e) {
            throw new GridFormatException("Invalid NZMG Coordinate String");
        } catch (java.text.ParseException e) {
            throw new GridFormatException("Invalid NZMG Coordinate String");
        }
        return new ENPair(xCoord, yCoord);
    }

    @Override
    public Ellipsoid defaultEllipsoid() {
        return Ellipsoid.INTERNATIONAL;
    }

    @Override
    public Datum defaultDatum() {
        return Datum.NZGD_1949;
    }

    /**
     * Calculate the Grid Convergence for the current location. Grid Convergence
     * is defined as the angle between Grid North and True North. The value is
     * zero on the Central Meridian.
     *
     * In the absence of an algebraic form for grid convergence for NZMG, this implementation reverts to
     * basics and calculates it by making a small increment (delta) north and south of the point and
     * calculating the change in easting and northing values.
     *
     * @return The value of Grid Convergence (radians)
     */
    @Override
    public double gridConvergence() {
        LatLong here = locus.toLatLong(sph, ref);
        double lon = here.lon();
        double lat = here.lat();
        double delta = 0.01;
        LatLong l1 = new LatLong(lat + delta, lon);
        LatLong l2 = new LatLong(lat - delta, lon);
        Position p1 = new Position(l1, 0.0, sph, ref);
        Position p2 = new Position(l2, 0.0, sph, ref);
        NZMG n1 = new NZMG(p1, sph, ref);
        NZMG n2 = new NZMG(p2, sph, ref);
        ENPair e1 = n1.toEN();
        ENPair e2 = n2.toEN();
        double dn = e1.north() - e2.north();
        double de = e1.east() - e2.east();
        double convergence = Math.atan2(de, dn);
        return convergence;
    }

    @Override
    public String toString() {
        ENPair en = this.toEN();
        return String.format("%7.0f mE %7.0f mN", en.east(), en.north());
    }

    public double cfi(int i) {
        return cfi[i];
    }

    public double cfl(int i) {
        return cfl[i];
    }

    public double n0() {
        return 6023150.0;
    }

    public double e0() {
        return 2510000.0;
    }

    public double phi0() {
        return Math.toRadians(-41.0);
    }

    public double lamda0() {
        return Math.toRadians(173.0);
    }

    public Complex cfb1(int i) {
        return cfb1[i];
    }

    public Complex cfb2(int i) {
        return cfb2[i];
    }
    private static final double cfi[] = {0.6399175073, -0.1358797613, 0.063294409, -0.02526853, 0.0117879, -0.0055161, 0.0026906, -0.001333, 0.00067, -0.00034};
    private static final double cfl[] = {1.5627014243, 0.5185406398, -0.03333098, -0.1052906, 0.0368594, 0.007317, 0.01220, 0.00394, -0.0013};
    private static final Complex[] cfb1 = {
        new Complex(0.7557853228, 0.0),
        new Complex(0.249204646, 0.003371507),
        new Complex(-0.001541739, 0.041058560),
        new Complex(-0.10162907, 0.01727609),
        new Complex(-0.26623489, -0.36249218),
        new Complex(-0.6870983, -1.1651967)};
    private static final Complex[] cfb2 = {
        new Complex(1.3231270439, 0.0),
        new Complex(-0.577245789, -0.007809598),
        new Complex(0.508307513, -0.112208952),
        new Complex(-0.15094762, 0.18200602),
        new Complex(1.01418179, 1.64497696),
        new Complex(1.9660549, 2.5127645)};

    public int cfilen() {
        return cfi.length;
    }

    public int cfllen() {
        return cfl.length;
    }

    public int cfblen() {
        return cfb1.length;
    }
}
