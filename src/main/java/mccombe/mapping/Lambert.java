/*
 * Lambert.java
 *
 * Created on 05 July 2005, 22:15
 */

package mccombe.mapping;

/**
 * <p>An abstract base class for implementations of the Lambert Conformal Conic Projection</p>
 * <p>A Lambert projection maps points on the ellipsoid onto a cone which touches the ellipsoid 
 * at two parallels of latitude. For countries with a large east-west extent, it provides smaller
 * variations in grid convergence than the more common TransverseMercator projection - but over
 * a limited range of latitude. IGN, France's national mapping agency, adopted the Lambert
 * Conformal Conic projection but had to divide mainland France into three zones of latitude,
 * with a fourth zone for the island of Corsica. These are implemented in this package as
 * subclasses of Lambert (see {@link mccombe.mapping.LambertI LambertI}, 
 * {@link mccombe.mapping.LambertII LambertII}, 
 * {@link mccombe.mapping.LambertIII LambertIII},
 * {@link mccombe.mapping.LambertIV LambertIV}). To overcome the obvious inconvenience of
 * having the country divided into four distinct coordinate zones, a fifth set of Lambert Conformal Conical 
 * projection coefficients {@link mccombe.mapping.LambertIIExtended LambertIIExtended} was produced to 
 * provide a nationwide coordinate system but with greater degrees of distortion. Ironically,
 * the Lambert Conical projections have not been well-supported by handheld GPS equipment and
 * many French maps (such as the 1:25000 Blue Series) are now over-printed with a UTM grid.</p>
 *<p>In 1996, IGN introduced a new coordinate system known as {@link mccombe.mapping.Lambert93 Lambert 93}
 * </p>
 * @author Mike McCombe
 * @see <a href="http://www.eionet.eu.int/gis/docs/ETRS_LCC011023.doc">ETRS89 Lambert Conformal Conic Coordinate Reference System </a>
 * @see <a href="http://ign.fr/telechargement/education/fiches/geodesie/projections.pdf">Systemes de Projection (in French) </a> 
 */
public abstract class Lambert extends mccombe.mapping.Projection {
    
    /**
     * Creates a new instance of Lambert based on Position, Ellipsoid and Datum
     * @param p Position of this point
     * @param e The Ellipsoid to use
     * @param d The Datum associated with this instance
     */
    public Lambert(Position p, Ellipsoid e, Datum d){
        super(p, e, d);
        LatLong geog = p.toLatLong(e, d);
        double qL = q(phiL());
        double qU = q(phiU());
        double qB = q(phiB());
        double wL = w(phiL());
        double wU = w(phiU());
        double sp0 = Math.log(wU*Math.cos(phiL())/(wL*Math.cos(phiU())))/(qU-qL);
        double a = sph.majoraxis();
        double k = (a*Math.cos(phiL())*Math.exp(qL*sp0))/(wL*sp0); //Mapping radius at equator
        double r0 = k / Math.exp(qB*sp0);
        double q = q(Math.toRadians(geog.lat()));
        double r = k / Math.exp(q*sp0);
        gamma = (lamda0() - Math.toRadians(geog.lon()))*sp0 ;
        east = e0() - r*Math.sin(gamma);
        north = r0 + n0() - r*Math.cos(gamma);
        double sp = Math.sin(Math.toRadians(geog.lat()));
        scaleFactor = Math.sqrt(1 - sph.eccsq()*sp*sp)*r*sp0/(a*Math.cos(Math.toRadians(geog.lat())));
    }
    /**
     * Create a new Lambert object based on Easting and Northing distances
     * @param en Easting and Northing values
     * @param sphere The Ellipsoid to use
     * @param datum the Datum to use
     */
        public Lambert(ENPair en, Ellipsoid sphere, Datum datum)  {
        sph = sphere ;
        ref = datum ;
        double xCoord = en.east() ;
        double yCoord = en.north() ;
        double qL = q(phiL());
        double qU = q(phiU());
        double qB = q(phiB());
        double wL = w(phiL());
        double wU = w(phiU());
        double sp0 = Math.log(wU*Math.cos(phiL())/(wL*Math.cos(phiU())))/(qU-qL);
        double a = sph.majoraxis();
        double k = (a*Math.cos(phiL())*Math.exp(qL*sp0))/(wL*sp0); //Mapping radius at equator
        double r0 = k / Math.exp(qB*sp0);
        double rdash = r0 - yCoord + n0() ;
        double edash = e0() - xCoord ;
        double r = Math.sqrt(edash*edash + rdash*rdash);
        double q = Math.log(k/r)/sp0 ;
        gamma = Math.atan(edash/rdash);
        double lamda = lamda0() - gamma/sp0 ;
        double sp = (Math.exp(2*q) - 1.0)/(Math.exp(2*q)+1);
        double corr = 1.0 ;
        double e = Math.sqrt(sph.eccsq());
        while (Math.abs(corr) > LIMIT){
            double f1 = (Math.log((1+sp)/(1-sp)) - e*Math.log((1+e*sp)/(1-e*sp)))/2.0 - q ;
            double f2 = 1/(1-sp*sp) - sph.eccsq()/(1-sph.eccsq()*sp*sp);
            corr = -f1/f2 ;
            sp += corr ;
        }
        double lat = Math.toDegrees(Math.asin(sp));
        double lon = Math.toDegrees(lamda);
        scaleFactor = Math.sqrt(1 - sph.eccsq()*sp*sp)*r*sp0/(a*Math.cos(Math.asin(sp)));
        locus = new Position(new LatLong(lat,lon), 0.0, sphere, datum);
    }
    /**
     * Parse Lambert coordinates into easting and northing distances
     * @param gridref A pair of Lambert coordinates (e.g. "X=435.212 Y=217.306"), specified in km.
     * @throws mccombe.mapping.GridFormatException Invalid coordinate format results in a GridFormatException being thrown
     * @return Easting and Northing distances (m)
     */
    protected static ENPair getEN(String gridref) throws GridFormatException {
        double xCoord = 0.0 ;
        double yCoord = 0.0 ;
        boolean gotX = false ;
        boolean gotY = false ;
        try {
            String regex = "[ \t=]+";
            String[] parts = gridref.split(regex);
            int n = parts.length ;
            switch (n) {
                case 2 : {
                    xCoord = parseDouble(parts[0]);
                    yCoord = parseDouble(parts[1]);
                    break ;
                }
                case 4 : {
                    for(int i=0 ; i<4 ; i+=2){
                        if(parts[i].equalsIgnoreCase("X")){
                            xCoord = parseDouble(parts[i+1]);
                            gotX = true ;
                            
                        } else if(parts[i].equalsIgnoreCase("Y")){
                            yCoord = parseDouble(parts[i+1]);
                            gotY = true ;
                        }
                    }
                    if(gotX && gotY) break ;
                }
                default : {
                    throw new GridFormatException("Invalid Lambert Coordinate String");
                }
            }
        } catch (java.util.regex.PatternSyntaxException e){
            throw new GridFormatException("Invalid Lambert Coordinate String");
        } catch (NumberFormatException e){
            throw new GridFormatException("Invalid Lambert Coordinate String");
        }
        catch (java.text.ParseException e){
            throw new GridFormatException("Invalid Lambert Coordinate String");
        }
        return new ENPair(xCoord*1000.0, yCoord*1000.0);
    }
    /**
     * Provide easting and northing distances
     * @return Easting and Northing distances (in metres)
     */
    public ENPair toEN() {
        calcCoords();
        return new ENPair(east,north);
    }
    /**
     * Provide a String representation in Lambert coordinates. 
     * These are of the form "X=eeee.eee Y=nnnn.nnn" where eeee.eee and nnnn.nnn are the easting and northing
     * distances in km.
     * @return The coordinate String
     */
    public String toString(){
        calcCoords();
        String res = String.format("X = %11.3f Y = %11.3f", east/1000.0, north/1000.0);
        return res ;
    }
    /**
     * Initialise coordinates for this Position
     */
    protected void calcCoords() {
        LatLong geog = locus.toLatLong(sph, ref);
        double qL = q(phiL());
        double qU = q(phiU());
        double qB = q(phiB());
        double wL = w(phiL());
        double wU = w(phiU());
        double sp0 = Math.log(wU*Math.cos(phiL())/(wL*Math.cos(phiU())))/(qU-qL);
        double a = sph.majoraxis();
        double k = (a*Math.cos(phiL())*Math.exp(qL*sp0))/(wL*sp0); //Mapping radius at equator
        double r0 = k / Math.exp(qB*sp0);
        double q = q(Math.toRadians(geog.lat()));
        double r = k / Math.exp(q*sp0);
        gamma = (lamda0() - Math.toRadians(geog.lon()))*sp0 ;
        east = e0() - r*Math.sin(gamma);
        north = r0 + n0() - r*Math.cos(gamma);
        double sp = Math.sin(Math.toRadians(geog.lat()));
        scaleFactor = Math.sqrt(1 - sph.eccsq()*sp*sp)*r*sp0/(a*Math.cos(Math.toRadians(geog.lat())));
    }
    /**
     * Calculate grid convergence
     * @return Grid convergence (degrees)
     */
    public double gridConvergence(){
        this.calcCoords();
        return Math.toDegrees(gamma) ;
    }
    /**
     * Define the default datum for this coordinate system
     * @return default datum
     */
    public mccombe.mapping.Datum defaultDatum() { return Datum.NTF ; }
    /**
     * Define the default Ellipsoid for this coordinate system
     * @return default Ellipsoid
     */
    public mccombe.mapping.Ellipsoid defaultEllipsoid() { return Ellipsoid.CLARKE ; }
    
    private double q(double lat) {
        double e = Math.sqrt(sph.eccsq());
        double sp = Math.sin(lat);
        double res = (Math.log((1+sp)/(1-sp)) - e*Math.log((1+e*sp)/(1-e*sp)))/2.0 ;
        return res ;
    }
    private double w(double lat){
        double e = Math.sqrt(sph.eccsq());
        double sp = Math.sin(lat);
        double res = Math.sqrt(1 - sph.eccsq()*sp*sp);
        return res ;
    }

    //Define abstract methods for projection constants
    /**
     * Define Upper standard parallel for this conical projection
     * @return Upper Standard Parallel (radians)
     */
    protected abstract double phiU() ;  //Upper parallel
    /**
     * Define lower standard parallel for this projection
     * @return Lower Standard Parallel (radians)
     */
    protected abstract double phiL() ;  //Lower parallel
    /**
     * Define latitude of false origin
     * @return Latitude of false origin (radians)
     */
    protected abstract double phiB() ;  //Latitude of false origin  
    /**
     * Define longitude of grid origin
     * @return Longitude of grid origin (radians)
     */
    protected abstract double lamda0() ;//Longitude of grid origin
    /**
     * Define false easting value
     * @return False easting (m)
     */
    protected abstract double e0() ;    //False easting
    /**
     * Define false northing
     * @return False northing distance (m)
     */
    protected abstract double n0() ;    //False northing
    
    // Local variables
    private double scaleFactor = 1.0 ;  //Scale factor
    private double gamma = 0.0 ;        //Grid convergence  
    private double east = 0.0 ;         //Easting value
    private double north = 0.0 ;        //Northing value
    private static final double LIMIT = 1.0E-7 ; //Convergence limit
    
}
