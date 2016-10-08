package main.java.com.boot.excpetion;

/**
 * Created by hao huang on 29/06/2016.
 */
public class BootDaoException extends BootBaseException{
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3135455332240331528L;

    /**
     * Default constructor.
     */
    public BootDaoException() {
        super();
    }

    /**
     * Constructor with message.
     *
     * @param msg the message of the error
     */
    public BootDaoException(String msg) {
        super(msg);
    }

    /**
     * Constructor with other exception.
     *
     * @param e exception
     */
    public BootDaoException(Exception e) {
        super(e);
    }

}
