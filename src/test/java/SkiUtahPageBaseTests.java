import PageObjects.SkiUtahPage;

import Selenium.PageLauncher;
import WebDriverUtilities.WebDriverHelper;
import org.testng.*;
import org.testng.annotations.*;
import org.testng.asserts.*;
import org.testng.log4testng.*;

/**
 * Created by Christian Gibbs on 9/27/2016.
 */
public class SkiUtahPageBaseTests {

    public SkiUtahPage page;
    public WebDriverHelper helper;

@BeforeTest
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

}
