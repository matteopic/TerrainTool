package mccombe.mapping;

import java.lang.reflect.*;

/**
 * MappingToolkit provides access to standard features of the mapping package by name.
 * It is particularly useful in a GUI environment where the user needs to be able to 
 * select from lists of CoordinateSystems, Datums and Ellipsoids
 *
 * @author Mike McCombe
 */
public class MappingToolkit {
/**
 * Construct a new MappingToolkit
 */
    public MappingToolkit() {
        LatLong latlon = new LatLong(52.0, -2.0);
        ENPair en = new ENPair(100000.0, 100000.0);
        Spherical sph = new Spherical(latlon, Ellipsoid.GRS80, Datum.WGS_1984);
        MapEntry sp = new MapEntry(sph, "52.375, -2.70916");
        coordmap.put(sp.getName(), sp);
        MapEntry p1 = new MapEntry(new OSGB(en, Ellipsoid.AIRY, Datum.OSGB_1936), "ST 430969");
        coordmap.put(p1.getName(), p1);
        p1 = new MapEntry(new LambertIIExtended(en, Ellipsoid.CLARKE, Datum.NTF), "X=455.23 Y = 2302.1");
        coordmap.put(p1.getName(), p1);
        p1 = new MapEntry(new LambertI(en, Ellipsoid.CLARKE, Datum.NTF), "X=455.23 Y = 1102.1");
        coordmap.put(p1.getName(), p1);
        p1 = new MapEntry(new LambertII(en, Ellipsoid.CLARKE, Datum.NTF), "X=455.23 Y = 2302.1");
        coordmap.put(p1.getName(), p1);
        p1 = new MapEntry(new LambertIII(en, Ellipsoid.CLARKE, Datum.NTF), "X=936.7 Y = 3102.5");
        coordmap.put(p1.getName(), p1);
        p1 = new MapEntry(new LambertIV(en, Ellipsoid.CLARKE, Datum.NTF), "X=455.23 Y = 2302.1");
        coordmap.put(p1.getName(), p1);
        p1 = new MapEntry(new Lambert93(en, Ellipsoid.GRS80, Datum.WGS_1984), "X=455.23 Y = 2302.1");
        coordmap.put(p1.getName(), p1);
        p1 = new MapEntry(new IrishGrid(en, Ellipsoid.MODIFIED_AIRY, Datum.IRELAND_1965), "M730196");
        coordmap.put(p1.getName(), p1);
        p1 = new MapEntry(new NZMG(en, Ellipsoid.INTERNATIONAL, Datum.NZGD_1949), "2487100 mE 6751049 mN");
        coordmap.put(p1.getName(), p1);
        p1 = new MapEntry(new NZTM2000(en, Ellipsoid.GRS80, Datum.NZGD_2000), "2487100 mE 6751049 mN");
        coordmap.put(p1.getName(), p1);
        p1 = new MapEntry(new UTM(en, 1, Ellipsoid.GRS80, Datum.WGS_1984), "32T 406946 5383757");
        coordmap.put(p1.getName(), p1);
        p1 = new MapEntry(new AustrianM28(en, Ellipsoid.BESSEL, Datum.MGI), "M28 486697 83757");
        coordmap.put(p1.getName(), p1);
        p1 = new MapEntry(new AustrianM31(en, Ellipsoid.BESSEL, Datum.MGI), "M31 486697 83757");
        coordmap.put(p1.getName(), p1);
        p1 = new MapEntry(new AustrianM34(en, Ellipsoid.BESSEL, Datum.MGI), "M34 486697 83757");
        coordmap.put(p1.getName(), p1);
        p1 = new MapEntry(new SloveneGrid(en, Ellipsoid.BESSEL, Datum.MGI_SLOV), "486697 83757");
        coordmap.put(p1.getName(), p1);
    }
    /**
     * Provide the default Ellipsoid for the named CoordinateSystem class
     * @param classname The name of the CoordinateSystem    
     * @return the defaultEllipsoid() for the class
     * @throws java.lang.IllegalArgumentException if the CoordinateSystem cannot be found
     */
    public Ellipsoid defaultEllipsoid(String classname) throws IllegalArgumentException {
        MapEntry m = coordmap.get(classname);
        if (m == null) {
            throw new IllegalArgumentException(String.format("No such CoordinateSystem: %s", classname));
        }
        CoordinateSystem c = m.getCoordinateSystem();
        return c.defaultEllipsoid();
    }
/**
 * Provide the default Datum for the specified CoordinateSystem 
 * @param classname A String containing the name of a CoordinateSystem
 * @return the defaultDatum()
 * @throws java.lang.IllegalArgumentException if the CoordinateSystem cannot be found.
 */
    public Datum defaultDatum(String classname) throws IllegalArgumentException {
        MapEntry m = coordmap.get(classname);
        if (m == null) {
            throw new IllegalArgumentException(String.format("No such CoordinateSystem: %s", classname));
        }
        CoordinateSystem c = m.getCoordinateSystem();
        return c.defaultDatum();
    }
/**
 * Make a CoordinateSystem instance from a grid reference 
 * @param name - the name of the CoordinateSystem to make   
 * @param args - the argument list for the class's makePoint() method   
 * @return A new CoordinateSystem instanceof the specified type
 * @throws java.lang.NoSuchMethodException
 * @throws mccombe.mapping.GridFormatException
 * @throws java.lang.IllegalAccessException
 * @throws java.lang.IllegalArgumentException
 * @throws java.lang.reflect.InvocationTargetException
 * @throws java.lang.InstantiationException
 */
    public CoordinateSystem makeCoordinateSystem(String name, Object... args) throws NoSuchMethodException, GridFormatException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {

        CoordinateSystem p = coordmap.get(name).getCoordinateSystem();
//        Class c = p.getClass();
        Class<? extends CoordinateSystem> c = p.getClass();
        Class<?>[] classes = new Class<?>[args.length];
        for (int i = 0; i < args.length; i++) {
            classes[i] = unwrap(args[i].getClass());
        }
        if (args.length == 0) {
            throw new NoSuchMethodException("Default constructor");
        }
        if (args[0] instanceof String) {
            Method make = c.getMethod("makePoint", classes);
            CoordinateSystem point = (CoordinateSystem) make.invoke(null, args);
            return point;
        } else {
            Constructor<?> con = c.getConstructor(classes);
            CoordinateSystem point = (Projection) con.newInstance(args);
            return point;
        }
    }
/**
 * Create an alphabetically ordered list of CoordinateSystem names
 * @return The list of names
 */
    public java.util.Vector<String> getCoordinateSystemNames() {
        java.util.Vector<String> coordList = new java.util.Vector<String>();
        java.util.Collection<MapEntry> types = coordmap.values();
        for (MapEntry g : types) {
            coordList.add(g.getName()); //Populate the List with an alphabetically-sorted list of types
        }
        return coordList;
    }
/**
 * Create an alphabetically-ordered list of Projections. Since Projection is a sub-class of CoordinateSystem
 * this list will be a subset of that provided by getCoordinateSystemNames()
 * @return the list of names    
 */
    public java.util.Vector<String> getProjectionNames() {
        java.util.Vector<String> coordList = new java.util.Vector<String>();
        java.util.Collection<MapEntry> types = coordmap.values();
        for (MapEntry g : types) {
            if (g.getCoordinateSystem() instanceof Projection) {
                coordList.add(g.getName());
            } 
        }
        return coordList;
    }
    /**
     * get a list of available Datum instances
     * @return the list
     */
    public java.util.Vector<Datum> getDatumList() {
        Class datumclass = Datum.WGS_1984.getClass();
        Field[] fields = datumclass.getFields();
        java.util.Vector<Datum> datumList = new java.util.Vector<Datum>();
        for (Field f : fields) {
            String name = f.getName();
            Class type = f.getType();
            String typeName = type.getName();
            if (typeName.equals("mccombe.mapping.Datum")) {
                try {
                    Datum datum = (Datum) f.get(null);
                    datumList.add(datum);
                } catch (IllegalArgumentException ex) {

                } catch (IllegalAccessException ex) {

                }
            }
        }
        return datumList;
    }
    /**
     * Get an instance of a specific Datum
     * @param name - the name of the Datum
     * @return the requested Datum instance
     */
    public Datum getDatum(String name) {
        java.util.Vector<Datum> list = getDatumList();
        for(Datum datum : list){
            if(datum.toString().equals(name)) return datum ;
        }
        return null ;
    }
    /**
     * Get an instance of a specific Ellipsoid
     * @param name - the name of the Ellipsoid
     * @return the requested Datum instance
     */
    public Ellipsoid getEllipsoid(String name) {
         java.util.Vector<Ellipsoid> list = getEllipsoidList();
        for(Ellipsoid e : list){
            if(e.toString().equals(name)) return e ;
        }
        return null;
    }
/**
 * Get an example of a grid reference for a specified CoordinateSystem
 * @param classname - the name of the CoordinateSystem  
 * @return a valid grid reference String
 * @throws java.lang.IllegalArgumentException if the CoordinateSystem name cannot be found
 */
    public String getExample(String classname) throws IllegalArgumentException {
        MapEntry m = coordmap.get(classname);
        if (m == null) {
            throw new IllegalArgumentException("No such CoordinateSystem: " + classname);
        }
        return m.getExample();
    }
/**
 * Get a list of available Ellipsoid instances
 * @return the list 
 */
    public java.util.Vector<Ellipsoid> getEllipsoidList() {
        Class ellipsoidclass = Ellipsoid.GRS80.getClass();
        Field[] fields = ellipsoidclass.getFields();
        java.util.Vector<Ellipsoid> ellipsoidList = new java.util.Vector<Ellipsoid>();
        for (Field f : fields) {
            String name = f.getName();
            Class type = f.getType();
            String typeName = type.getName();
            if (typeName.equals("mccombe.mapping.Ellipsoid")) {
                try {
                    Ellipsoid e = (Ellipsoid) f.get(null);
                    ellipsoidList.add(e);
                } catch (IllegalArgumentException ex) {

                } catch (IllegalAccessException ex) {

                }
            }
        }
        return ellipsoidList;
    }
/**
 * Add a CoordinateSystem type to the toolkit
 * @param c a CoordinateSystem instance
 * @param example - a String containing a valid grid reference for this type
 */
    public void add(CoordinateSystem c, String example) {
        MapEntry m = new MapEntry(c, example);
        coordmap.put(m.getName(), m);
    }


    private Class unwrap(Class c) {
        if (c == Integer.class) {
            return int.class;
        }
        if (c == Double.class) {
            return double.class;
        }
        if (c == Float.class) {
            return float.class;
        }
        if (c == Boolean.class) {
            return boolean.class;
        }
        if (c == Long.class) {
            return long.class;
        }
        if (c == Byte.class) {
            return byte.class;
        }
        if (c == Character.class) {
            return char.class;
        }
        if (c == Short.class) {
            return short.class;
        }
        return c;
    }

    private class MapEntry {

        public MapEntry(CoordinateSystem type, String exampleText) {
            coordinate = type;
            example = exampleText;
        }

        public String getExample() {
            return example;
        }

        public CoordinateSystem getCoordinateSystem() {
            return coordinate;
        }

        public String getName() {
            return coordinate.getName();
        }
        private String example;
        private CoordinateSystem coordinate;
    }
    private java.util.TreeMap<String, MapEntry> coordmap = new java.util.TreeMap<String, MapEntry>();
}
