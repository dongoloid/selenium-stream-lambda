package cucumbersprout.webpage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    protected BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    /**
     * Looks for locator otherwise throws generic exception.
     */
    protected  WebElement WaitUntilLocated(int secs, By by, String message) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(secs));

        try{
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        }
        catch(Exception e)
        {
            throw new Exception("Waited for " +secs + "but " + message + "not found.");
        }
    }

    /**
     * Looks for element otherwise throws generic exception.
     */
    protected WebElement WaitUntilVisible(int secs, WebElement element, String message) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(secs));

        try{
            return wait.until(ExpectedConditions.visibilityOf(element));
        }
        catch(Exception e)
        {
            throw new Exception("Waited for " +secs + "but " + message + "not found.");
        }
    }

    /**
     * Looks for an element then scrolls to it until it's visible on the screen.
     */
    protected WebElement MoveToElement(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();

        return element;
    }

    /**
     * Looks for an element then scrolls to it until it's visible on the screen.
     */
    protected WebElement ScrollIntoView(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({ behavior: \"instant\", block: \"end\" });", element);

        return element;
    }
}
