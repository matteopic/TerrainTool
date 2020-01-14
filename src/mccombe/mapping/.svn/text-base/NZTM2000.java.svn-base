/*
 * New Zealand Transverse Mercator 2000 Coordinate System
 */
package mccombe.mapping;

/**
 *
 * @author Mike McCombe
 */
public class NZTM2000 extends mccombe.mapping.TransverseMercator {

    public NZTM2000(Position p, Ellipsoid e, Datum d) {
        super(p, e, d);
    }

    public NZTM2000(ENPair en, Ellipsoid e, Datum d) {
        super(en, e, d);
    }

    /**
     * Static factory method to create an instance of NZMG from a grid reference String
     * @param gridref A grid reference of the form "157203 mE 6752091 mN " where the values are easting and
     * northing distances in m
     * @param e Ellipsoid to use in conversions
     * @param d Datum to use in conversions
     * @throws mccombe.mapping.GridFormatException thrown in case of format error in the grid reference
     * @return A new LambertI instance
     */
    public static NZTM2000 makePoint(String gridref, Ellipsoid e, Datum d) throws GridFormatException {
        ENPair en = getEN(gridref);
        return new NZTM2000(en, e, d);
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
                    throw new GridFormatException("Invalid Lambert Coordinate String");
                }
            }
        } catch (java.util.regex.PatternSyntaxException e) {
            throw new GridFormatException("Invalid NZTM2000 Coordinate String");
        } catch (NumberFormatException e) {
            throw new GridFormatException("Invalid NZTM2000 Coordinate String");
        } catch (java.text.ParseException e) {
            throw new GridFormatException("Invalid NZTM2000 Coordinate String");
        }
        return new ENPair(xCoord, yCoord);
    }

    /**
     * Define scale factor
     * @return Scale factor at central meridian
     */
    @Override
    public double f0() {
        return 0.9996;
    }

    /**
     * Define latitude of true origin
     * @return Latitude of true origin (degrees)
     */
    public double phi0() {
        return 0.0;
    }

    /**
     * Define false northing
     * @return False northing value (metres)
     */
    public double n0() {
        return 10000000.0;
    }

    /**
     * False Eastimg (metres)
     * @return False easting value (metres)
     */
    public double e0() {
        return 1600000.0;
    }

    /**
     * The central meridian
     * @return The central meridian (radians)
     */
    public double lamda0() {
        return Math.toRadians(173.0);
    }

    /**
     * Define the default Ellipsoid for this system
     * @return Ellipsoid.GRS80
     */
    public Ellipsoid defaultEllipsoid() {
        return Ellipsoid.GRS80;
    }

    @Override
    public Datum defaultDatum() {
        return Datum.NZGD_2000;
    }

    @Override
    public String toString() {
        ENPair en = this.toEN();
        return String.format("%7.0f mE %7.0f mN", en.east(), en.north());
    }
}
