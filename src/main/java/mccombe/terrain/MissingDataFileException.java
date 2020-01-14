/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mccombe.terrain;

/**
 *
 * @author Mike
 */
public class MissingDataFileException extends Exception {

    /**
     * Creates a new instance of <code>MissingDataFileException</code> without detail message.
     */
    public MissingDataFileException() {
    }


    /**
     * Constructs an instance of <code>MissingDataFileException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public MissingDataFileException(String msg) {
        super(msg);
    }
}
