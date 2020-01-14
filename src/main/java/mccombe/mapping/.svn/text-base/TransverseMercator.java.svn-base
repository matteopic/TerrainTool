/*
 * TransverseMercator.java
 *
 * Created on 05 July 2005, 16:14
 *
 */

package mccombe.mapping;

/**
 * <P>TransverseMercator is an abstract base class for coordinate systems
 *    derived from the Transverse Mercator Projection. Methods are provided
 *    for standard conversions between Lat/Lon and Easting/Northing
 * </P>
 *
 * <P> Concrete sub-classes derived from TransverseMercator need to provide values for
 * the projection constants f0(), phi0(), n0(), e0() and lamda0() (see below).
 * </P>
 * @author Mike McCombe
 */
public abstract class TransverseMercator extends Projection {
    
    /**
     * Default constructor for TransverseMercator 
     */
    protected TransverseMercator(){
        n = (sph.majoraxis()-sph.minoraxis())/(sph.majoraxis() + sph.minoraxis());
    }
    
    /**
     * Create a new TransverseMercator instance for a location specified by
     * Position, Ellipsoid and Datum
     *
     * @param p A Position object defining the location
     * @param e The Ellipsoid used as a reference
     * @param d The Datum used
     */
    public TransverseMercator(Position p, Ellipsoid e, Datum d){
        super(p, e, d);
        n = (sph.majoraxis()-sph.minoraxis())/(sph.majoraxis() + sph.minoraxis());
        LatLong geog = locus.toLatLong(sph, ref);
        northernHemisphere = geog.lat() > 0.0 ;
    }
    /**
     * Create an instance of TransverseMercator based on a specified ENPair
     * @param point An ENPair containing the Easting and Northing distances of the point
     * @param sphere The Ellipsoid to use
     * @param datum The Datum to use with this instance
     */
    public TransverseMercator(ENPair point, Ellipsoid sphere, Datum datum){
        this(point, 30, sphere, datum, true);
    }
    /**
     * Create an instance of TransverseMercator based on a specified ENPair
     * @param sphere The Ellipsoid to use
     * @param z UTM Zone number
     * @param datum The Datum to use with this instance
     * @param point An ENPair containing the Easting and Northing distances of the point
     * @param hemisphere true if the point is in the Northern hemisphere
     */
    protected TransverseMercator(ENPair point, int z, Ellipsoid sphere, Datum datum, boolean hemisphere){
        zone = z ;
        sph = sphere ;
        ref = datum ;
        northernHemisphere = hemisphere ;
        n = (sph.majoraxis()-sph.minoraxis())/(sph.majoraxis() + sph.minoraxis());
        double E = point.east() ;
        double N = point.north();
        double a = sph.majoraxis();
        double b = sph.minoraxis();
        double phiDash = (N - n0())/(a*f0()) + phi0();
        double dp = phiDash ;
        double sp = Math.sin(dp);
        double cp = Math.cos(dp);
        double tp = Math.tan(dp);
        double tpsq = tp*tp ;
        double err = N - n0() - M(dp) ;
        while (Math.abs(err) > 0.001) {
            err =  (N - n0() - M(dp))  ;
            dp +=err / (a*f0());
        }
        sp = Math.sin(dp);
        cp = Math.cos(dp);
        tp = Math.tan(dp);
        tpsq = tp*tp ;
        double nu = sph.majoraxis()*f0()/Math.sqrt(1.0 - sph.eccsq()*sp*sp);
        double rho = sph.majoraxis()*f0()*(1.0-sph.eccsq())/Math.pow((1.0 - sph.eccsq()*sp*sp),1.5);
        double etasq = nu/rho -1.0 ;
        double q7 = tp / (2.0*rho*nu);
        double q8 = tp * (5.0 + 3.0*tpsq + etasq - 9.0*tpsq*etasq)/ (24.0*rho*nu*nu*nu);
        double q9 = tp * (61.0 + 90.0*tpsq + 45.0 * tpsq*tpsq) / (720.0*rho*Math.pow(nu, 5));
        double q10 = 1.0 / (nu*cp);
        double q11 = (nu/rho + 2.0*tpsq)/(cp * 6.0 * nu*nu*nu);
        double q12 = ( 5.0 + 28.0 * tpsq + 24.0 * tpsq * tpsq)/(cp*120.0*Math.pow(nu,5));
        double q12a = (61.0 + 662.0*tpsq + 1320.0*tpsq*tpsq + 720.0 * tpsq * tpsq * tpsq)/(5040.0 * Math.pow(nu,7) * cp);
        double de = E - e0();
        double phi = dp - q7 * de*de + q8 * Math.pow(de, 4) - q9 * Math.pow(de, 6);
        double lamda = lamda0() + q10 * de - q11 * Math.pow(de, 3) + q12 * Math.pow(de, 5) - q12a * Math.pow(de, 7);
        locus = new Position(new LatLong(Math.toDegrees(phi), Math.toDegrees(lamda)), 0.0, sph, ref);
    }
    
    /**
     * Provide an ENPair containing Easting and Northing distances for this point
     * @return an ENPair
     */
    public ENPair toEN() {
        LatLong geog = locus.toLatLong(sph, ref);
        double sp = Math.sin(Math.toRadians(geog.lat()));
        double cp = Math.cos(Math.toRadians(geog.lat()));
        double tp = Math.tan(Math.toRadians(geog.lat()));
        double tpsq = tp*tp ;
        double nu = sph.majoraxis()*f0()/Math.sqrt(1.0 - sph.eccsq()*sp*sp);
        double rho = sph.majoraxis()*f0()*(1.0-sph.eccsq())/Math.pow((1.0 - sph.eccsq()*sp*sp),1.5);
        double etasq = nu/rho -1.0 ;
        double dp = Math.toRadians(geog.lat());
        double q1 = M(dp) + n0();
        double q2 = nu*sp*cp/2.0 ;
        double q3 = (nu/24.0)*sp*cp*cp*cp*(5.0-tpsq+9.0*etasq);
        double q3a = (nu/720.0)*sp*Math.pow(cp,5)*(61.0-58.0*tpsq+tpsq*tpsq);
        double q4 = nu*cp ;
        double q5 = (nu/6.0)*cp*cp*cp*((nu/rho)-tpsq);
        double q6 = (nu/120.0)*Math.pow(cp, 5)*(5.0 - 18.0*tpsq + tpsq*tpsq + 14.0*etasq-58.0*tpsq*etasq);
        double dl = Math.toRadians(geog.lon())-lamda0() ;
        if(dl>Math.PI) dl -= 2.0*Math.PI ;
        if(dl< -Math.PI) dl += 2.0*Math.PI ;
        double N = q1 + q2*Math.pow(dl,2)+q3*Math.pow(dl, 4) + q3a*Math.pow(dl, 6);
        double E = e0() + q4*dl + q5*Math.pow(dl, 3)+ q6*Math.pow(dl, 5);
        return new ENPair(E, N);
    }
    
    /**
     * Calculate the Grid Convergence for the current location. Grid Convergence
     * is defined as the angle between Grid North and True North. The value is
     * zero on the Central Meridian.
     *
     * @return The value of Grid Convergence (radians)
     */
    public double gridConvergence(){
        LatLong geog = locus.toLatLong(sph, ref);
        double lat = geog.lat();
        double lon = geog.lon();
        double sl = Math.sin(Math.toRadians(lat));
        double cl = Math.cos(Math.toRadians(lat));
        double rho = sph.majoraxis()*(1.0-sph.eccsq())*Math.pow(1.0-sph.eccsq()*sl*sl, -3/2);
        double nu = sph.majoraxis()*Math.pow(1.0-sph.eccsq()*sl*sl,-1/2);
        double psi = nu/rho ;
        double t = Math.tan(Math.toRadians(lat));
        double omega = Math.toRadians(lon) - lamda0() ;
        double term1 = -omega*sl;
        double term2 = -(Math.pow(omega,3)/3.0)*sl*cl*cl*(2*psi*psi-psi);
        double term3 = -(Math.pow(omega,5)/15.0)*sl*Math.pow(cl,4)*(Math.pow(psi,4)*(11-24*t*t)-Math.pow(psi,3)*(11-36*t*t)+2*psi*psi*(1-7*t*t)+psi*t*t);
        double term4 = -(Math.pow(omega,7)/315.0)*sl*Math.pow(cl,6)*(17-26*t*t+2*Math.pow(t,4));
        return term1 + term2 + term3 + term4 ;
        
    }
    /**
     * Calculate the Point Scale Factor for the current Position. This is f0() on the central meridian.
     * 
     * @return The Point Scale Factor 
     */
    public double pointScaleFactor(){
        LatLong geog = locus.toLatLong(sph, ref);
        double lat = geog.lat();
        double lon = geog.lon();
        double sl = Math.sin(Math.toRadians(lat));
        double cl = Math.cos(Math.toRadians(lat));
        double rho = sph.majoraxis()*(1.0-sph.eccsq())*Math.pow(1.0-sph.eccsq()*sl*sl, -3/2);
        double nu = sph.majoraxis()*Math.pow(1.0-sph.eccsq()*sl*sl,-1/2);
        double psi = nu/rho ;
        double t = Math.tan(Math.toRadians(lat));
        double omega = Math.toRadians(lon) - lamda0() ;
        double term1 = (omega*omega/2.0)*psi*cl*cl;
        double term2 = (Math.pow(cl*omega,4)/24.0)*(4.0*Math.pow(psi,3)*(1.0-6.0*t*t)+psi*psi*(1.0+24.0*t*t)-4.0*psi*t*t);
        double term3 = (Math.pow(cl*omega,6.0)/720.0)*(61.0-148.0*t*t+16.0*Math.pow(t,4.0));
        return f0()*(1.0 + term1 + term2 + term3)  ;
        
    }
    private double n = 0.0 ;
    private double M(double dp){
        double v = sph.minoraxis()*f0()*(
                (1.0 + n + 5.0*n*n/4.0 +5.0*n*n*n/4.0)*(dp - phi0())
                -(3.0*n + 3.0*n*n + 21.0*n*n*n/8.0)*Math.sin(dp-phi0())*Math.cos(dp+phi0())
                +(15.0*n*n/8.0 + 15.0*n*n*n/8.0)*Math.sin(2.0*(dp-phi0()))*Math.cos(2.0*(dp+phi0()))
                -35.0*n*n*n*Math.sin(3.0*(dp-phi0()))*Math.cos(3.0*(dp+phi0()))/24.0);  
        return v ;
    }
    protected boolean northernHemisphere = true ;
    protected int zone = 30;
 /**
     * The scale factor on the Central Meridian. Generally, Transverse Mercator
     * projections increasingly exagerate distances further from the central
     * meridian. It is usual to reduce the scale factor at the central meridian
     * to compensate for this effect and optimise the scale over the area of interest.
     * @return the value of the ScaleFactor at the central meridian.
     */
    public abstract double f0() ;   //Scalefactor on central meridian
    /**
     * phi0() defines the latitude of the true origin of the projection.
     *
     * Note, however, that many Transverse Mercator projections employ a
     * false origin. See n0() and e0() below.
     *
     *
     * @return The latitude of the true origin (radians)
     */
    public abstract double phi0() ; //Latitude of true origin (radians)
    /**
     * n0() defines the "false northing" distance of the projection. False origins
     * are usually used with TM projections to ensure that easting and northing
     * distances are always positive over the area of interest. n0() is used as an
     * offset to the grid so that the "true origin" appears to have a northing value
     * equal to n0().
     *
     * @return The false northing distance (double)
     */
    public abstract double n0();    //Northing of true origin
    /**
     * e0() defines the "false easting" distance of the projection. False origins
     * are usually used with TM projections to ensure that easting and northing
     * distances are always positive over the area of interest. e0() is used as an
     * offset to the grid so that the "true origin" appears to have an easting value
     * equal to e0().
     *
     * @return The false easting distance (double)
     */
    public abstract double e0();    //Easting of true origin
    /**
     * lamda0() defines the longitude (in radians) of the true origin also
     * known as the "Central Meridian".
     * @return The central meridian (radians)
     */
    public abstract double lamda0();    //Longitude of true origin and central meridian
    
}
