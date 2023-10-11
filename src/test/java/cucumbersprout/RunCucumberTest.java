package cucumbersprout;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("cucumbersprout")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME,
        value="junit:target/cucumber-reports/Cucumber.xml," +
                "json:target/cucumber-reports/Cucumber.json,"+
                "html:target/cucumber-reports/Cucumber.html,"+
                "timeline:target/cucumber-reports/CucumberTimeline")
public class RunCucumberTest {
}
