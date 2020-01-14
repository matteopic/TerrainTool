/*
 * PropertySet.java
 *
 * Created on 12 May 2006, 10:08
 *
 */

package mccombe.terrain;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Mike McCombe
 */
public class PropertySet {
    
    /** Creates a new instance of PropertySet */
    public PropertySet(String pathname, java.util.Properties defaults)  {
        File dir = new File(pathname);
        if (!dir.isDirectory()) {
            boolean madeDirectory = dir.mkdir();
            if (!madeDirectory) {
                return ;
            }
        }
       String filename = pathname + "terrain.properties";
       file = filename ;
        boolean propflag = true;
        properties = new java.util.Properties(defaults);
        java.util.Properties prop = System.getProperties();
        try {
            properties.loadFromXML(new java.io.FileInputStream(filename));
            java.util.Enumeration enums = properties.propertyNames();
            while(enums.hasMoreElements()){
                String s = (String) enums.nextElement();
                String val = properties.getProperty(s);
                prop.setProperty(s,val);
            }
            propflag = false ;
        } catch (IOException ex) {
            //Do nothing here. "propflag" causes new property file to be created.
        }
        if(propflag) {
            try {
                properties.storeToXML(new java.io.FileOutputStream(filename), "");
            } catch (java.io.IOException ex) {
                
            }
        }
        System.setProperties(prop);
        valid = true ;
    }
    public String get(TerrainProperties key){
        return properties.getProperty(key.toString());
    }
    public void set(TerrainProperties key, String value){
        properties.setProperty(key.toString(), value);
    }
    private String getProperty(String name){
        return properties.getProperty(name);
    }
    private void setProperty(String key, String value){
        properties.setProperty(key, value);
    }
    public void save() throws java.io.IOException {
        properties.storeToXML(new java.io.FileOutputStream(file),"");
     }
    public boolean isValid() { return valid; }
    private java.util.Properties properties ;
    private String file ;
    private boolean valid = false ;
    
}
