package cucumbersprout.webpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage extends BasePage{
    public LandingPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    private final By header = By.cssSelector("div.conthead > h1.fgrow");


    //TODO: introduce wait
    public String CheckIfPageLoaded(){
        return driver.findElement(header).getText();
    }
}
