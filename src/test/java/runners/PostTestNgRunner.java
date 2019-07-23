package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/functionalTests" ,
	    glue= {"stepDefinitions"}
		)
public class PostTestNgRunner extends AbstractTestNGCucumberTests {

}
