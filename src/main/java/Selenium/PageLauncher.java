package Selenium;

import PageObjects.SkiUtahPage;
import org.openqa.selenium.*;
import org.openqa.selenium.browserlaunchers.locators.GoogleChromeLocator.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import WebDriverUtilities.*;


import java.util.concurrent.TimeUnit;

/**
 * Created by Christian Gibbs on 9/27/2016.
 */
public class PageLauncher {
    public WebDriver driver;

    public PageLauncher() {

    }


    public void CountDown()
    {
         driver = new ChromeDriver(ChromeDriverService.createDefaultService(), new ChromeOptions());
        driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);

    }

    public SkiUtahPage Launch()
    {
        driver.get("https://www.skiutah.com/");
        return new SkiUtahPage(driver);

    //TODO return a new page
    }

    public WebDriverHelper Booster()
    {
        return new WebDriverHelper(driver);
    }

}
