/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mccombe.mapping;

/**
 *
 * @author Mike
 */
public class AustrianM34 extends BMN {
    public AustrianM34(Position p, Ellipsoid e, Datum d){
        super(p, e, d);
        zonename = "M34";
    }
    public AustrianM34(ENPair en, Ellipsoid e, Datum d){
        super(en, e, d);
    }
    public static AustrianM34 makePoint(String gridRef, Ellipsoid e, Datum d)throws GridFormatException {
        String arg = gridRef.toUpperCase().trim();
        java.util.regex.Matcher matcher = pattern.matcher(arg);
        if (matcher.find()) {
            String zoneNumber = matcher.group(1);
            String eastingNum = matcher.group(2);
            String northingNum = matcher.group(3);
            try {
                double xCoord = Double.parseDouble(eastingNum);
                double yCoord = Double.parseDouble(northingNum);
                ENPair pa = new ENPair(xCoord, yCoord);
                return new AustrianM34(pa, e, d);
            } catch (NumberFormatException ee) {
                throw new GridFormatException("Illegal BMN format");
            }
        }
        throw new GridFormatException("Invalid BMN grid reference");
    }
        
    @Override
    public double e0() {
        return 750000.0 ;
    }

    @Override
    public double lamda0() {
        return Math.toRadians(16.0 + 1.0/3.0);
    }
    private static final String validationRegex1 = "(M34)?\\s*(\\d+\\.?\\d*)\\s*(\\d+\\.?\\d*)$";
    private static final java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(validationRegex1);


}
