
import org.testng.*;
import org.testng.annotations.*;
import HTMLUtilities.HtmlTextScraper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Christian Gibbs on 9/27/2016.
 */
public class SkiUtahTests {

    @Test
    public void crawl()
    {

        try {
           // CrawlerProgram.crawlSite("http://wvcert.org/");
            CrawlerProgram.crawlSite("https://www.skiutah.com/");
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

}
