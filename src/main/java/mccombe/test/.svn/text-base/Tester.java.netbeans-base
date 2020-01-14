
/**
 *
 * @author Mike
 * 
 * Skeleton code for testing coordinate conversions. 
 * NOT part of TerrainTool!! Could, for example, be adapted to check conversions
 * against test data provided by mapping agencies.
 */
package mccombe.test;
import mccombe.mapping.*;
public class Tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double lat = 58.0 ;
        double lon = -3.0 ;
 // Convert Lat/Lon to OSGB Grid Ref and grid convergence.       
        LatLong ll = new LatLong(lat, lon);
        System.out.printf("Starting at = %s%n", ll.toString());
        Position pos = new Position(ll, 0.0, Ellipsoid.GRS80, Datum.WGS_1984);
        OSGB zz = new OSGB(pos,Ellipsoid.AIRY, Datum.OSGB_1936);
        double c1 = zz.gridConvergence();
        System.out.printf("Calc Grid Convergence = %9.6f%n", c1);
        ENPair pr = zz.toEN();
        System.out.printf("Example 1 E %9.1f N %9.1f%n",pr.east(), pr.north());
        System.out.printf("OSGB Grid Ref = %s%n", zz.toString());
// Convert a Lat/Lon position to NZMG and back again to show that it doesn't change (much)        
        lat = -34.444066  ;
        lon = 172.739194 ;
        ll = new LatLong(lat, lon);
        System.out.printf("Starting at = %s%n", ll.toString());
        pos = new Position(ll, 0.0, Ellipsoid.INTERNATIONAL, Datum.NZGD_1949);
        NZMG z = new NZMG(pos,Ellipsoid.INTERNATIONAL, Datum.NZGD_1949);
        System.out.printf("Grid convergence = %9.6f%n", Math.toDegrees(z.gridConvergence()));
        pr = z.toEN();
        System.out.printf("Example 2 E %9.1f N %9.1f%n",pr.east(), pr.north());
        NZMG z2 = new NZMG(pr, Ellipsoid.INTERNATIONAL, Datum.NZGD_1949);
        LatLong latlon = z2.getPosition().toLatLong(Ellipsoid.INTERNATIONAL, Datum.NZGD_1949);
        System.out.printf("Lat Long = %s%n", latlon.toString());
        System.out.printf("NZMG Grid Ref = %s%n", z2.toString());

    }

}
