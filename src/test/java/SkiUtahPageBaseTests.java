
import org.testng.*;
import org.testng.annotations.*;
import HTMLUtilities.HtmlTextScraper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Christian Gibbs on 9/27/2016.
 */
public class SkiUtahPageBaseTests {


/*@BeforeTest



@Test
    public void VerifyTitle()
{
Assert.assertTrue(page.GoToPage("https://www.skiutah.com/", "Ski Utah - ski utah"));

}

HtmlTextScraper scraper;
@BeforeSuite
public void initialize()
{
    scraper = new HtmlTextScraper();}
    ArrayList<String> results;
    @Test
    public void VerifyNavigation()
    {

        String[]result = scraper.scrapePageText("https://www.skiutah.com/");
        results = scraper.getPageLinks();
       Assert.assertTrue(result.length >0);
    }
    @Test
    public void VerifyLinks()
    {

        Assert.assertTrue(results.size()>0);
    }
*/

    @Test
    public void crawl()
    {
        List<String> hrefs = new ArrayList<String>();

        try {
            CrawlerProgram.crawlSite("http://wvcert.org/");
           // CrawlerProgram.crawlSite("https://www.skiutah.com/");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        Assert.assertTrue(hrefs.size()==0);

    }

}
