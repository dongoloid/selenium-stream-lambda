package cucumbersprout.webpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BasePage {
    protected WebDriver driver;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected WebElement ScrollIntoView(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();

        return element;
    }
}
