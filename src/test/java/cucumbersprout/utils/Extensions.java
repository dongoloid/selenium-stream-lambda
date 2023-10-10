package cucumbersprout.utils;
import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;
import org.openqa.selenium.WebElement;

@Extension
public class Extensions {

    @Extension
    public static void ScrollIntoView(@This WebElement webElement){
        System.console().printf("testo");
    }
}
