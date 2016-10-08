/*
 * Creation : 23 Nov 2015
 */
package main.java.com.boot.excpetion;

public class BootBaseException extends Exception {

    /**
     * Serial version UID
     */
    private static final long serialVersionUID = 2391469380481004925L;

    /**
     * Constructor with exception
     * 
     * @param e exception
     */
    public BootBaseException(Exception e) {
        super(e);
    }

    /**
     * Default constructor
     */
    public BootBaseException() {
        super();
    }

    /**
     * Constructor with msg
     * 
     * @param msg the error message
     */
    public BootBaseException(String msg) {
        super(msg);
    }

    /**
     * Constructor with msg
     * 
     * @param msg the error message
     * @param thr exception
     */
    public BootBaseException(String msg, Throwable thr) {
        super(msg, thr);
    }
}