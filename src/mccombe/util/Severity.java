/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mccombe.util;

/**
 *
 * @author Mike
 */
public enum Severity  {
    SUCCESS(0),
    WARNING(1),
    ERROR(2),
    SERIOUS(3),
    FATAL(4) ;
    Severity(int value){
        val = value ;
    }
    public int value() { return val ; };
    private int val ;
}
