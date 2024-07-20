package cucumbersprout.pagesteps;

import cucumbersprout.webpage.components.GridComponent;
import cucumbersprout.webpage.LandingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected GridComponent gridComp;
    protected LandingPage landingPage;

    protected void SetUp()
    {
        gridComp = new GridComponent(driver, wait);
        landingPage = new LandingPage(driver, wait);
    }

    protected void TearDown()
    {
        driver.close();
        driver.quit();
    }

    public BaseTest() {
        StartUpBrowser();
    }

    private void StartUpBrowser()
    {
        driver = new ChromeDriver();
        driver.get("https://demo.aspnetawesome.com/");
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

}
