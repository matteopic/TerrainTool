/*
 * Provide sensible pathnames for data files and properties for use with Unix platforms
 */
package mccombe.terrain;

/**
 *
 * @author Mike McCombe
 */
public class UnixPathnames implements Pathnames{

    @Override
    public String propertiesPath() {
        if(confighome!=null){
            return confighome + sep + "terraintool" + sep;
        }
        else {
            return home + sep + ".config" + sep + "terraintool" + sep;
        }
    }

    @Override
    public String dataPath() {
        if(datahome!=null){
            return datahome + sep + "terraintool" + sep;
        }
        else {
            return home + sep + ".local" + sep + "share" + sep + "terraintool" + sep;
        }
    }
    private static String confighome = System.getenv("$XDG_CONFIG_HOME");
    private static String datahome = System.getenv("$XDG_DATA_HOME");
    private static String sep = System.getProperty("file.separator");
    private static String home = System.getProperty("user.home");
}
