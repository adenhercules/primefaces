/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Unir
 */
public class UtilException extends Exception {

    /**
     * Creates a new instance of <code>UtilException</code> without detail
     * message.
     */
    public UtilException() {
    }

    /**
     * Constructs an instance of <code>UtilException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public UtilException(String msg) {
        super(msg);
    }
}
