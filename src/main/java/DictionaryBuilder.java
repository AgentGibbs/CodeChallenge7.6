import java.util.ArrayList;
import java.io.*;

/**
 * Created by Christian Gibbs on 9/30/2016.
 */
public class DictionaryBuilder {

    private static String sep = File.separator;
   // private static String fileName = "src"+ sep + "main" + sep +"resources"+ sep + "dictionary.txt";
    private static String filePath = "src"+ sep + "main" + sep +"resources"+ sep + "dictionaries";
    public static void updateDictionary(String[] wordList)
    {

        for (String word:wordList
             ) {
            String letter = word.substring(0,1);
            String fileName = filePath+sep+letter+".txt";
            File dictFile = new File(fileName);
            try {
                FileWriter writer = new FileWriter(fileName, true);
                BufferedWriter textWriter = new BufferedWriter(writer);
                textWriter.write(word);
                textWriter.newLine();
                textWriter.close();
            }
            catch(IOException e)
            {
                System.out.println("File could not be opened: "+ fileName);
            }

        }
    }


    public static void sortDictionary(){
        ArrayList<String> boog = new ArrayList<String>();
    }

    public static void saveDictionary(){

    }

    //private static void

}
