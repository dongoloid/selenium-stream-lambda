package extensions.org.openqa.selenium.WebElement;
import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

@Extension
public class Extensions {

    public static WebDriver driver;

    @Extension
    public static WebElement ScrollIntoView(@This WebElement webElement){
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement);
        actions.perform();

        return webElement;
    }
}
