package main.java.com.boot.excpetion;

/**
 * Created by hao huang on 29/06/2016.
 */
public interface IBootDetailedException {
    /**
     * Return the code.
     *
     * @return the code
     */
    String getErrCode();

    /**
     * get arguments
     *
     * @return the arguments
     */
    Object[] getArguments();
}
