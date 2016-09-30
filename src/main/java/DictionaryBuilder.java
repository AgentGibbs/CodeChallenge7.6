
import java.util.ArrayList;
import java.io.*;
import java.util.Collections;

/**
 * Created by Christian Gibbs on 9/30/2016.
 */
public class DictionaryBuilder {

    private static String sep = File.separator;
    // private static String fileName = "src"+ sep + "main" + sep +"resources"+ sep + "dictionary.txt";
    private static String filePath = "src" + sep + "main" + sep + "resources" + sep + "dictionaries";

    public static void updateDictionary(String[] wordList) {
        String fileName = filePath + sep + "dictionary.txt";
        try {
            FileWriter writer = new FileWriter(fileName, true);
            BufferedWriter textWriter = new BufferedWriter(writer);
            for (String word : wordList
                    ) {

                try {
                    textWriter.write(word);
                    textWriter.newLine();

                } catch (IOException e) {
                    System.out.println("unable to write to " + fileName);
                }//end nesetd trycatch

            }//end foreach
            textWriter.close();

        } catch (IOException e2) {
            System.out.println("Dictionary File could not be opened: " + fileName);
        }//end outer try catch
    }

    public static void updateDictionary2(String[] wordList) {

            for (String word : wordList
                    ) {
                String letter = word.substring(0, 1);
                String fileName = filePath + sep + letter + ".txt";
                File dictFile = new File(fileName);
                try {
                    FileWriter writer = new FileWriter(fileName, true);
                    BufferedWriter textWriter = new BufferedWriter(writer);
                    textWriter.write(word);
                    textWriter.newLine();
                    textWriter.close();
                } catch (IOException e) {
                    System.out.println("File could not be opened: " + fileName);
                }

            }
        }


    public static void sortDictionary() {

    }

    public static void saveDictionary() {

    }

    //private static void

    private static void buildDictionary() {
    }

    private static void sortFileNames() {
        File folder = new File(filePath);
        File[] arrayOfFiles = folder.listFiles();
        ArrayList<String> fileNamesList = new ArrayList<String>();
        for (File file : arrayOfFiles) {
            if (file.isFile()) {
                fileNamesList.add(file.getName());
            }
        }
        Collections.sort(fileNamesList);

    }
/*
    private static void readFile(String subFileName)
    {
        ArrayList<String> lines = new ArrayList<String>();

        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {

            stream.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }*/
}