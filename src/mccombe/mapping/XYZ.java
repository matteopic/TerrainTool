/*
 * XYZ.java
 *
 * Created on 13 July 2005, 13:05
 *
 */
package mccombe.mapping;

/**
 * A simple immutable class for 3D cartesian coordinates
 * @author Mike McCombe
 */
public class XYZ {

    /** Creates a new instance of XYZ */
    public XYZ() {
    }

    /**
     * Create a new XYZ coordinate
     * @param x The X component
     * @param y The Y component
     * @param z Th Z component  
     */
    public XYZ(double x, double y, double z) {
        vec3[0] = x;
        vec3[1] = y;
        vec3[2] = z;
    }

    /**
     * Get the X component
     * @return The X component
     */
    public double x() {
        return vec3[0];
    }

    /**
     * Get the Y component
     * @return The Y component
     */
    public double y() {
        return vec3[1];
    }

    /**
     * Get the Z component
     * @return The Z component 
     */
    public double z() {
        return vec3[2];
    }

    /**
     * Provide a hashcode for this XYZ based on the values contained. This is
     * necessary to meet the contract for the Object.hashcode() method which
     * requires that if object1.equals(object2) their hashcodes must also be equal.
     * 
     * @return hashcode
     */
    @Override
    public int hashCode() {
        int hash = 7 * 47;
        if (vec3 != null) {
            for (double v : vec3) {
                long z = Double.doubleToLongBits(v);
                hash = (int) ((hash+z) * 43);
            }
        }
        return hash;
    }

    /**
     * Compare this XYZ with another Object
     * 
     * @param obj - the Objecty to compare to.
     * @return true if obj is another XYZ containing the same values. They are not
     * necessarily the same object.
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof XYZ)) {
            return false;
        }
        XYZ xyz = (XYZ) obj;
        return (this.vec3[0] == xyz.vec3[0] && this.vec3[1] == xyz.vec3[1] && this.vec3[2] == xyz.vec3[2]);
    }
    double[] vec3 = {0.0, 0.0, 0.0};
}
