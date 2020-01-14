/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mccombe.terrain;

import java.io.EOFException;
import java.io.IOException;
import javax.swing.JComponent;

/**
 *
 * @author Mike
 */
public class ASTERReader extends DEMReader {

    public ASTERReader(JComponent item) throws MissingDataFileException {
        super(item);
    }

    public String datasetName() {
        if(useLegacy) return legacyDatasetName;
        return name;
    }

    public boolean downloadable() {
        return downloadable;
    }

    public int recordlength() {
        return recordlength;
    }

    public String formatstring() {
        if(useLegacy) return legacyfilenameformat;
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
        return name + "_dem.tif";
    }
        public String copyright() {
            return copyright ;
        }
    private static final boolean downloadable = false;
    private static final int recordlength = 3601;
    private static final String legacyfilenameformat = "ASTGTM_%1s%02d%1s%03d";
    private static final String filenameformat = "ASTGTM2_%1s%02d%1s%03d";
    private static final String name = "Advanced Spaceborne Thermal Emission and Reflection Radiometer (ASTER)  Version 2";
    private static final String legacyDatasetName = "Advanced Spaceborne Thermal Emission and Reflection Radiometer (ASTER)";
    private static final String copyright = "ASTER GDEM is a product of METI and NASA";
    private static final String extn = ".zip";
    private static final boolean littleendian = true;
    private static final int missingValue = -9999;
}
