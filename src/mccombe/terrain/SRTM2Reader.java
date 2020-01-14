/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mccombe.terrain;

import javax.swing.JComponent;

/**
 *
 * @author Mike McCombe
 */
public class SRTM2Reader extends DEMReader {

    public SRTM2Reader(JComponent item) throws MissingDataFileException {
        super(item);
    }

    public String datasetName() {
        return name;
    }

    public boolean downloadable() {
        return downloadable;
    }

    public int recordlength() {
        return recordlength;
    }

    public String formatstring() {
        return filenameformat;
    }

    public String extn() {
        return extn;
    }

    public boolean littleendian() {
        return littleendian;
    }

    public int missingValue() {
        return missingValue;
    }
    public String zipEntryName(String name){
        return name + ".hgt";
    }
         public String copyright() {
            return copyright ;
        }
   private static final boolean downloadable = true;
    private static final int recordlength = 1201;
    private static final String filenameformat = "%1s%02d%1s%03d";
    private static final String name = "Shuttle Radar Topography Mission";
    private static final String extn = ".hgt.zip";
    private static final boolean littleendian = false;
    private static final int missingValue = -32768;
    private static final String copyright = "SRTM DEM data is public-domain.";
}
