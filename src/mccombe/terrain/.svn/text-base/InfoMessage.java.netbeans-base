package mccombe.terrain;


import mccombe.util.Severity;
import javax.swing.JOptionPane;

/**
 *
 * @author Mike
 */
public class InfoMessage {
    public InfoMessage(String title, Object[] msg, Severity status){
        message = msg ;
        level = status ;
        heading = title ;
    }
    public InfoMessage(String title, String msg, Severity status){
        
        message = new String[1] ;
        message[0] = msg ;
        level = status ;
        heading = title ;
    }
    public void display(java.awt.Component parent){
        JOptionPane.showMessageDialog(parent, message, heading, mapType(level));
    }
    public Severity getSeverity() { return level ; }
    private int mapType(Severity s){
        int i = s.value();
        return msgTypes[i];
    }
    private static final int[] msgTypes = {
        JOptionPane.INFORMATION_MESSAGE,
        JOptionPane.WARNING_MESSAGE,
        JOptionPane.ERROR_MESSAGE,
        JOptionPane.ERROR_MESSAGE,
        JOptionPane.ERROR_MESSAGE};
    private Object[] message ;
    private Severity level ;
    private String heading ;

}
