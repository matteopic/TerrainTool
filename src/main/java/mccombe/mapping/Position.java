/*
 * Position.java
 *
 * Created on 24 October 2007, 22:06
 *
 */

package mccombe.mapping;

/**
 * A Position represents the absolute location of a point in 3D space, independent of
 * any particular Datum, Ellipsoid or type of coordinates. The nature of the internal 
 * representation of this point is deliberately encapsulated and irrelevant. This class
 * does not override the <code>toString()</code> method because a Position needs to be
 * part of a <code>CoordinateSystem</code> to have a meaningful String representation. 
 * 
 * <p>Instances of this class are immutable.</p>
 * @author Mike McCombe
 */
public class Position {
    
    /**
     * Creates a new instance of Position based on cartesian coordinates relative to the 
     * specified Datum.
     * @param point XYZ coordinates of this position relative to the specified Datum
     * @param datum The Datum used as the basis of the cartesian coordinates
     */
    public Position(XYZ point, Datum datum) {
        cartesian = datum.toWGS84(point) ;
    }
    /**
     * Create a new Position using Lat/Long relative to a specified Ellipsoid and Datum
     * @param geo LatLong of the point
     * @param ellipsoidHeight Height above the Ellipsoid of this point (double)
     * @param sphere The Ellipsoid against which this Lat & Lon are defined
     * @param datum The Datum used to measure the Lat & Lon
     */
    public Position(LatLong geo, double ellipsoidHeight, Ellipsoid sphere, Datum datum){
        double h = ellipsoidHeight ;
        double a = sphere.majoraxis();
        double sp = Math.sin(Math.toRadians(geo.lat()));
        double cp = Math.cos(Math.toRadians(geo.lat()));
        double sl = Math.sin(Math.toRadians(geo.lon()));
        double cl = Math.cos(Math.toRadians(geo.lon()));
        
        double nu = a / Math.sqrt(1 - sphere.eccsq()*sp*sp);
        double x = (nu + h)*cp*cl ;
        double y = (nu + h)*cp*sl ;
        double z = ((1 - sphere.eccsq())*nu + h)*sp ;
        XYZ loc = new XYZ(x,y,z);
        cartesian = datum.toWGS84(loc);
    }
    /**
     * Get the cartesian coordinates of this Position relative to a specified Datum
     * @param datum The Datum against which to measure the Position
     * @return Cartesian (XYZ) coordinates of this Position
     */
    public XYZ coords(Datum datum){ return datum.fromWGS84(cartesian); }
    
    /**
     * Get the LatLong of this Position relative to specified Ellipsoid and Datum
     * @param sphere The Ellipsoid to use as reference
     * @param datum The Datum to measure relative to
     * @return A LatLong object for this Position
     */
    public LatLong toLatLong(Ellipsoid sphere, Datum datum){
        XYZ now = datum.fromWGS84(cartesian); //This x, y, z needs to be wrt current datum
        double x = now.x();
        double y = now.y();
        double z = now.z();
        double lamda = Math.atan2(y, x);
        double p = Math.sqrt(x*x + y*y);
        double phi = Math.atan(z/(p*(1-sphere.eccsq())));
        double delta = 10.0;
        while (Math.abs(delta)>1.e-8){
            double sp = Math.sin(phi);
            double nu = sphere.majoraxis()/Math.sqrt(1-sphere.eccsq()*sp*sp);
            double p2 = Math.atan((z+nu*sphere.eccsq()*sp)/p);
            delta = p2 - phi ;
            phi = p2 ;
        }
        return new LatLong(Math.toDegrees(phi), Math.toDegrees(lamda))  ;
    }
    /**
     * Calculate the height of this Position above the specified Ellipsoid.
     * @param sphere The Ellipsoid from which to calculate the height
     * @param datum The Datum defining the location of the Ellipsoid
     * @return The height in metres of this position above the Ellipsoid
     */
    public double ellipsoidHeight(Ellipsoid sphere, Datum datum){
        XYZ now = datum.fromWGS84(cartesian); //This x, y, z needs to be wrt current datum
        double x = now.x();
        double y = now.y();
        double z = now.z();
        double lamda = Math.atan2(y, x);
        double p = Math.sqrt(x*x + y*y);
        double phi = Math.atan(z/(p*(1-sphere.eccsq())));
        double delta = 10.0;
        double nu =0.0 ;
        while (Math.abs(delta)>1.e-8){
            double sp = Math.sin(phi);
            nu = sphere.majoraxis()/Math.sqrt(1-sphere.eccsq()*sp*sp);
            double p2 = Math.atan((z+nu*sphere.eccsq()*sp)/p);
            delta = p2 - phi ;
            phi = p2 ;
        }
        return p/Math.cos(phi) - nu  ;
    }
    /**
     * Compare this Position with another Object
     * @param o The Object to compare with
     * @return TRUE if o is an instance of Position co-located with this Position.
     */
    public boolean equals(Object o){
        if(o instanceof Position) {
            Position p = (Position) o ;
            return (this.cartesian.x()== p.cartesian.x() && this.cartesian.y()== p.cartesian.y() && this.cartesian.z()== p.cartesian.z());
        }
        return false ;
    }
    private XYZ cartesian ; //WGS84 coordinates of this point
}
