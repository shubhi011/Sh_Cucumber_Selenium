package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;


	
	@RunWith(Cucumber.class)
	@CucumberOptions(
			features = "src/test/resources/functionalTests/DataDrivenUsingCucumber.feature" ,
		    glue= {"stepDefinitions","com.webdriver.generichook"},
		    dryRun=false,
		    monochrome=true,
		    plugin= {"pretty","html:target/HTMLReports"}
			)
	public class DataDrivenUsingCucumberRunner extends AbstractTestNGCucumberTests {

	

}
	//mvn test -Dcucumber.options=”–tags @tag Name”   --run from command line