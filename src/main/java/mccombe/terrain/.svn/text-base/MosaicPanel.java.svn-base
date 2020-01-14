/*
 * MosaicPanel.java
 *
 * Created on 21 January 2008, 10:40
 */
package mccombe.terrain;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import javax.swing.*;
import mccombe.mapping.XYZ;

/**
 * <P>MosaicPanel is used to display a coloured relief map and a height key (in
 * sensible units). It also handles mouse events, firing "mouse"
 * PropertyChangeEvents as the mouse is moved over the map. Handling of this
 * component's size etc. is left to the parent's LayoutManager.</P>
 *
 * <P>Mouse events contain a XYZ object where the x and y components indicate
 * the position of the mouse as a proportion of the width and height of the map.
 * These are double values between 0.0 and 1.0, with [0.0, 0.0] at the
 * bottom-left. The z() component contains the height (or MISSING) contained in
 * the databuffer. The value MOVED_OUT is fired when the mouse goes outside the
 * bounds of the map. </P>
 *
 * @author Mike McCombe
 */
public class MosaicPanel extends JPanel {

    private double stepSize;

    /**
     * Creates new form BeanForm
     */
    public MosaicPanel() {
        initComponents();
        stepSize = 0.0;
        scrollpane.setViewportView(mapCanvas);
    }

    /**
     * Set the height data for the map and determine the height scale for the
     * key
     *
     * @param buffer - a double[][] array containing the map data. First
     * dimension is "northing", second is "easting"
     */
    public void setDataTable(float[][] buffer) {
        dataTable = buffer;
        minval = 1.0E99;
        maxval = -1.0E99;
        for (float[] row : dataTable) {
            for (float x : row) {
                if (x != SRTM2Reader.MISSING) {
                    minval = Math.min(minval, x);
                    maxval = Math.max(maxval, x);
                }
            }
        }
        ydim = dataTable.length;
        xdim = dataTable[0].length;
        int digits = String.format("%d", (long) maxval).length();
        double topLimit = Math.pow(10.0, digits);
        if (topLimit / maxval > 5.2) {
            topLimit /= 5.0;
        } else if (topLimit / maxval > 2.0) {
            topLimit /= 2.0;
        }
        stepSize = topLimit / 10.0;
        mapCanvas.revalidate();
    }

    /**
     * Paint the key panel and background
     *
     * @param g - the Graphics object from awt
     */
    @Override
    public void paint(java.awt.Graphics g) {
        super.paint(g);
        if (stepSize == 0) {
            return;
        }
        Font font = g.getFont().deriveFont(Font.PLAIN, 11.0f);
        g.setFont(font);
        Rectangle r = keyPanel.getBounds();
        int dy = r.height / 15;
        int xgap = 5;
        double xbase = r.x + r.width / 2.0;
        FontMetrics f = g.getFontMetrics();
        g.setColor(Color.BLACK);
        for (int i = 0; i < colours.length; i++) {
            String val = String.format("%d", (int) (i * stepSize));
            Rectangle2D siz = f.getStringBounds(val, g);
            int x = (int) (xbase - siz.getWidth());
            int y = (int) ((colours.length - i) * dy + siz.getHeight());
            g.drawString(val, x, y);
            g.setColor(colours[i]);
            g.fillRect((int) (xbase + xgap), (int) (y + siz.getCenterY()), r.width / 4, dy);
            g.setColor(Color.BLACK);
            g.drawRect((int) (xbase + xgap), (int) (y + siz.getCenterY()), r.width / 4, dy);
        }
    }

    /**
     * Translate altitude into the requisite map colour
     *
     * @param altitude - in metres
     * @return the corresponding Color
     */
    private Color selectColour(float altitude) {
        if (altitude == 0.0) {
            return colours[0];
        }
        if (altitude == SRTM2Reader.MISSING) {
            return Color.BLACK;
        }
        double range = maxval - minval;
        double above = altitude - minval;
        int i = 1 + (int) (altitude / stepSize);
        return colours[i];
    }

    /**
     * Add a PropertyChangeListener (for the "mouse" property changes)
     *
     * @param l
     */
    @Override
    public void addPropertyChangeListener(PropertyChangeListener l) {
        pcs.addPropertyChangeListener(l);
    }

    /**
     * Get this object's internal PropertyChangeListener (note: slightly
     * non-standard)
     *
     * @return the current PropertyChangeListener
     */
    public PropertyChangeListener getPropertyChangeListener() {
        return listener;
    }

    private class MapCanvas extends JLabel implements Scrollable {

        public MapCanvas() {
            super();
            setAutoscrolls(true);
            addMouseMotionListener(new MouseMotionListener() {

                public void mouseDragged(MouseEvent e) {
                    Rectangle r = new Rectangle(e.getX(), e.getY(), 1, 1);
                    scrollRectToVisible(r);
                    Point p = e.getPoint();
                    convertPoint(p);
                }

                public void mouseMoved(MouseEvent e) {
                    Point p = e.getPoint();
                    convertPoint(p);
                }
            });
            addMouseListener(new MouseListener() {

                @Override
                public void mouseClicked(MouseEvent e) {
                }

                @Override
                public void mousePressed(MouseEvent e) {
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    double v = SRTM2Reader.MISSING;
                    XYZ val = new XYZ(v, v, v);
                    pcs.firePropertyChange("mouse", oldPoint, val);
                    oldPoint = val;
                }
            });
        }

        public Dimension getPreferredSize() {
            JViewport v = scrollpane.getViewport();
            Rectangle r = v.getViewRect();
            float xscale = (float) r.width / xdim;
            float yscale = (float) r.height / ydim;
            float scale = Math.min(xscale, yscale);
            pixPerCell = Math.max((int) scale, 1);
            //           pixPerCell = 1;
            w = xdim * pixPerCell;
            h = ydim * pixPerCell;
            return new Dimension(w, h);
        }

        private void convertPoint(Point p) {
            if (w == 0 || h == 0) {
                return;
            }
            double dx = (p.getX()) / (double) w;
            double dy = 1.0 - (p.getY()) / (double) h;
            if (dx < 0.0 || dx >= 1.0 || dy <= 0.0 || dy >= 1.0) {
                //If the mouse moves outside the edge of the map, fire a "mouse" event containing MISSING
                //to tell other components. Used to erase the GridRef display in the parent frame.
                double v = SRTM2Reader.MISSING;
                XYZ val = new XYZ(v, v, v);
                pcs.firePropertyChange("mouse", oldPoint, val);
                oldPoint = val;
                return;
            }
            int ix = ((int) p.getX()) / pixPerCell;
            int iy = ydim - 1 - ((int) p.getY()) / pixPerCell;
            double z = dataTable[iy][ix];
            XYZ val = new XYZ(dx, dy, z);
            pcs.firePropertyChange("mouse", oldPoint, val);
            oldPoint = val;
        }

        @Override
        public void paint(Graphics g) {
            JViewport v = scrollpane.getViewport();
            Rectangle r = v.getViewRect();
            float xscale = (float) r.width / xdim;
            float yscale = (float) r.height / ydim;
            float scale = Math.min(xscale, yscale);
            pixPerCell = Math.max((int) scale, 1);
            w = xdim * pixPerCell;
            h = ydim * pixPerCell;
            //           x0 = r.x + (int) ((float) r.width / 2.0 - (float) (w) / 2.0);
            //           y0 = r.y + (int) ((float) r.height / 2.0 - (float) (h) / 2.0);
            x0 = (int) ((float) r.width / 2.0 - (float) (w) / 2.0);
            y0 = (int) ((float) r.height / 2.0 - (float) (h) / 2.0);
            for (int j = 0; j < ydim; j++) {
                for (int i = 0; i < xdim; i++) {
                    float z = dataTable[j][i];
                    int xpos = i * pixPerCell;
                    int ypos = (ydim - 1 - j) * pixPerCell;
                    Color c = selectColour(z);
                    g.setColor(c);
                    g.fillRect(xpos, ypos, pixPerCell, pixPerCell);
                }
            }
        }

        public Rectangle getMapRectangle() {
            return new Rectangle(w, h);
        }
        private int x0 = 0;
        private int y0 = 0;
        private int w = 0;
        private int h = 0;
        private XYZ oldPoint = new XYZ(0.0, 0.0, 0.0);
        private int pixPerCell = 0;

        @Override
        public Dimension getPreferredScrollableViewportSize() {
            return getPreferredSize();
        }

        @Override
        public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) {
            return maxUnitIncrement;
        }

        @Override
        public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction) {
            if (orientation == SwingConstants.HORIZONTAL) {
                return visibleRect.width - maxUnitIncrement;
            } else {
                return visibleRect.height - maxUnitIncrement;
            }
        }

        @Override
        public boolean getScrollableTracksViewportWidth() {
            return false;
        }

        @Override
        public boolean getScrollableTracksViewportHeight() {
            return false;
        }
        private int maxUnitIncrement = 20;
    }

 
    /**
     * Private class built on a JPanel to hold the map and handle mouse events
     */
    private class MapPanel extends JPanel {

        public MapPanel() {
            super();
            addMouseMotionListener(new MouseMotionListener() {

                public void mouseDragged(MouseEvent e) {
                    Point p = e.getPoint();
                    convertPoint(p);
                }

                public void mouseMoved(MouseEvent e) {
                    Point p = e.getPoint();
                    convertPoint(p);
                }
            });
        }

        private void convertPoint(Point p) {
            if (w == 0 || h == 0) {
                return;
            }
            double dx = (p.getX() - (double) x0) / (double) w;
            double dy = 1.0 - (p.getY() - (double) y0) / (double) h;
            if (dx < 0.0 || dx >= 1.0 || dy <= 0.0 || dy >= 1.0) {
                //If the mouse moves outside the edge of the map, fire a "mouse" event containing MISSING
                //to tell other components. Used to erase the GridRef display in the parent frame.
                double v = SRTM2Reader.MISSING;
                XYZ val = new XYZ(v, v, v);
                pcs.firePropertyChange("mouse", oldPoint, val);
                oldPoint = val;
                return;
            }
            int ix = ((int) p.getX() - x0) / pixPerCell;
            int iy = ydim - 1 - ((int) p.getY() - y0) / pixPerCell;
            double z = dataTable[iy][ix];
            XYZ val = new XYZ(dx, dy, z);
            pcs.firePropertyChange("mouse", oldPoint, val);
            oldPoint = val;
        }

        @Override
        public void paint(Graphics g) {
            JViewport v = scrollpane.getViewport();
            Rectangle r = v.getViewRect();
            float xscale = (float) r.width / xdim;
            float yscale = (float) r.height / ydim;
            float scale = Math.min(xscale, yscale);
            pixPerCell = Math.max((int) scale, 1);
            //           int pixPerCell = 10;
            w = xdim * pixPerCell;
            h = ydim * pixPerCell;
            x0 = r.x + (int) ((float) r.width / 2.0 - (float) (w) / 2.0);
            y0 = r.y + (int) ((float) r.height / 2.0 - (float) (h) / 2.0);
            for (int j = 0; j < ydim; j++) {
                for (int i = 0; i < xdim; i++) {
                    float z = dataTable[j][i];
                    int xpos = x0 + i * pixPerCell;
                    int ypos = y0 + (ydim - 1 - j) * pixPerCell;
                    Color c = selectColour(z);
                    g.setColor(c);
                    g.fillRect(xpos, ypos, pixPerCell, pixPerCell);
                }
            }
        }
        private int x0 = 0;
        private int y0 = 0;
        private int w = 0;
        private int h = 0;
        private XYZ oldPoint = new XYZ(0.0, 0.0, 0.0);
        private int pixPerCell = 0;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        keyPanel = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        scrollpane = new javax.swing.JScrollPane();

        javax.swing.GroupLayout keyPanelLayout = new javax.swing.GroupLayout(keyPanel);
        keyPanel.setLayout(keyPanelLayout);
        keyPanelLayout.setHorizontalGroup(
            keyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 125, Short.MAX_VALUE)
        );
        keyPanelLayout.setVerticalGroup(
            keyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 354, Short.MAX_VALUE)
        );

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(keyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(404, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(155, 155, 155)
                    .addComponent(scrollpane, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(keyPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollpane, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                    .addContainerGap()))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel keyPanel;
    private javax.swing.JScrollPane scrollpane;
    // End of variables declaration//GEN-END:variables
    private static final Color PALE_BLUE = new Color(150, 150, 255);
    private static final Color MID_GREEN = new Color(149, 255, 52);
    private static final Color PALE_GREEN = new Color(200, 255, 150);
    private static final Color PALE_YELLOW = new Color(255, 255, 102);
    private static final Color PALE_ORANGE = new Color(255, 200, 50);
    private static final Color MID_ORANGE = new Color(255, 153, 0);
    private static final Color PALE_RED = new Color(255, 203, 203);
    private static final Color MID_RED = new Color(255, 153, 153);
    private static final Color MID_PURPLE = new Color(153, 102, 255);
    private static final Color PALE_PURPLE = new Color(204, 153, 255);
    private static final Color[] colours = {PALE_BLUE, MID_GREEN, PALE_GREEN, PALE_YELLOW, PALE_ORANGE,
        MID_ORANGE, PALE_RED, MID_RED, MID_PURPLE, PALE_PURPLE, Color.WHITE
    };
    private float[][] dataTable = null;
    private double minval = 1.0E99;
    private double maxval = -1.0E99;
    private int xdim = 0;
    private int ydim = 0;
    private MapPanel mapPanel = new MapPanel();
    private MapCanvas mapCanvas = new MapCanvas();
    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    private PropertyChangeListener listener = new java.beans.PropertyChangeListener() {

        public void propertyChange(java.beans.PropertyChangeEvent evt) {
            String propertyName = evt.getPropertyName();
            String propertyValue = evt.getNewValue().toString();
            //Property change handling goes here, if needed.
        }
    };
    public static final XYZ MOVED_OUT = new XYZ(SRTM2Reader.MISSING, SRTM2Reader.MISSING, SRTM2Reader.MISSING);
}
