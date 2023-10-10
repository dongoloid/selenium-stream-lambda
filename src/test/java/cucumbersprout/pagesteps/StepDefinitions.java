package cucumbersprout.pagesteps;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;

public class StepDefinitions extends BaseTest {

    @Given("the page loads successfully")
    public void anExampleScenario() {
        Assertions.assertEquals("Awesome Controls overview", gridComp.CheckIfPageLoaded(), "Header is not equal");
    }

    @When("the user scrolls down to the table and looks for a row with ID {string}")
    public void allStepDefinitionsAreImplemented(String string) {
        gridComp.ScrollToRow(string);
    }

    @Then("the user validates each cell of the row")
    public void theScenarioPasses() {
        gridComp.PrintCellAndColumn("2011");
    }

}
