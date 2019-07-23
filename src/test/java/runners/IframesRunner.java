package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;


	
	@RunWith(Cucumber.class)
	@CucumberOptions(
			features = "src/test/resources/functionalTests/iframes.feature" ,
		    glue= {"stepDefinitions","com.webdriver.generichook"}
			)
	public class IframesRunner extends AbstractTestNGCucumberTests {

	

}
