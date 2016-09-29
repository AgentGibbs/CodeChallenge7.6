package HTMLUtilities;

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

import java.util.*;


public class HtmlTextScraper {

    public Document doc;
    private Connection ct;

    public HtmlTextScraper() {
        System.out.println("Building Scraper");
    }


    public String[] scrapePageText(String url) {
        String[] values = new String[1];
        try {
            ct = Jsoup.connect(url);
            System.out.println("connecting to " + url);
            doc = ct.get();
            findPageLinks();

        } catch (Exception e) {
            System.out.println(ct.response().statusCode() + " error:");
            System.out.println(url + " could not be read.");
            System.out.println("Error " + e.getMessage());
            //e.printStackTrace();
        }
        if (doc != null) {
            values = doc.body().text().replaceAll("\\p{P}", "").toUpperCase().split("\\s+");
        }
        return values;
    }

    public ArrayList<String> pageLinks;

    public ArrayList<String> getPageLinks() {
        return pageLinks;
    }

    private void findPageLinks() {


        Elements anchorTags = doc.select("a");
        for (Element link : anchorTags
                ) {
            String href = link.attr("href");
            if (!pageLinks.contains(href)) {
                pageLinks.add(href);
            }

        }

    }

}
