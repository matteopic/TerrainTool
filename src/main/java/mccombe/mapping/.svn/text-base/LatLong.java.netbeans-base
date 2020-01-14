/*
 * LatLong.java
 *
 * Created on 05 July 2005, 16:24
 *
 */

package mccombe.mapping;

/**
 * A simple immutable wrapper class for Latitude and Longitude values
 * @author Mike McCombe
 */
public class LatLong {
    
    /** Creates a new instance of LatLong */
    public LatLong() {
    }
    /**
     * Create LatLong instance from specified values of Lat and Lon.
     * @param lat Latitude (degrees)
     * @param lon Longitude (degrees)
     */
    public LatLong(double lat, double lon) {
        y = lat ;
        x = lon ;
    }
    /**
     * A static method to turn values of degrees, minutes and seconds into a latitude value.
     * @param ns "N" or "S". Points south of the equator have negative values of latitude.
     * @param deg Degrees. Value must not exceed 90.
     * @param min Minutes - zero or positive, less than 60.
     * @param sec Seconds - zero or positive real value less than 60.0
     * @throws mccombe.mapping.LatLongFormatException if the degrees/minutes/seconds values do not correspond to legal latitudes between
     * 0 and 90.0 or if ns is neither "N" nor "S"
     * @return value in the range -90.0 to +90.0
     */
    public static double latDMS(String ns, int deg, int min, double sec) throws LatLongFormatException {
        if(ns.length()!=1 || legalNS.indexOf(ns.toUpperCase())<0) throw new LatLongFormatException(String.format("Invalid N/S specifier <%s>",ns));
        double sign = 1.0 ;
        if(legalNS.indexOf(ns.toUpperCase())>0) sign = -1.0 ;
        if ( deg>90 || deg <0) throw new LatLongFormatException(String.format("Invalid degrees value <%d>",deg));
        if ( min>59 || min <0) throw new LatLongFormatException(String.format("Invalid minutes value <%d>",min));
        if (sec>=60 || sec <0) throw new LatLongFormatException(String.format("Invalid seconds value <%d>",sec));
        double result = sign*((double)deg + (double)min/60.0 + sec/3600.0);
        return result ;
    }
    /**
     * A static method to turn values of degrees, minutes and seconds into a longitude value.
     * @param ew "E" or "W". Points west of the reference meridian have negative values of longitude.
     * @param deg Degrees. Value must not exceed 180.
     * @param min Minutes - zero or positive, less than 60.
     * @param sec Seconds - zero or positive real value less than 60.0
     * @throws mccombe.mapping.LatLongFormatException if the degrees/minutes/seconds values do not correspond to legal longitudes between
     * 0 and 180.0 or if ew is neither "E" nor "W"
     * @return value in the range -180.0 to +180.0
     */
    public static double lonDMS(String ew, int deg, int min, double sec) throws LatLongFormatException {
        if(ew.length()!=1 || legalEW.indexOf(ew.toUpperCase())<0) throw new LatLongFormatException(String.format("Invalid E/W specifier <%s>",ew));
        double sign = 1.0 ;
        if(legalEW.indexOf(ew.toUpperCase())>0) sign = -1.0 ;
        if (deg>180 || deg <0) throw new LatLongFormatException(String.format("Invalid degrees value <%d>",deg));
        if ( min>59 || min <0) throw new LatLongFormatException(String.format("Invalid minutes value <%d>",min));
        if (sec>=60 || sec <0) throw new LatLongFormatException(String.format("Invalid seconds value <%f>",sec));
        if (deg==180 && (min!=0 || sec!=0)) throw new LatLongFormatException(String.format("Invalid minutes & seconds values <%d %f>",min,sec));
        double result = sign*((double)deg + (double)min/60.0 + sec/3600.0);
        return result ;
    }
    /**
     * Get the latitude component
     * @return Latitude (degrees)
     */
    public double lat() { return y ; }
    /**
     * Get the longitude component
     * @return Longitude (degrees)
     */
    public double lon() { return x ; }
    /**
     * Provide a String representing this latitude and longitude.
     * @return The String representation of the coordinates (in Lat/Lon format)
     */
    public String toString() {
        return toDMS(lat(), "NS") + "  " + toDMS(lon(), "EW");
    }
    public static String toDMS(double v, String signs) {
        double v1 = Math.abs(v) ;
        double s = Math.round(v1*36000.0) ;
        double sec = s % 600 ;
        s = Math.round((s-sec)/600.0) ;
        sec = sec / 10.0 ;
        double min = s % 60 ;
        double deg = Math.round((s-min)/60) ;
        String sign = signs.substring(0, 1) ;
        if(v<0) sign = signs.substring(1, 2);
        return String.format(java.util.Locale.UK,"%3.0f %s %2.0f\' %4.1f\"",  deg, sign, min, sec);
    }
    private double x = 0.0 ;
    private double y = 0.0 ;
    private static final String legalNS = "NS";
    private static final String legalEW = "EW";
}
