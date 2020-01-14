package mccombe.terrain;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import mccombe.mapping.*;
import java.io.*;
import java.util.zip.*;
import javax.swing.JComponent;

/**
 *
 * @author Mike
 */
public class CompositeReader extends SRTM2Reader {

    public CompositeReader(JComponent item) throws MissingDataFileException {
        super(item);
        subReader = new ASTERReader(item);
    }
    /*    @Override
    public double getHeight(LatLong place) throws MissingDataFileException {
    double ht = mainReader.getHeight(place);
    if (ht == MISSING) ht = subReader.getHeight(place);
    return ht ;
    } */
    private DEMReader subReader;

    @Override
    public double getHeight(LatLong place) throws MissingDataFileException {
        double lat = Math.floor(place.lat());
        double lon = Math.floor(place.lon());
        String ew = "E";
        String ns = "N";
        if (lat < 0) {
            ns = "S";
        }
        if (lon < 0) {
            ew = "W";
        }
        lat = Math.abs(lat);
        lon = Math.abs(lon);
        double x0 = tile(place.lon());
        double y0 = (double) (recordlength() - 1) - tile(place.lat());
        int xtile = (int) x0;
        int ytile = (int) y0;
        String pagename = makename(ns, (int) lat, ew, (int) lon);
        double[] h = new double[3];
        double[] x = new double[3];
        double[] w = new double[3];
        double[] y = new double[3];
        int k = Math.max(ytile - 1, 0);
        int m = 0;
        while (m < 3 && k < recordlength() && k < ytile + 3) {
            CacheEntry page = getRow(pagename, k, place);
            if (page == null) {
                return MISSING;
            }
            int i = 0;
            int j = xtile;
            while (i < 3 && j < recordlength() && j < xtile + 4) {
                int v = page.getValue(j);
                if (v != missingValue()) {
                    x[i] = (double) j;
                    h[i] = (double) v;
                    i++;
                } else {
                    missing++;
                }
                j++;
            }
            j = xtile - 1;
            while (i < 3 && j >= 0 && j > xtile - 3) {
                int v = page.getValue(j);
                if (v != missingValue()) {
                    x[i] = (double) j;
                    h[i] = (double) v;
                    i++;
                } else {
                    missing++;
                }
                j--;
            }
            if (i == 3) {
                java.awt.geom.Point2D.Double p0 = new java.awt.geom.Point2D.Double(x[0], h[0]);
                java.awt.geom.Point2D.Double p1 = new java.awt.geom.Point2D.Double(x[1], h[1]);
                java.awt.geom.Point2D.Double p2 = new java.awt.geom.Point2D.Double(x[2], h[2]);
                y[m] = lagrangian(x0, p0, p1, p2);
                w[m] = (double) k;
                m++;
            }
            k++;
        }
        if (m == 3) {
            java.awt.geom.Point2D.Double q0 = new java.awt.geom.Point2D.Double(w[0], y[0]);
            java.awt.geom.Point2D.Double q1 = new java.awt.geom.Point2D.Double(w[1], y[1]);
            java.awt.geom.Point2D.Double q2 = new java.awt.geom.Point2D.Double(w[2], y[2]);
            double height = lagrangian(y0, q0, q1, q2);
            resultcount++;
            return height;
        }
        return MISSING;
    }

    protected CacheEntry getRow(String name, int ytile, LatLong place) throws MissingDataFileException {
        tries++;
        cycle++;
        String shortname = String.format("%s#%04d", name, ytile);
        if (cacheEnable) {
            CacheEntry page = cache.get(shortname);
            if (page != null) {
                hits++;
                page.setLastUsed();
                return page;
            }
        }
// Record not in cache or cache not enabled
        try {

            String filename = DIRECTORY + name + extn();
            File infile = new File(filename);
            if (!infile.isFile()) {
                String tempname = name + extn();
                try {
                    downloadFile(tempname);
                } catch (IOException e) {
                    throw new MissingDataFileException(String.format("Unable to dowload missing file %s%n%s%n", tempname, e.toString()));
                } catch (java.security.KeyManagementException e) {
                    throw new MissingDataFileException(String.format("Unable to dowload missing file %s%n%s%n", tempname, e.toString()));
                } catch (java.security.NoSuchAlgorithmException e) {
                    throw new MissingDataFileException(String.format("Unable to dowload missing file %s%n%s%n", tempname, e.toString()));
                }            }
            in = new java.util.zip.ZipInputStream(new FileInputStream(infile));
            String entryname = "";
            do {
                ZipEntry entry = in.getNextEntry();
                if(entry==null) throw new MissingDataFileException(String.format("ZIP file %s does not contain expected entry %s",filename,zipEntryName(name)));
                entryname = entry.getName();
            } while (!entryname.equalsIgnoreCase(zipEntryName(name)));
            int recordno = 0;
            try {
                int[] heights;
                while (true) {
                    heights = readRecord();
                    int n = heights.length;
                    if (recordno == ytile) {
                        break;
                    }
                    recordno++;
                }
                for (int q = 0; q < heights.length; q++) {
                    if (heights[q] == missingValue()) {
                        double lat = Math.floor(place.lat()) + (1.0-frac(ytile));
                        double lon = Math.floor(place.lon()) + frac(q);
                        LatLong here = new LatLong(lat, lon);
                        double ht = subReader.getHeight(here);
                        int height = (int) Math.round(ht);
                        if (height == subReader.missing()) {
                            height = (int) MISSING;
                        }
                        heights[q] = height;
                    }
                }
                if (cacheEnable) {
                    if (cache.size() >= MAX_CACHE_SIZE) {
//Find the oldest entry and remove it
                        CacheEntry oldest = null;
                        long age = cycle;
                        for (CacheEntry test : cache.values()) {
                            if (test.lastUsed() < age) {
                                age = test.lastUsed();
                                oldest = test;
                            }
                        }
                        String key = oldest.getName();
                        cache.remove(key);
                    }
                    CacheEntry page = new CacheEntry(shortname, heights);
                    cache.put(shortname, page);
                    return page;
                }
                CacheEntry page = new CacheEntry(shortname, heights);
                return page;
            } catch (EOFException e) {
                throw new MissingDataFileException("Hit end of file");
            }
        } catch (IOException e) {
            throw new MissingDataFileException("Unable to read file - " + e.toString());
        }
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
    public String copyright() {
        return copyright;
    }
    private static final boolean downloadable = true;
    private static final int recordlength = 1201;
    private static final String filenameformat = "%1s%02d%1s%03d";
    private static final String legacyDatasetName = "Shuttle Radar Topography Mission plus ASTER";
    private static final String name = "Shuttle Radar Topography Mission plus ASTER V2";
    private static final String extn = ".hgt.zip";
    private static final boolean littleendian = false;
    private static final int missingValue = -32768;
    private static final String copyright = "ASTER GDEM is a product of METI and NASA";
}
