package mccombe.terrain;

/**
 * Define interface for specifying paths for locating the properties and data files.
 * 
 * @author Mike McCombe
 */
public interface Pathnames {
    /**
     * 
     * @return String containing the pathname for terrain.properties 
     */
    public String propertiesPath();
    /**
     * 
     * @return String containing the pathname for the data-cache directory
     */
    public String dataPath();
}
