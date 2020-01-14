/*
 * Projection.java
 *
 * Created on 05 July 2005, 17:30
 *
 */

package mccombe.mapping;

/**
 * A Projection is an abstract base class for CoordinateSystems in which a a 3-dimensional
 * position is "projected" onto a surface to allow it to be represented in 2-dimensions.
 * @author Mike McCombe
 */
public abstract class Projection extends CoordinateSystem {
    
    /** Creates a new instance of Projection */
    
    protected Projection() {
//        super();
    }
    /*
    public Projection(LatLong place, Ellipsoid e, Datum d){
        super(place, e, d);
    }
    @Deprecated
    public Projection(XYZ coords, Ellipsoid e, Datum d){
        super(coords, e, d);
    }
     **/
    /**
     * Create a new Projection for a Position. The projection uses a specified Ellipsoid and Datum.
     * @param p The Position
     * @param e Ellipsoid to use
     * @param d Datum to be used.
     */
    public Projection(Position p, Ellipsoid e, Datum d){
        super(p, e, d);
    }
    /**
     * Get a 2-dimensional representation of the projected position as easting 
     * and northing distances
     * @return An ENPair representing the projected Position
     */
    public abstract ENPair toEN() ;
    /**
     * Calculate Grid Convergence - the angle between the North axis
     * and True North at this particular point.
     * @return Grid convergence (radians)
     */
    public abstract double gridConvergence(); //Grid convergence - in radians

}
