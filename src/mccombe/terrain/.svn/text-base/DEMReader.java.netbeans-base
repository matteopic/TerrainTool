package mccombe.terrain;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import mccombe.mapping.*;
import java.io.*;
import java.util.zip.*;
import javax.swing.JComponent;
import javax.net.ssl.HttpsURLConnection;

/**
 *
 * @author Mike
 */
public abstract class DEMReader extends PropertyChangeSupport {

    protected DEMReader(JComponent item) throws MissingDataFileException {
        super(item);
        PropertyChangeListener[] listeners = item.getPropertyChangeListeners();
        for (PropertyChangeListener ear : listeners) {
            addPropertyChangeListener(ear);
        }
        addPropertyChangeListener(listener);
        item.addPropertyChangeListener(listener);
        String slash = System.getProperty("file.separator");
        DIRECTORY = TerrainFrame.paths.dataPath();
        File dir = new File(DIRECTORY);
        if (!dir.isDirectory()) {
            boolean madeDirectory = dir.mkdir();
            if (!madeDirectory) {
                throw new MissingDataFileException(String.format("Failed to create data directory %s%n", DIRECTORY));
            }
        }
        try {
            File readMeTxt = new File(DIRECTORY + "ReadMe.txt");
            if (!readMeTxt.isFile()) {
                PrintWriter readMe = new PrintWriter(new FileWriter(readMeTxt));
                readMe.printf(
                        "This directory contains copies of raw compressed data files downloaded from NASA. TerrainTool will re-use the files it needs%n" +
                        "instead of downloading them again, saving a lot of time. However, you can save disk space by manually deleting any files you%n" +
                        "no longer need.%n%n" +
                        "Data is read in zipped form. DO NOT DECOMPRESS THESE FILES.");

                readMe.close();
            }

        } catch (IOException ex) {
            //Do nothing if there's an error writing the ReadMe file
        }
    }

    protected String makename(String ns, double lat, String ew, double lon) {
        return String.format(formatstring(), ns, (int) lat, ew, (int) lon);
    }

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
            CacheEntry page = getRow(pagename, k);
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

    protected CacheEntry getRow(String name, int ytile) throws MissingDataFileException {
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
                }
            }
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

    public int[] readRecord() throws EOFException, IOException {
        byte[] buffer = new byte[recordlength() * 2];
        int[] outbuffer = new int[recordlength()];
        int sofar = 0;
        //Keep reading until we have the whole record
        while (sofar < recordlength() * 2) {
            int res = in.read(buffer, sofar, recordlength() * 2 - sofar);
            if (res == -1) {
                throw new EOFException();
            }
            sofar += res;
        }
        for (int i = 0; i < recordlength(); i++) {
            short temp;
            if (littleendian()) {
                temp = (short) (buffer[2 * i + 1] << 8 | (0xff & buffer[2 * i]));
            } else {
                temp = (short) (buffer[2 * i] << 8 | (0xff & buffer[2 * i + 1]));
            }
            outbuffer[i] = temp;
        }
        return outbuffer;
    }

    public double tile(double x) {
        double q = Math.floor(x);
        double r = (recordlength() - 1) * (x - q);
        return r;
    }

    public double frac(int tile) {
        double x = (double) tile / (double) (recordlength() - 1);
        return x;
    }

    protected void downloadFile(String filename) throws java.security.KeyManagementException, java.security.NoSuchAlgorithmException, IOException, MissingDataFileException {
        if (!download || !downloadable()) {

            String msg = String.format("Needs data file %s - DEM not downloadable or auto-download is disabled", filename);
            throw new MissingDataFileException(msg);
        }
        String urlString = getProperty(TerrainProperties.FTP) + getProperty(TerrainProperties.REGION) + "/" + filename;
        java.net.URL url = new java.net.URL(urlString);
        setMessage(String.format("Downloading data: %s", filename));
        HttpsURLConnection con = (HttpsURLConnection)url.openConnection();
        InputStream ins = con.getInputStream();
//        java.io.DataInputStream instream = new java.io.DataInputStream(ins);
        String outfilename = DIRECTORY + filename;
        File outfile = new java.io.File(outfilename);
        DataOutputStream outstream = new DataOutputStream(new FileOutputStream(outfile));
        long available = ins.available();
        int bytecount = 0;
        long sofar = 0;
        long guess = 900000;
        while (bytecount != -1) {
            byte[] buffer = new byte[BUFFERLENGTH];
            bytecount = ins.read(buffer);
            if (bytecount > 0) {
                String str = new String(buffer);
                outstream.write(buffer, 0, bytecount);
                sofar += bytecount;
                int progress = (int) (100 * sofar / guess);
                setProgress(progress);
                setMessage(String.format("Downloading data: %s", filename));
            }
        }
        outstream.close();
        ins.close();
        setMessage("");
        return;
    }
    protected class CacheEntry {

        public CacheEntry(String name, int[] buffer) {
            page_name = name;
            last_used = cycle;
            data = buffer;
        }

        public void setLastUsed() {
            last_used = cycle;
        }

        public String getName() {
            return page_name;
        }

        public int getValue(int i) {
            return data[i];
        }

        public long lastUsed() {
            return last_used;
        }
        private long last_used;
        private String page_name;
        private int[] data;
    }

    public static double lagrangian(double x, java.awt.geom.Point2D.Double... points) {
        int n = points.length;
        double tot = 0.0;
        for (int i = 0; i < n; i++) {
            double prod = 1.0;
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    prod *= (x - points[j].getX()) / (points[i].getX() - points[j].getX());
                }
            }
            tot += prod * points[i].getY();
        }
        return tot;
    }

    public long hits() {
        return hits;
    }

    public long resultcount() {
        return resultcount;
    }

    public long tries() {
        return tries;
    }

    public long missing() {
        return missing;
    }

    public void resetCounts() {
        hits = 0;
        tries = 0;
        missing = 0;
        resultcount = 0;
    }

    private void setMessage(String msg) {
        if (!msg.equals(lastMessage)) {
            firePropertyChange("message", lastMessage, msg);
        }
        lastMessage = msg;
    }

    private void setProgress(int val) {
        int v = Math.min(100, val);
        v = Math.max(0, v);
        if (lastValue != v) {
            firePropertyChange("progress", lastValue, v);
        }
        lastValue = v;
    }

    private String getProperty(TerrainProperties propertyName) {
        return TerrainFrame.properties.get(propertyName);
    }

    public void setDownload(boolean flag) {
        download = flag;
    }

    public PropertyChangeListener[] getPropertyChangeListeners() {
        PropertyChangeListener[] res = new PropertyChangeListener[1];
        res[0] = listener;
        return res;
    }
    private PropertyChangeListener listener = new java.beans.PropertyChangeListener() {

        public void propertyChange(java.beans.PropertyChangeEvent evt) {
            String propertyName = evt.getPropertyName();
            String propertyValue = evt.getNewValue().toString();
            if (propertyName.equalsIgnoreCase("download")) {
                download = propertyValue.equalsIgnoreCase("true");
            }
            if (propertyName.equalsIgnoreCase("message")) {
                lastMessage = propertyValue;
            }
        }
    };
    public void setLegacy(boolean t) {
        useLegacy = t ;
    }
    public abstract String datasetName();

    public abstract boolean downloadable();

    public abstract int recordlength();

    public abstract String formatstring();

    public abstract String extn();

    public abstract boolean littleendian();

    public abstract int missingValue();
    public abstract String copyright();

    public abstract String zipEntryName(String name);
    protected static java.util.zip.ZipInputStream in;
    protected  String DIRECTORY = "";
//    private static final int DEMSettings.recordlength() = 1201;
    protected long cycle = 0;
    protected java.util.HashMap<String, CacheEntry> cache = new java.util.HashMap<String, CacheEntry>();
    protected boolean cacheEnable = true;
    protected static final int MAX_CACHE_SIZE = 16;
    protected long hits = 0;
    protected long tries = 0;
    protected long missing = 0;
    protected long resultcount = 0;
    public static final double MISSING = -32768.0;
    protected static final int BUFFERLENGTH = 1024;  
    protected String lastMessage = "";
    protected boolean download = true;
    protected int lastValue = 0;
    protected static final java.util.Locale LOCALE = java.util.Locale.UK; //Force use of UK locale for number formatting
    protected boolean useLegacy = false ;
//    protected DEMProfile DEMSettings = DEMProfile.SRTM;
}
