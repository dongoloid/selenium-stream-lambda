package cucumbersprout.pagesteps;

import cucumbersprout.pagesteps.BaseTest;
import cucumbersprout.webpage.GridComp;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;

public class StepDefinitions extends BaseTest {

    @Given("an example scenario")
    public void anExampleScenario() {
    }

    @When("all step definitions are implemented")
    public void allStepDefinitionsAreImplemented() {
    }

    @Then("the scenario passes")
    public void theScenarioPasses() {
        Assertions.assertEquals("Awesome Controls overview", gridComp.CheckIfPageLoaded(), "Header is not equal");
        gridComp.GetTableRowCells();
    }

}
