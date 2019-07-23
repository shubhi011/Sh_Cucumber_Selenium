package stepDefinitions;

import cucumber.api.java.en.Given;

public class ScenarioOutlineStepDef {
	
	@Given("^user is on login page$")
	public void user_is_on_login_page() throws Throwable {
	    
	}

	@Given("^enters username \"([^\"]*)\"$")
	public void enters_username(String username) throws Throwable {
	  System.out.println(username);
	}

	@Given("^password \"([^\"]*)\"$")
	public void password(String password) throws Throwable {
		System.out.println(password);
	}



}
