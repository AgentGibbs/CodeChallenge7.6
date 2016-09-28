package HTMLUtilities;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import org.jsoup.*;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebElement;
//import org.jsoup.select
//import com.gargoylesoftware.htmlunit.javascript.host.Element;

public class HtmlTextScraper {

    public Document doc;
    private Connection ct;

    public HtmlTextScraper() {
        System.out.println("Building Scraper");
    }

    public HtmlTextScraper(Document Doc) {
        System.out.println("Building Scraper(Document)");

        doc=Doc;
    }

    public HtmlTextScraper(String htmlSource) {
        System.out.println("Building Scraper(String htmlSource)");
        // TODO Auto-generated constructor stub
        doc = Jsoup.parse(htmlSource);
    }

    public Document getDoc() {
        return doc;
    }

    public void setDoc(Document doc) {
        this.doc = doc;
    }

    public Connection getConnection() {
        return ct;
    }

    public void setConnection(Connection ct) {
        this.ct = ct;
    }

    public String getDocText()
    {
        if (doc != null) {
            return doc.text();
        }
        else
        {return "No html Document was found.";}

    }

    public String getDocBodyText()
    {
        if (doc != null) {
            return doc.body().text();
        }
        else
        {return "No html Document was found.";}
    }


    public int connectToUrl(String url) {
        int value = 0;
        try {
            ct = Jsoup.connect(url);
            System.out.println("connecting to " + url);
            Response resp = ct.response();
            System.out.println("Getting Response code: ");
            value = resp.statusCode();
            System.out.println(value);
            doc = ct.userAgent("chrome").get();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println(ct.response().statusCode() + " error:");
            System.out.println(url + " could not be read.");
            e.printStackTrace();
        }
        return value;
    }

    public ArrayList<String> scrapeLinks(Document doc1, String URL)
    {	doc = doc1;
        String domain = URL.toLowerCase().replaceFirst("http://www.", "");
        String linkTag = "[href*="+ domain + "]";
        System.out.println(linkTag);
        Elements links = doc.select(linkTag);
        ArrayList<String> linkStrings = new ArrayList<String>();
        for (Element element :links) {
            String relHref = element.attr("href");
            System.out.println("Found " + relHref);
            linkStrings.add(relHref);
        }
        return linkStrings;
    }

    public ArrayList<String> scrapeLinks(String domain)
    {
        String linkTag = "[href* = "+ domain + "]";
        Elements links = doc.select(linkTag);
        ArrayList<String> linkStrings = new ArrayList<String>();
        for (Element element :links) {
            String relHref = element.attr("href");
            System.out.println("Found " + relHref);
            linkStrings.add(relHref);
        }

        return linkStrings;
    }


    /**
     * Splits a string into an array. Splits on spaces between the words.
     * Punctuation marks such as commas, periods, colons, etc. will
     * automatically be removed from the resulting array.
     *
     * @param allText
     *            The text you wish to split into an array
     * @param textCase
     *            String value representing whether or not the resulting array
     *            is converted to a certain case. Valid values are "upper,"
     *            "lower," or "default." Default maintains the original case of
     *            the word.
     * @return A String array containing all words in the web page, with
     *         punctuation removed.
     */
    public String[] toArray(String allText, String textCase) {

        String[] values;
        values = allText.replaceAll("\\p{P}", "").split("\\s+");
        /*switch (textCase.toLowerCase()) {
            case "ucase":
            case "uppercase":
            case "upper":
                values = allText.replaceAll("\\p{P}", "").toUpperCase().split("\\s+");
                break;
            case "lcase":
            case "lowercase":
            case "lower":
                values = allText.replaceAll("\\p{P}", "").toLowerCase().split("\\s+");
                break;
            default:
                values = allText.replaceAll("\\p{P}", "").split("\\s+");
        }*/
        return values;
    }

}
