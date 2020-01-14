/*
 * LatLongDialog.java
 *
 * Created on 25 February 2008, 16:46
 */
package mccombe.terrain;

import java.awt.event.ActionEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;
import mccombe.mapping.*;

/**
 *
 * @author  Mike
 */
public class LatLongDialog extends javax.swing.JDialog {

    /** A return status code - returned if Cancel button has been pressed */
    public static final int RET_CANCEL = 0;
    /** A return status code - returned if OK button has been pressed */
    public static final int RET_OK = 1;

    /** Creates new form LatLongDialog */
    public LatLongDialog(java.awt.Frame parent, boolean modal, MappingToolkit toolbox, Spherical location) {
        super(parent, modal);
        initComponents();
        toolkit = toolbox;
        datum = Datum.WGS_1984;
        ellipsoid = Ellipsoid.GRS80;
        java.util.Vector<Datum> datumList = toolkit.getDatumList();
        datumSet.setModel(new DefaultComboBoxModel(datumList));
        datumSet.setSelectedItem(datum);
        java.util.Vector<Ellipsoid> ellipsoidList = toolkit.getEllipsoidList();
        ellipsoidSet.setModel(new DefaultComboBoxModel(ellipsoidList));
        ellipsoidSet.setSelectedItem(ellipsoid);
        latText.setInputVerifier(new LatVerifier());
        longText.setInputVerifier(new LonVerifier());
        datumSet.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datumSetActionPerformed(evt);
            }
        });
        ellipsoidSet.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ellipsoidSetActionPerformed(evt);
            }
        });
        ellipsoid = (Ellipsoid) ellipsoidSet.getSelectedItem();
        datum = (Datum) datumSet.getSelectedItem();
        Spherical sph = location;
        place = sph.getPosition();
        String[] lls = sph.toString().trim().split("\\s+");
        String initLat = String.format("%s %s %s %s", lls[0], lls[1], lls[2], lls[3]);
        String initLon = String.format("%s %s %s %s", lls[4], lls[5], lls[6], lls[7]);
        latText.setText(initLat);
        longText.setText(initLon);

    }

    private void datumSetActionPerformed(ActionEvent evt) {
        writeTextFields(place);
    }

    private void ellipsoidSetActionPerformed(ActionEvent evt) {
        writeTextFields(place);
    }

    /** @return the return status of this dialog - one of RET_OK or RET_CANCEL */
    public int getReturnStatus() {
        return returnStatus;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        longText = new javax.swing.JTextField();
        latText = new javax.swing.JTextField();
        ellipsoidSet = new javax.swing.JComboBox();
        datumSet = new javax.swing.JComboBox();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Latitude");

        jLabel2.setText("Longitude");

        jLabel3.setText("Ellipsoid");

        jLabel4.setText("Datum");

        longText.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(datumSet, javax.swing.GroupLayout.Alignment.TRAILING, 0, 246, Short.MAX_VALUE)
                            .addComponent(longText, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                            .addComponent(ellipsoidSet, javax.swing.GroupLayout.Alignment.TRAILING, 0, 246, Short.MAX_VALUE)
                            .addComponent(latText, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)))
                    .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelButton)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cancelButton, okButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(latText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(longText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ellipsoidSet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(datumSet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(okButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        if (parseTextFields()) {
            doClose(RET_OK);
        }
    }//GEN-LAST:event_okButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        doClose(RET_CANCEL);
    }//GEN-LAST:event_cancelButtonActionPerformed

    /** Closes the dialog */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        doClose(RET_CANCEL);
    }//GEN-LAST:event_closeDialog

    private void doClose(int retStatus) {
        returnStatus = retStatus;
        setVisible(false);
        dispose();
    }

    public Datum getDatum() {
        return (Datum) datumSet.getSelectedItem();
    }

    public void setDatum(Datum d) {
        datumSet.setSelectedItem(d);
        datum = d;
    }

    public Ellipsoid getEllipsoid() {
        return (Ellipsoid) ellipsoidSet.getSelectedItem();
    }

    public void setEllipsoid(Ellipsoid e) {
        ellipsoidSet.setSelectedItem(e);
        ellipsoid = e;
    }

    public Position getPosition() {
        return place;
    }

    public void setPosition(Position here) {
        writeTextFields(here);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                LatLongDialog dialog = new LatLongDialog(new javax.swing.JFrame(), true, new MappingToolkit(), new Spherical(new LatLong(0.0, 0.0), Ellipsoid.GRS80, Datum.WGS_1984));
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    private boolean parseTextFields() {
        String latval = latText.getText().trim();
        String lonval = longText.getText().trim();
        boolean res = parseLatitude(latval) && parseLongitude(lonval);
        if (!res) {
            return false;
        }
        LatLong ll = new LatLong(lat, lon);
        Spherical sph = new Spherical(ll, ellipsoid, datum);
        place = sph.getPosition();
        return true;
    }
    private void writeTextFields(Position p){
        place = p;
        ellipsoid = (Ellipsoid) ellipsoidSet.getSelectedItem();
        datum = (Datum) datumSet.getSelectedItem();
        Spherical sph = new Spherical(place, ellipsoid, datum);
        String[] lls = sph.toString().trim().split("\\s+");
        String initLat = String.format("%s %s %s %s", lls[0], lls[1], lls[2], lls[3]);
        String initLon = String.format("%s %s %s %s", lls[4], lls[5], lls[6], lls[7]);
        latText.setText(initLat);
        longText.setText(initLon);
    }

    private boolean parseLatitude(String val) {
        Matcher match1 = realRegex.matcher(val);
        Matcher match2 = latDMSRegex.matcher(val);
        if (match1.find()) {
            String res = match1.group(0);
            lat = Double.parseDouble(res);
            return true;
        } else if (match2.find()) {
            String degs = match2.group(1);
            String ns = match2.group(2);
            String mins = match2.group(3);
            String secs = match2.group(4);
            int deg = Integer.parseInt(degs);
            int min = Integer.parseInt(mins);
            double sec = Double.parseDouble(secs);
            try {
                lat = LatLong.latDMS(ns, deg, min, sec);
                return true;
            } catch (LatLongFormatException e) {
            }
        }
        return false;
    }

    private boolean parseLongitude(String val) {
        Matcher match1 = realRegex.matcher(val);
        Matcher match2 = lonDMSRegex.matcher(val);
        if (match1.find()) {
            lon = Double.parseDouble(val);
            return true;
        } else if (match2.find()) {
            String degs = match2.group(1);
            String ew = match2.group(2);
            String mins = match2.group(3);
            String secs = match2.group(4);
            int deg = Integer.parseInt(degs);
            int min = Integer.parseInt(mins);
            double sec = Double.parseDouble(secs);
            try {
                lon = LatLong.lonDMS(ew, deg, min, sec);
                return true;
            } catch (LatLongFormatException e) {
            }
        }
        return false;
    }

    private class LatVerifier extends InputVerifier {

        @Override
        public boolean verify(JComponent input) {
            JTextField field = (JTextField) input;
            String val = field.getText().trim();
            return parseLatitude(val);
        }
    }

    private class LonVerifier extends InputVerifier {

        @Override
        public boolean verify(JComponent input) {
            JTextField field = (JTextField) input;
            String val = field.getText().trim();
            return parseLongitude(val);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JComboBox datumSet;
    private javax.swing.JComboBox ellipsoidSet;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField latText;
    private javax.swing.JTextField longText;
    private javax.swing.JButton okButton;
    // End of variables declaration//GEN-END:variables
    private MappingToolkit toolkit;
    private Position place = null;
    private double lat,  lon;
    private int returnStatus = RET_CANCEL;
    private Ellipsoid ellipsoid;
    private Datum datum;
    private static final Pattern realRegex = Pattern.compile("^[\\-+]?\\d+(\\.\\d+)?$");
    private static final Pattern latDMSRegex = Pattern.compile("^(\\d{1,2})\\s*([NS])\\s+(\\d{1,2})\\'?\\s+(\\d{1,2}(\\.\\d+)?)\"?$");
    private static final Pattern lonDMSRegex = Pattern.compile("^(\\d{1,3})\\s*([EW])\\s+(\\d{1,2})\\'?\\s+(\\d{1,2}(\\.\\d+)?)\"?$");
}