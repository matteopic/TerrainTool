/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mccombe.terrain;

import javax.swing.*;

/**
 *
 * @author Mike
 */
public class NASADEMReader extends DEMReader {

    public NASADEMReader(JComponent item) throws MissingDataFileException {
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
        return name.split("_")[2] + ".hgt";
    }
        public String copyright() {
            return copyright ;
        }
    private static final boolean downloadable = false;
    private static final int recordlength = 3601;
    private static final String filenameformat = "NASADEM_HGT_%1s%02d%1s%03d";
    private static final String name = "NASA Digital Elevation Model (NASADEM)";
    private static final String copyright = "NASADEM is a product of NASA (https://earthdata.nasa.gov/esds/competitive-programs/measures/nasadem)";
    private static final String extn = ".zip";
    private static final boolean littleendian = false;
    private static final int missingValue = -9999;
}
