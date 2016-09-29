package PageObjects;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import java.util.List;

/**
 * Created on 9/27/2016.
 */
public class SkiUtahPage {

    public List<String>linkHrefs;
    @FindAll(
            @FindBy(how = How.TAG_NAME, using = "a")
    )
    List<WebElement> pageLinks;

    public WebDriver driver;

    public SkiUtahPage(WebDriver driverIn) {
        driver = driverIn;
        PageFactory.initElements(driver, this);
    }

    public void Crawl(){
        for (WebElement link:pageLinks
             ) {

        }//end foreach
    }//end method

    public boolean GoToPage(String url, String verificationString)
    {
        if(driver.getCurrentUrl().equalsIgnoreCase(url)==false)
        {
            driver.get(url);
        } //Endif

        return driver.getTitle().toLowerCase().contains(verificationString.toLowerCase());
    }
}