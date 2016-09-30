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
public class Crawl implements Callable {

    private String url;
    private Connection ct;
    private Document doc;


    public Crawl(String initialUrl) {
        url = initialUrl;
    }

    public List<String> call() throws Exception {
        ArrayList<String> returnValues = new ArrayList<String>();

        try {
            ct = Jsoup.connect(url).timeout(5000).userAgent("Chrome");
            doc = ct.get();
            //Create a scraper
            HtmlTextScraper scraper = new HtmlTextScraper(doc);
            //Scrape the text
            String[] pageText = scraper.scrapePageText();

            //Write the text to a file
            DictionaryBuilder.updateDictionary(pageText);
            //Get the Links
            returnValues = scraper.getPageLinks();
        } catch (HttpStatusException hse) {

            String error = "Invalid response code on the following page:" + hse.getUrl();
            CrawlerLog.logException(error, hse);
        } catch (SocketTimeoutException ste) {
            String error = "SocketTimeoutException caught on " + url;
            CrawlerLog.logException(error, ste);
        } catch (Exception e) {
            String error = "Undefined Exception caught on " + url;
            CrawlerLog.logException(error, e);
        }


        return returnValues;
    }


}
