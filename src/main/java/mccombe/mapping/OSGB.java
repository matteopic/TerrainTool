package mccombe.mapping ;
import java.math.* ;
/**
 * <P>
 * Class OSGB provides handling for the Ordnance Survey of Great Britain
 * coordinate system.
 * </P>
 * <P>
 * OSGB is a conventional Transverse Mercator coordinate system in which a standard
 * sphere (the "Airy 1830 sphere") is projected onto a plane. Several other well-known
 * coordinate systems operate in the same way (e.g. the Irish Grid and UTM) but with
 * origins and spheroids chosen to be most suitable to the area of use. The OSGB grid is
 * applicable only to Great Britain (i.e. England, Scotland and Wales but NOT Northern Ireland 
 * or the Republic of Ireland, or the Channel Islands).
 * </P>
 * <P>
 * For more information about OSGB and the manipulation of Transverse Mercator coordinate systems
 * you could try:-
 * <PRE>
 *      "A guide to coordinate systems in Great Britain" - Ordnance Survey of Great Britain
 *      "GDA Technical Manual" at www.anzlic.org.au
 * </PRE>
 * </P>
 * @author Mike McCombe
 * 
 * Simplified & tidied 21-Oct-2007
 */
public class OSGB extends mccombe.mapping.TransverseMercator {
    /**
     * Create a new OSGB point based on a grid reference. This is the preferred method of obtaining a 
     * new OSGB object from a grid reference and for translating a grid reference into a Position. For example
     * <PRE>
     *    
     *    try {
     *        OSGB point = OSGB.makePoint("ST755619", Ellipsoid.AIRY, Datum.OSGB_1936);
     *        Position here = point.getPosition();
     *        ...
     *    }
     *    catch(GridFormatException e){
     *        //Handle exception
     *        ...
     *    }  
     *    
     * </PRE>
     * @param osReference A String containg a valid grid reference. This consists of a two-letter
     * grid square (e.g. "ST") followed by 1-5 digits of easting and the same number of digits 
     * of  northing. Whitespace may appear between the grid-letters and easting and between 
     * easting and northing values.
     * @param e The Ellipsoid used in conjunction with this point. This is almost always the 
     * Airy (1830) sphere.
     * @param d The Datum to use in conjunction with this point. This is almost always the 
     * OSGB (1936) Datum.
     * @return A new OSGB object
     * @throws mccombe.mapping.GridFormatException A GridFormatException is thrown whenever the grid reference provided has invalid
     * syntax.
     */
    public static OSGB makePoint(String osReference, Ellipsoid e, Datum d) throws GridFormatException {
        ENPair point = getEN(osReference) ;
        return new OSGB(point, e, d);
    }
    
    /**
     * Create a new OSGB object from easting and northing distances
     * @param p Easting and Northing distances (m)
     * @param e Ellipsoid used by this point
     * @param d Datum used for this point.
     */
    public OSGB(ENPair p, Ellipsoid e, Datum d){
        super(p, e, d);
    }
    /**
     * Create a new OSGB object using Easting and Northing distances. The Ellispoid and Datum
     * are the Airy Sphere and OSGB (1936) Datum.
     * @param p The easting and northing distances (m)
     */
    public OSGB(ENPair p){
        this(p, Ellipsoid.AIRY, Datum.OSGB_1936);
    }
    /**
     * Create a new OSGB object for a specific Position, Ellipsoid and Datum.
     * @param p the Position of this point.
     * @param e The Ellipsoid to use (normally Ellipsoid.AIRY)
     * @param d The Datum to use (normally Datum.OSGB_1936)
     */
    public OSGB(Position p, Ellipsoid e, Datum d) {
        super(p, e, d);
    }
    /**
     * Define the defaultDatum for this CoordinateSystem
     * @return Datum.OSGB_1936 
     */
    public mccombe.mapping.Datum defaultDatum() { return Datum.OSGB_1936; }
    /**
     * Define the default Ellipsoid for this CoordinateSystem
     * @return Ellipsoid.AIRY
     */
    public mccombe.mapping.Ellipsoid defaultEllipsoid() { return Ellipsoid.AIRY; }
    /**
     * Provide a String representation for this point.
     * @return 10-figure (1m) grid reference, with grid square
     */
    public String toString() {
        ENPair p = toEN() ;
        return osRef(p);
    }
    /** Convert Easting and Northing distances in metres into OS grid ref
     *
     * @return OS Grid Reference (String)
     * @param easting (m)
     * @param northing (m)
     */ 
    private static String osRef(ENPair point) {
        double easting = point.east();
        double northing = point.north();
        
        if(!validateEN(point)) {
            return "" ;
        }
        
// returns 10 digit reference for given easting and northing in km.
// eg SO 12345 67890
        long e = 1000000 + Math.round(easting) ;
        long n = Math.round(northing) + 500000 ;
        long i = e / 500000 ;
        long j = n / 500000 ;
        String l = "" ;
        l += t1.charAt((int)(i + 1 + j * 5)-1) ;
        e = e % 500000 ;
        n = n % 500000 ;
        i = e / 100000 ;
        j = n / 100000 ;
        l += t1.charAt( (int)(j * 5 + i + 1)-1) ;
        
        e = e % 100000 ;
        n = n % 100000 ;
        String ec = "" ;
        ec += (100000 + e);
        String nc = "" ;
        nc += (100000 + n);
        l += " " + ec.substring(1) + " " + nc.substring(1) ;
        return l ;
    }
    /** Convert OS grid reference to easting and northing values
     *
     * @param os Grid Reference  (String)
     * @exception GridFormatException on bad OS Grid Reference
     * @return Pair containing the easting (x) and northing(y) distances in metres
     */
    private static ENPair getEN(String os) throws GridFormatException {
        double units = 1.0 ;
        String northPart, eastPart, gridSquare ;
        String arg = os.toUpperCase().trim();
        java.util.regex.Matcher matcher = pattern.matcher(arg);
        java.util.regex.Matcher matcher2 = altPattern.matcher(arg);
        if(matcher.find()) {
            gridSquare = matcher.group(1);
            String gridOffset = matcher.group(2);
            int offsetLength = gridOffset.length();
            if((offsetLength % 2) != 0) throw new GridFormatException("Invalid OS Grid Reference - odd number of digits");
            eastPart = gridOffset.substring(0,offsetLength/2);
            northPart = gridOffset.substring(offsetLength/2);
            units = Math.pow(10.0,5-offsetLength/2);
        } else if(matcher2.find()) {
            gridSquare = matcher2.group(1);
            eastPart = matcher2.group(2);
            northPart = matcher2.group(3);
            if(eastPart.length()!= northPart.length()) throw new GridFormatException("Invalid OS Grid Reference - easting & northing have different lengths");
            units = Math.pow(10.0,5-eastPart.length());
        } else  throw new GridFormatException("Invalid OS grid reference");
        String firstLetter = gridSquare.substring(0,1);
        String secondLetter = gridSquare.substring(1,2);
        int i1 = (gridLetters.indexOf(firstLetter)) % 5 ;
        int j1 = 4 - (gridLetters.indexOf(firstLetter)) / 5 ;
        int i2 = (gridLetters.indexOf(secondLetter)) % 5 ;
        int j2 = 4 - (gridLetters.indexOf(secondLetter)) / 5 ;
        double eastSquare = (i1-2) * 500000.0 + i2 * 100000.0 ;
        double northSquare = (j1 - 1)* 500000.0 + j2 * 100000.0 ;
        try {
            double ev = Double.parseDouble(eastPart) * units + eastSquare;
            double nv = Double.parseDouble(northPart) * units + northSquare;
            return new ENPair(ev,nv);
        } catch (NumberFormatException bad) {
            throw new GridFormatException("Invalid OS Grid Reference - bad digits");
        }
    }
    private static final String t1 = "VWXYZQRSTULMNOPFGHJKABCDE" ;
    private static final String validationRegex1 = "([HJNOST][A-HJ-Z])\\s*((\\d\\d)+)$";
    private static final String validationRegex2 = "([HJNOST][A-HJ-Z])\\s*(\\d+)\\s+(\\d+)$";
    private static final java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(validationRegex1);
    private static final java.util.regex.Pattern altPattern = java.util.regex.Pattern.compile(validationRegex2);
    private static final String gridLetters = "ABCDEFGHJKLMNOPQRSTUVWXYZ" ;
    
    
    /**
     * Define the scale factor on the central meridian
     * @return scale factor (0.9996012717)
     */
    public double f0() {
        return 0.9996012717 ;
    }
    
    /**
     * Define latitude of true origin
     * @return Latitude (degrees) of the true origin (49.0)
     */
    public double phi0() {
        return Math.toRadians(49.0);
    }
    
    /**
     * Define the false northing value
     * @return False Northing distance (-100km)
     */
    public double n0() {
        return -100000.0 ;
    }
    
    /**
     * Define false easting value
     * @return false easting value (400km)
     */
    public double e0() {
        return 400000.0 ;
    }
    
    /**
     * Define value of central meridian (degrees)
     * @return central meridian (2.0 W)
     */
    public double lamda0() {
        return Math.toRadians(-2.0);
    }
    /**
     * Check that ENPair lies within the permitted range
     * @param p
     * @return true if OK ;
     */
    protected static boolean validateEN(ENPair p){
        double x = p.east();
        double y = p.north();
        return (x>=MIN_E && x<MAX_E && y>=MIN_N && y<MAX_N);
        
    }
 
    private static final double MAX_E = 700000.0 ;
    private static final double MIN_E = 0.0 ;
    private static final double MAX_N = 1300000.0 ;
    private static final double MIN_N = 0.0 ;
}
