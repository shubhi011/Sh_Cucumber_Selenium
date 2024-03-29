package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;


	
	@RunWith(Cucumber.class)
	@CucumberOptions(
			features = "src/test/resources/functionalTests/CucumberHooks.feature" ,
		    glue= {"stepDefinitions","com.webdriver.generichook"},
		    dryRun=false,
		    monochrome=true
			)
	public class CucumberHooksRunner extends AbstractTestNGCucumberTests {	

}
	//mvn test -Dcucumber.options=��tags @tag Name�   --run from command line