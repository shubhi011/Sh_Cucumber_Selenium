package runners;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/functionalTests/WebElementFunction.feature" ,
	    glue= {"stepDefinitions"},
		dryRun=false,
		monochrome=true
		)
public class WebDriverWaitRunner extends AbstractTestNGCucumberTests {
}