package za.co.kw.exception;

/**
 * Created by kristien on 2017/05/21.
 */
public class StartingPositionException extends Exception
{

    public StartingPositionException(String format)
    {
        super();
    }

    public StartingPositionException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
