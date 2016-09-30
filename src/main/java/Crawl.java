import HTMLUtilities.HtmlTextScraper;
import org.jsoup.Connection;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.List;

/**
 * Created by Christian Gibbs on 9/29/2016.
 */
public class Crawl implements Callable{

    private String url;
    private Connection ct;
    private Document doc;
    public Crawl(String initialUrl){
        url=initialUrl;
    }

    public List<String> call() throws Exception{
        try {
            ct = Jsoup.connect(url).timeout(5000).userAgent("Chrome");
            doc = ct.get();
        }
        catch (HttpStatusException e1) {
            System.err.println("Invalid response code on the following page:" + e1.getUrl());

            if (logging) WriteToFile.writeOutput(error404LogFile, "\n" + url);
        }
        catch (SocketTimeoutException e2) {
            System.err.println("SocketTimeoutException caught, error: " + e2.getLocalizedMessage());
            if (logging) WriteToFile.writeOutput(timeOutLogFile, "\n" + url);
        }
        catch (Exception e3) {
            System.err.println("Error: " + e3.getMessage());
            e3.printStackTrace();
        }

        //Create a scraper
        HtmlTextScraper scraper = new HtmlTextScraper(doc);
        //Scrape the text
        String[] pageText = scraper.scrapePageText();

        //Write the text to a file
        //TODO write class to save info in file
        //Get the Links
        return scraper.getPageLinks();

    }



}
