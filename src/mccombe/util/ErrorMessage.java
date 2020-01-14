/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mccombe.util;

/**
 *
 * @author Mike
 */
/**
 *
 * @author Mike
 */
public class ErrorMessage {
    
    /** Creates a new instance of ErrorMessage */
    public ErrorMessage() {
        this("",Severity.ERROR);
    }
    public ErrorMessage(String error){
        this(error,Severity.ERROR);
    }
    public ErrorMessage(String errorText, Severity level){
        seriousness = level ;
        text = errorText;
    }
    public String errorText() { return text ; };
    public Severity severityLevel() { return seriousness ; };
    public String toString() { return severityLevel() + " - " + errorText();};
    private String text = "" ;
    private Severity seriousness = Severity.ERROR ;
}
