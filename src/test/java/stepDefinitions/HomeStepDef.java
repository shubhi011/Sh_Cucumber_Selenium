package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.webdriver.page.HomePageClass;
import com.webdriver.services.DriverService;
import com.webdriver.util.IReader;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class HomeStepDef {
	
	private WebDriver driver;
	public WebElement element;
	private DriverService service;
	private IReader readConfigFile;
	private HomePageClass homePageClass;
	
	public HomeStepDef(DriverService service)
	{
		this.service=service;
		this.driver=service.getDriver();
		this.readConfigFile=service.getReader();
	}
	
	
	
	@Given("^i open the facebook home page$")
    public void i_open_the_facebook_home_page() throws Throwable {
		driver.get(readConfigFile.getApplicationUrl());
    }

    @Then("^i am landed on login page$")
    public void i_am_landed_on_login_page() throws Throwable {
    	homePageClass=new HomePageClass(driver);
    	homePageClass.verifyTitle();
       
    }

    @And("^enter email and password$")
    public void enter_email_and_password() throws Throwable {
    	homePageClass=new HomePageClass(driver);
    	homePageClass.enterEmail(readConfigFile.getUserName());
    	homePageClass.enterPassword(readConfigFile.getPassword());
        
    }

    @And("^click on login button$")
    public void click_on_login_button() throws Throwable {
    	homePageClass.clickLogin();
    }

	

}
