package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.webdriver.services.DriverService;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DataDrivenUsingCucumberStepDef {
	
	private WebDriver driver;
	private DriverService service;
	
	public DataDrivenUsingCucumberStepDef(DriverService service)
	{
		this.service=service;
		this.driver=service.getDriver();
		
	}
	
	 @Given("^user is on Login page \"([^\"]*)\"$")
	    public void user_is_on_login_page_something(String url) throws Throwable {
	        
	    }


	@When("^User enters Credentials to LogIn$")
	public void user_enters_Credentials_to_LogIn(DataTable table) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)   
		
		  List<Map<String,String>> lst=  table.asMaps(String.class, String.class);   //using asMaps for multiple data rows and asMap
		  for(int i=0;i<lst.size();i++)
		  {			  
			 String uname= lst.get(i).get("username");
			 String pswrd=  lst.get(i).get("password");
			 System.out.println(uname +"," +pswrd);
			  
		  }
		  
		 /*  Map<String,String>map=table.asMap(String.class, String.class);  using asMap for single data row
		   for(String s:map.keySet())
		   {
			   System.out.println(map.get(s));
		   }*/
		  	    
	}

	@Then("^Message displayed Login Successfully$")
	public void message_displayed_Login_Successfully() throws Throwable {
	    
	}

}
