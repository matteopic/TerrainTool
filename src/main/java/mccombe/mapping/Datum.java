/*
 * Datum.java
 *
 * Created on 13 July 2005, 13:13
 *
 */

package mccombe.mapping;
/** 
 * <P> Datum is the base class for a coordinate system datum. Sub-classes
 *    need to define values for the seven Helmert parameters needed to translate to the
 * Datum FROM  WGS-84 </P>
 * 
 * <P>An extensive list of Helmert parameters can be found at http://earth-info.nga.mil/GandG/coordsys/datums/helmert.html
 *    Units are
 * </P>
 * <PRE>  s - ppm
 *  rx, ry, rz - seconds of arc. 
 *  tx, ty, tz - metres
 * </PRE>
 * <P>
 *    This class also defines a set of static final member instances for common Datums
 * </p>
 * @author Mike McCombe
 */
public class Datum {
    
    /**
     * Create an instance of Datum using Helmert coefficients in abstract methods
     */
    protected Datum(String name, double tx, double ty, double tz, double rotx, double roty, double rotz, double scale){
        datumName = name ;
        t = new XYZ(-tx, -ty, -tz);
        rx = -rotx*R ;
        ry = -roty*R ;
        rz = -rotz*R ;
        s = -scale*1.0e-6 ;
        rot.set(0,0, 1+s);
        rot.set(0,1, -rz);
        rot.set(0,2,  ry);
        rot.set(1,0,  rz);
        rot.set(1,1, 1+s);
        rot.set(1,2, -rx);
        rot.set(2,0, -ry);
        rot.set(2,1,  rx);
        rot.set(2,2, 1+s);
        rin = rot.inverse();
    }
    /**
     * Converts XYZ coordinates from WGS-84 to this datum using Helmert Transformation
     * @param from XYZ Coordinates referred to WGS-84
     *
     * @return XYZ Coordinates referred to this datum
     */
    public XYZ fromWGS84(XYZ from){
        Vector f = new Vector(from);
        Vector r = rot.times(f);
        Vector q = r.plus(t);
        return new XYZ(q.get(0), q.get(1), q.get(2)) ;
    }
    /**
     * Convert XYZ Coordinates referred to this datum to WGS-84
     * @param to XYZ Coordinates to convert
     * @return XYZ Coordinates referred to WGS-84
     */
    public XYZ toWGS84(XYZ to){
        Vector temp = new Vector(to);
        Vector q = temp.minus(t);
        Vector r = rin.times(q);
        return new XYZ(r.get(0), r.get(1), r.get(2)) ;
    }
    /**
     * Get X translation
     * @return X translation
     */
    public double tx() { return t.x() ;}
    /**
     * Get Y translation
     * @return Y translation
     */
    public double ty() { return t.y();}
    /**
     * Get Z translation
     * @return Z Translation
     */
    public double tz() {return t.z();}
    /**
     * Get rotation about X
     * @return X rotation
     */
    public double rx() { return rx ;}
    /**
     * Get Y rotation
     * @return Y rotation
     */
    public double ry() { return ry ;}
    /**
     * Get Z rotation
     * @return Z rotation
     */
    public double rz() { return rz ;}
    /**
     * Get scale factor adjustment
     * @return Scale factor adjustment (ppm)
     */
    public double s() { return s ;}
    /**
     * Get name of Datum
     * @return Datum name
     */
    @Override
    public String toString() { return datumName;}
/**
     * The European (1950) Datum
     */
    public static final Datum ED_1950 = new Datum("European Datum 1950 (Western Europe)", -87.0, -96.0, -120.0, 0.0, 0.0, 0.0, 0.0);
    /**
     * The Ireland (1965) Datum
     */
    public static final Datum IRELAND_1965 = new Datum("Ireland 1965", 482.53, -130.596, 564.557, -1.042, -0.214, -0.631, 8.15) ;
    /**
     * The French NTF Datum (used in IGN/Lambert projections)
     */
    public static final Datum NTF = new Datum("NTF Datum France (IGN)", -168.0, -60.0, 320.0, 0.0, 0.0, 0.0, 0.0);
    /**
     * The OSGB (1936) Datum - used as the Datum for UK Ordnance Survey mapping
     */
    public static final Datum OSGB_1936 = new Datum("Ordnance Survey of Great Britain 1936", 446.448, -125.157, 542.06, 0.150, 0.2470, 0.8421, -20.49);
    /**
     * The WGS (1984) Datum
     */
    public static final Datum WGS_1984 = new Datum("WGS-84", 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
    /**
     * The Australian (1984) Geodetic Datum
     */
    public static final Datum AUG_7 = new Datum("Australian Geodetic 1984", -116.0, -50.47, 141.69, 0.23, 0.39, 0.344, 0.0983);
    public static final Datum MGI = new Datum("MGI Datum (Austria)", 577.3,90.1, 463.9, 5.137, 1.474, 5.297, 2.42); //"Official NATO values
//    public static final Datum MGI = new Datum("MGI Datum (Austria)", 575 ,93, 466, 5.1, 1.6, 5.2, 2.5); //GEO values - see http://homepage.ntlworld.com/anton.helm/bmn_mgi.html
    public static final Datum MGI_SLOV = new Datum("MGI Datum (Slovenia)", 426.9,142.6,460.1,4.91,4.49,-12.42,17.1); //From OPC - see https://epsg.io/3912-3915
    /**
     * The New Zealand 1949 Datum
     */
    public static final Datum NZGD_1949 = new Datum("New Zealand 1949",59.47,-5.04,187.44,0.47,-0.1,1.024,-4.5993);
    /**
     * The New Zealand 2000 Datum
     */
    public static final Datum NZGD_2000 = new Datum("New Zealand 2000",0.0,0.0,0.0,0.0,0.0,0.0,0.0);
    private Matrix rot = new Matrix();
    private Matrix rin = new Matrix();
    private XYZ t ;
    private double rx = 0.0 ;
    private double ry = 0.0 ;
    private double rz = 0.0 ;
    private double s = 0.0  ;
    private String datumName = "" ;
    private static final double R = 4.848136811095360E-06 ; //Seconds of arc to Radians

    private class Matrix {
        Matrix(){
            
        }
        void set(int ix, int iy, double val){
            store[ix][iy] = val ;
        }
        double get(int ix, int iy){
            return store[ix][iy] ;
        }
        Vector times(Vector v){
            Vector res = new Vector() ;
            for(int i=0 ; i<3 ; i++){
                double tot = 0.0 ;
                for(int j=0 ; j<3 ; j++){
                    tot += store[i][j]*v.v[j] ;
                }
                res.set(i, tot);
            }
            return res ;
        }
        Matrix times(Matrix m){
            Matrix res = new Matrix() ;
            for(int i=0 ; i<3 ; i++){
                for(int j=0 ; j<3 ; j++){
                    double tot = 0.0 ;
                    for(int k=0 ; k<3 ; k++){
                        tot += store[i][k]*m.store[k][j] ;
                    }
                    res.store[i][j] = tot;
                }
            }
            return res ;
        }
        Matrix inverse(){
            double d = det();
            Matrix res = new Matrix();
            for(int i=0 ; i<3 ; i++){
                for (int j=0 ; j<3 ; j++){
                    res.store[j][i] = cofactor(i, j)/d;
                }
            }
            return res ;
        }
        double det() {
            double res = 0.0 ;
            for (int j=0 ; j<3 ; j++){
                res += store[0][j]*cofactor(0,j);
            }
            return res ;
        }
        double cofactor(int row, int col){
            int r1 = ptr[row][0];
            int r2 = ptr[row][1];
            int c1 = ptr[col][0];
            int c2 = ptr[col][1];
            double det = store[r1][c1]*store[r2][c2] - store[r1][c2]*store[r2][c1];
            double sign = 1.0 ;
            if(row!=col){
                sign = Math.pow(-1.0,(row-col));
            }
            return sign * det ;
        }
        private final int[][] ptr = {{1,2},{0,2},{0,1}};
        private double[][] store = {{ 0,0,0},{0,0,0},{0,0,0}};
    }
    private class Vector {
        Vector(){
        }
        Vector(XYZ p){
            v[0] = p.x();
            v[1] = p.y();
            v[2] = p.z();
        }
        void set(int ix, double val){
            v[ix] = val ;
        }
        double get(int ix) {
            return v[ix];
        }
        Vector minus(Vector a){
            Vector y = new Vector();
            for(int ix = 0 ; ix<3 ; ix++){
                y.v[ix] = v[ix] - a.v[ix];
            }
            return y ;
        }
        Vector minus(XYZ xyz){
            Vector p = new Vector(xyz);
            return minus(p);
        }
        Vector plus(Vector a){
            Vector y = new Vector();
            for(int ix = 0 ; ix<3 ; ix++){
                y.v[ix] = v[ix] + a.v[ix];
            }
            return y ;
        }
        Vector plus(XYZ xyz){
            Vector p = new Vector(xyz);
            return plus(p);
        }
        private double[] v = { 0,0,0};
    }
}
