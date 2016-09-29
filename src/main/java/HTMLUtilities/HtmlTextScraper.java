package HTMLUtilities;

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

import java.util.*;


public class HtmlTextScraper {

    public Document doc;
    private Connection ct;
    private ArrayList<String> pageLinks;
    public HtmlTextScraper(Document docToScrape) {
        System.out.println("Building Scraper");
        doc = docToScrape;
    }


    public String[] scrapePageText() {
        String[] values = new String[1];
        if (doc != null) {
            values = doc.body().text().replaceAll("\\p{P}", "").toUpperCase().split("\\s+");
            populatePageLinks();
        }
        return values;
    }



    public ArrayList<String> getPageLinks() {

        return pageLinks;
    }

    private void populatePageLinks()
    {
        Elements anchorTags = doc.select("a");
        if(pageLinks==null)
        {pageLinks = new ArrayList<String>();}
        for (Element link : anchorTags
                ) {
            String href = link.attr("href");
            if (pageLinks.contains(href)==false) {
                pageLinks.add(href);
            }

        }
        System.out.println(anchorTags.size());

    }




}
