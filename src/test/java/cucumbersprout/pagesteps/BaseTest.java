package cucumbersprout.pagesteps;

import cucumbersprout.webpage.GridComp;
import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    protected WebDriver driver;
    protected GridComp gridComp;

    @Before
    private void SetUp()
    {
        StartUpBrowser();
        gridComp = new GridComp(driver);
    }

    @AfterAll
    private void TearDown()
    {
        driver.close();
        driver.quit();
    }
    public BaseTest() {
        StartUpBrowser();
        gridComp = new GridComp(driver);
    }

    private void StartUpBrowser()
    {
        driver = new ChromeDriver();
        driver.get("https://demo.aspnetawesome.com/");
        driver.manage().window().maximize();
    }

}
