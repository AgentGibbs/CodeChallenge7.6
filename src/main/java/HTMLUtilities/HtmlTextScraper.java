package HTMLUtilities;

import org.jsoup.nodes.*;
import org.jsoup.select.Elements;
import java.util.*;

public class HtmlTextScraper {

    public Document doc;
    private ArrayList<String> pageLinks;

    public HtmlTextScraper(Document docToScrape) {
        System.out.println("Scraping page");
        doc = docToScrape;
    }


    public String[] scrapePageTextOld() {
        String[] values = new String[1];
        if (doc != null) {
            values = doc.body().text().replaceAll("\\p{P}", "").toUpperCase().split("\\s+");
        }
        return values;
    }


    public String[] scrapePageText() {

        String[] wordList = new String[1];
        if (doc != null) {
            wordList = doc.body().text().replaceAll("\\p{P}", "").toUpperCase().split("\\s+");
        }
        return wordList;
    }


    public ArrayList<String> getPageLinks() {
        populatePageLinks();
        return pageLinks;
    }

    private void populatePageLinks() {
        Elements anchorTags = doc.select("a");
        if (pageLinks == null) {
            pageLinks = new ArrayList<String>();
        }
        for (Element link : anchorTags
                ) {
            String href = link.attr("href");
            if (pageLinks.contains(href) == false) {
                pageLinks.add(href);
            }
        }
    }
}