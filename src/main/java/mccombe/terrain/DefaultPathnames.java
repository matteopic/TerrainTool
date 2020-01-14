/*
 * Define default path names for the terraintool.properties file and the data cache. This
 * class is platform-agnostic. Use an os-specific implementation of Pathnames interface to
 * force files into os-dependent locations. See for example DebianPathnames.
 */
package mccombe.terrain;

/**
 *
 * @author Mike
 */
public class DefaultPathnames implements Pathnames {

    @Override
    public String propertiesPath() {
        return home + sep + subdir + sep ;
    }

    @Override
    public String dataPath() {
        return home + sep + subdir + sep ;
    }
    private static String home = System.getProperty("user.home");
    private static String sep = System.getProperty("file.separator");
    private static String subdir = ".terraintool";
}
