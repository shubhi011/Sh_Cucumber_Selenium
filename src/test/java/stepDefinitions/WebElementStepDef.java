package stepDefinitions;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.webdriver.browser.CustomChromeDriver;
import com.webdriver.helper.ButtonHelper;
import com.webdriver.helper.DropDownHelper;
import com.webdriver.helper.TextBoxHelper;
import com.webdriver.services.DriverService;
import com.webdriver.util.IReader;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WebElementStepDef {

	private WebDriver driver;
	public WebElement element;
//	private TextBoxHelper textBoxHelper;
//	private ButtonHelper buttonHelper;
//	private DropDownHelper dropDownHelper;
	private DriverService service;
	private IReader readConfigFile;
	
	public WebElementStepDef(DriverService service)
	{
		this.service=service;
		this.driver=service.getDriver();
		this.readConfigFile=service.getReader();
	}

	@Given("^i open facebook home page \"([^\"]*)\"$")
	public void i_open_facebook_home_page(String url) throws Throwable {

		//CustomChromeDriver chromeDriver = new CustomChromeDriver();
	//	driver = chromeDriver.getChromeDriver();

//		textBoxHelper = TextBoxHelper.getInstance(driver);
//		buttonHelper = ButtonHelper.getInstance(driver);
//		dropDownHelper = DropDownHelper.getInstance(driver);
		//driver.manage().window().maximize();
		//driver.get(url);
		//IReader reader=new ReadConfigProperties("abc.properties");  //to provide user defined properties file
		driver.get(readConfigFile.getApplicationUrl());

	}

	@When("^i provide a unique location to findelemnet api$")
	public void i_provide_a_unique_location_to_findelemnet_api() throws Throwable {
		element = driver.findElement(By.id("email"));
	}

	@Then("^i should get that web element$")
	public void i_should_get_that_web_element() throws Throwable {
		System.out.println(element.toString());
	}

	@Then("^browser is closed$")
	public void browser_is_closed() throws Throwable {
		
			//driver.quit();
	}

	@Given("^user enters \"([^\"]*)\" in textbox$")
	public void user_enters_something_in_textbox(String text) throws Throwable {
		element = driver.findElement(By.id("email"));
		//textBoxHelper.setText(By.cssSelector("#email"), text);
		service.getTextBoxHelper().setText(By.cssSelector("#email"), text);
	}

	@When("^get text api is called it should return the text$")
	public void get_text_api_is_called_it_should_return_the_text() throws Throwable {
		//System.out.println(textBoxHelper.getText(By.cssSelector("#email")));
		System.out.println(service.getTextBoxHelper().getText(By.cssSelector("#email")));
	}

	@When("^clear api is called it should clear the text$")
	public void clear_api_is_called_it_should_clear_the_text() throws Throwable {
		service.getTextBoxHelper().clear(By.cssSelector("#email"));
	}

	@Given("^user performs click action on button$")
	public void user_performs_click_action_on_button() throws Throwable {
		service.getButtonHelper().click(By.cssSelector("[data-testid='royal_login_button']"));
		System.out.println("button clicked");
	}

	@Given("^user selects drop down value based on visible text$")
	public void user_selects_drop_down_value_based_on_visible_text() throws Throwable {
		service.getDropDownHelper().SelectByVisibleText(By.cssSelector(""), "6");
	}

	@Given("^user selects drop down value based on index$")
	public void user_selects_drop_down_value_based_on_index() throws Throwable {
		// throw new PendingException();
	}

	@Given("^user selects drop down value based on value attribute$")
	public void user_selects_drop_down_value_based_on_value_attribute() throws Throwable {
		// throw new PendingException();
	}

	@When("^getOptions is called it should list all values in dropdown$")
	public void getoptions_is_called_it_should_list_all_values_in_dropdown() throws Throwable {
		// throw new PendingException();
	}

}
