/*
 * Creation : 23 Nov 2015
 */
package main.java.com.boot.excpetion;

public class BootServiceException extends BootBaseException implements IBootDetailedException {

    /**
     * Serial version UID
     */
    private static final long serialVersionUID = -316427639512848051L;

    /**
     * error code
     */
    private final String errCode;

    /** The arguments. */
    private final Object[] arguments;

    /**
     * Default constructor
     */
    public BootServiceException() {
        super();
        errCode = null;
        arguments = null;
    }

    /**
     * Constructor with message
     * 
     * @param msg the message of the error
     */
    public BootServiceException(String msg) {
        super(msg);
        errCode = null;
        arguments = null;
    }

    /**
     * Constructor with other exception
     * 
     * @param e exception
     */
    public BootServiceException(Exception e) {
        super(e);
        if (e instanceof IBootDetailedException) {
            errCode = ((IBootDetailedException) e).getErrCode();
            arguments = ((IBootDetailedException) e).getArguments();
        } else {
            errCode = null;
            arguments = null;
        }
    }

    /**
     * Constructor with message
     * 
     * @param errCode error code
     * @param msg the message of the error
     */
    public BootServiceException(String errCode, String msg) {
        super(msg);
        this.errCode = errCode;
        arguments = null;
    }

    /**
     * Constructor with message and arguments.
     * 
     * @param errCode error code
     * @param msg the message of the error
     * @param arguments the arguments
     */
    public BootServiceException(String errCode, String msg, Object... arguments) {
        super(msg);
        this.errCode = errCode;
        this.arguments = arguments;
    }

    /**
     * Constructor with message and arguments.
     * 
     * @param msg the message of the error
     * @param e the exception
     * @param errCode error code
     * @param arguments the arguments
     */
    public BootServiceException(String msg, Exception e, String errCode, Object... arguments) {
        super(msg, e);
        this.errCode = errCode;
        this.arguments = arguments;
    }

    /**
     * Return the code.
     * 
     * @return the code
     */
    public String getErrCode() {
        return errCode;
    }

    /**
     * get arguments
     * 
     * @return the arguments
     */
    public Object[] getArguments() {
        return arguments;
    }
}