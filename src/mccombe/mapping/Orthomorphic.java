/*
 * Abstract base class for Conformal Orthomorphic projections such as NZMG
 *
 * Code here has been adapted from C code downloaded from New Zealand's LINZ mapping agency
 * See http://www.linz.govt.nz/geodetic/software-downloads/nzmg.zip This also contains test data.
 *
 */
package mccombe.mapping;

/**
 *
 * @author Mike McCombe
 */
public abstract class Orthomorphic extends mccombe.mapping.Projection {

    /**
     * Create a new Orthomorphic instance for a location specified by
     * Position, Ellipsoid and Datum
     *
     * @param p A Position object defining the location
     * @param e The Ellipsoid used as a reference
     * @param d The Datum used
     */
    public Orthomorphic(Position p, Ellipsoid e, Datum d) {
        super(p, e, d);
        LatLong geog = locus.toLatLong(sph, ref);
    }

    /**
     * Create an instance of Orthomorphic based on a specified ENPair
     * @param point An ENPair containing the Easting and Northing distances of the point
     * @param sphere The Ellipsoid to use
     * @param datum The Datum to use with this instance
     */
    public Orthomorphic(ENPair point, Ellipsoid sphere, Datum datum) {
        Complex zn, zd, tmp1, tmp2;
        sph = sphere;
        ref = datum;
        double x = (point.north() - n0()) / a();
        double y = (point.east() - e0()) / a();
        Complex z0 = new Complex(x, y);
        int k = cfblen() - 1;
        Complex z1 = cfb2(k);
        for (int i = k - 1; i >= 0; i--) {
            z1 = z1.mul(z0);
            z1 = z1.add(cfb2(i));
        }
        z1 = z1.mul(z0);
        for (int it = 1; it >= 0; it--) {
            zn = cfb1(k).mul(5.0);
            zd = cfb1(k).mul(6.0);
            for (int i = 4; i > 0; i--) {
                tmp2 = cfb1(i).mul((double) i);
                tmp1 = zn.mul(z1);
                zn = tmp1.add(tmp2);
                tmp2 = cfb1(i).mul((double) (i + 1));
                tmp1 = zd.mul(z1);
                zd = tmp1.add(tmp2);
            }
//    cadd( &zn, &z0, cmult( &zn, cmult( &zn, &zn, &z1), &z1));
            zn = zn.mul(z1);
            zn = zn.mul(z1);
            zn = zn.add(z0);
//    cadd( &zd, cfb1, cmult( &zd, &zd, &z1 ));
            zd = zd.mul(z1);
            zd = zd.add(cfb1(0));

            z1 = zn.div(zd);
        }
        double lon = lamda0() + z1.i();
        int imax = cfllen() - 1;
        double sum = cfl(imax);
        double tmp = z1.r();
        for (int i = imax - 1; i >= 0; i--) {
            sum = sum * tmp + cfl(i);
        }
        sum *= tmp / 3600.0e-5;
        double lat = phi0() + Math.toRadians(sum);
        locus = new Position(new LatLong(Math.toDegrees(lat), Math.toDegrees(lon)), 0.0, sph, ref);
    }

    @Override
    public ENPair toEN() {
        LatLong geog = locus.toLatLong(sph, ref);
//        void geod_nzmg( double lt, double ln, double *n, double *e ) {
        Complex z0, z1;

        double lt = (geog.lat() - Math.toDegrees(this.phi0())) * 3600.0e-5;
        double ln = Math.toRadians(geog.lon());

        int k = cfilen() - 1;
        double sum = cfi(k);
        for (int i = k - 1; i >= 0; i--) {
            sum = sum * lt + cfi(i);
        }
        sum *= lt;
        int j = cfblen() - 1;
        z1 = new Complex(sum, ln - lamda0());
        z0 = cfb1(j);
        for (int i = j - 1; i >= 0; i--) {
            z0 = z0.mul(z1);
            z0 = z0.add(cfb1(i));
        }
        z0 = z0.mul(z1);
        /*
        for (i = 9; i--;) sum = sum*lt+cfi[i];
        sum *= lt;

        z1.real = sum; z1.imag = ln-ln0/rad2deg;
        z0.real = cfb1[5].real; z0.imag = cfb1[5].imag;
        for ( i=5; i--;) cadd(&z0,cmult(&z0,&z0,&z1),cfb1+i);
        cmult(&z0,&z0,&z1);

         *n = n0+z0.real*a;
         *e = e0+z0.imag*a;
        }
         */
        return new ENPair(e0() + a() * z0.i(), n0() + a() * z0.r());
    }

    @Override
    public abstract double gridConvergence();

    protected double a() {
        return sph.majoraxis();
    }

    public abstract double n0();

    public abstract double e0();

    public abstract double phi0();

    public abstract double lamda0();

    public abstract double cfi(int i);

    public abstract int cfilen();

    public abstract double cfl(int i);

    public abstract int cfllen();

    public abstract int cfblen();

    public abstract Complex cfb1(int i);

    public abstract Complex cfb2(int i);

    public static final class Complex {

        public Complex(double real, double imag) {
            x = real;
            y = imag;
        }

        public Complex add(Complex c) {
            return new Complex(c.r() + x, c.i() + y);
        }

        public Complex sub(Complex c) {
            return new Complex(x - c.r(), y - c.i());
        }

        public Complex mul(Complex c) {
            double rx = x * c.r() - y * c.i();
            double ry = x * c.i() + y * c.r();
            return new Complex(rx, ry);
        }

        public Complex mul(double r) {
            return new Complex(r * x, r * y);
        }

        public Complex div(double r) {
            return new Complex(x / r, y / r);
        }

        public Complex div(Complex c) {
            double bottom = c.modsq();
            Complex top = this.mul(c.conjg());
            return top.div(bottom);
        }

        public double modsq() {
            return x * x + y * y;
        }

        public double r() {
            return x;
        }

        public double i() {
            return y;
        }

        public Complex conjg() {
            return new Complex(x, -y);
        }

        public String toString() {
            return String.format("(%13.6f,%13.6f)", x, y);
        }
        private final double x;
        private final double y;
    }
}
