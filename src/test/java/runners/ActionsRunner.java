package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;


	
	@RunWith(Cucumber.class)
	@CucumberOptions(
			features = "src/test/resources/functionalTests/Actions.feature" ,
		    glue= {"stepDefinitions"},
		    dryRun=false,
		    monochrome=true,
		    tags= {"@smokeTest , @regression"}
			)
	public class ActionsRunner extends AbstractTestNGCucumberTests  {	

}
	//mvn test -Dcucumber.options=”–tags @tag Name”   --run from command line
	//