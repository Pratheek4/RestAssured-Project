package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class) // we are telling that we are running with cucumber junit runner
@CucumberOptions
(
features="src/test/java/features",plugin="json:target/jsonReports/cucumber-report.json",glue={"stepDefination"}
)

                         
public class TestRunner {
	
}
