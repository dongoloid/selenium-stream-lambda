package cucumbersprout.pagesteps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;

public class StepDefinitions extends BaseTest {

    @Before
    public void setUp(){
        SetUp();
    }

    @After
    public void tearDown(){
        TearDown();
    }

    @Given("the page loads successfully")
    public void anExampleScenario() {
        Assertions.assertEquals("Awesome Controls overview", landingPage.CheckIfPageLoaded(), "Header is not equal");
    }

    @And("the user scrolls to the {string} component")
    public void ScrollToComponent(String component){
        gridComp.ScrollToComponent(component);
    }

    @When("the user looks for a row with ID {string}")
    public void allStepDefinitionsAreImplemented(String id) {
        gridComp.ScrollToRow(id);
    }

    @Then("the user should be able to validate the row values of ID {string}")
    public void theScenarioPasses(String id) {
        gridComp.PrintCellAndColumn(id);
    }

}
