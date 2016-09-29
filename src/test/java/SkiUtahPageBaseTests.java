import PageObjects.SkiUtahPage;

import Selenium.PageLauncher;
import WebDriverUtilities.WebDriverHelper;
import org.testng.*;
import org.testng.annotations.*;
import HTMLUtilities.HtmlTextScraper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Christian Gibbs on 9/27/2016.
 */
public class SkiUtahPageBaseTests {

    public SkiUtahPage page;
    public WebDriverHelper helper;

/*@BeforeTest
    public void SetUpLauncher()
{
    PageLauncher launchpad = new PageLauncher();
    launchpad.CountDown();
    page = launchpad.Launch();
    helper = launchpad.Booster();

}

@Test
public void crawl()
{
    page.Crawl();
}

@Test
    public void VerifyTitle()
{
Assert.assertTrue(page.GoToPage("https://www.skiutah.com/", "Ski Utah - ski utah"));

}
*/
    @Test
    public void VerifyNavigation()
    {
        HtmlTextScraper scraper = new HtmlTextScraper();
        String[]result = scraper.scrapePageText("https://www.skiutah.com/");
        Assert.assertTrue(result.length >1);

    }
    @Test
    public void VerifyLinks()
    {
        HtmlTextScraper scraper = new HtmlTextScraper();
        ArrayList<String> results = scraper.getPageLinks();
        for (String word:results
                ) {
            System.out.println(word);
        }
        Assert.assertTrue(results.size()>0);
    }


}
