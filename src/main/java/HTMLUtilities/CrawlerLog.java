package HTMLUtilities;

import java.util.ArrayList;
import java.io.*;
/**
 * Created by Christian Gibbs on 9/30/2016.
 */
public class CrawlerLog {

    private static String DictionaryFile = "";
    private static String ExceptionLogFile;

    public static void AppendDictionary(ArrayList<String> wordList)
    {
        //todo write to dictionary file

    }

    public static void LogEvent(String event)
    {

    }

    public static void LogExceptionBasic(String message, Exception e)
    {
        //create timestamp
        //put everything in file
    }

    public static void LogExceptionDetails(String message, Exception e)
    {
        //create timestamp
        //get stacktrace
        //put everything in file
    }

}
