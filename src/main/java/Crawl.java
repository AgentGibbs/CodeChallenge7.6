import HTMLUtilities.HtmlTextScraper;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.List;

/**
 * Created by Christian Gibbs on 9/29/2016.
 */
public class Crawl {

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

        } catch (Exception e) {

        }

        //Create a scraper
        HtmlTextScraper scraper = new HtmlTextScraper(doc);
        //Scrape the text
        String[] pageText = scraper.scrapePageText();
        //Write the text to a file
        //Get the Links
        //Add them to this list

    }



}
