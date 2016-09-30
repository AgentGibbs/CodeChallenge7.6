import java.text.DateFormat;
import java.util.ArrayList;
import java.io.*;
import java.util.Date;

/**
 * Created by Christian Gibbs on 9/30/2016.
 */
public class CrawlerLog {

    private static String DictionaryFile = "";
    private static String ExceptionLogFile;
    private static String LogFile;

    private static String getTimeStamp()
    {
        return new Date().toString();
    }

    public static void LogEvent(String event)
    {

    }

    public static void LogExceptionBasic(String message, Exception e)
    {
        //create timestamp
        String now = getTimeStamp();

        //put everything in file
    }

    public static void LogExceptionDetails(String message, Exception e)
    {
        //create timestamp
        //get stacktrace
        //put everything in file
    }

}
