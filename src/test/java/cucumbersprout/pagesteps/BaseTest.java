package cucumbersprout.pagesteps;

import cucumbersprout.webpage.GridComp;
import cucumbersprout.webpage.LandingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    protected WebDriver driver;
    protected GridComp gridComp;
    protected LandingPage landingPage;

    protected void SetUp()
    {
        gridComp = new GridComp(driver);
        landingPage = new LandingPage(driver);
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
    }

}
