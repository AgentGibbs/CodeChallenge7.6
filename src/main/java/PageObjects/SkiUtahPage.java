package PageObjects;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

import java.util.List;

/**
 * Created by Christian Gibbs on 9/27/2016.
 */
public class SkiUtahPage {

    @FindAll(
            @FindBy(how = How.TAG_NAME, using = "a")
    )
    List<WebElement> pageLinks;

    public SkiUtahPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void Crawl(){
        for (WebElement link:pageLinks
             ) {//TODO start crawl method here

        }//end foreach
    }//end method

}
