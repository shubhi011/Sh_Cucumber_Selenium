package stepDefinitions;

import java.io.File;

import org.apache.commons.io.FileSystemUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.webdriver.browser.CustomChromeDriver;
import com.webdriver.helper.AlertHelper;
import com.webdriver.helper.ButtonHelper;
import com.webdriver.helper.WindowHelper;
import com.webdriver.services.DriverService;
import com.webdriver.util.IReader;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ActionsStepDef {

	private WebDriver driver;
	/*private CustomChromeDriver chromeDriver;
	private ButtonHelper buttonHelper;
	private WebElement element;
	private ArrayList<String> windowId;
	private WindowHelper windowHelper;
	private AlertHelper alertHelper;*/
	private Actions actions;
	private Action action;
	private DriverService service;
	private IReader readConfigFile;
	
	public ActionsStepDef(DriverService service)
	{
		this.service=service;
		this.driver=service.getDriver();
		this.readConfigFile=service.getReader();
	}
	
	@Given("^i open the webpage \"([^\"]*)\"$")
    public void i_open_the_webpage_something(String url) throws Throwable {
//		chromeDriver = new CustomChromeDriver();
//		driver = chromeDriver.getChromeDriver();
//		buttonHelper = buttonHelper.getInstance(driver);
//		driver.get(url);
//		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
		driver.get(url);
		//driver.get(readConfigFile.getApplicationUrl());
    }

	@When("^i create the composite action for context click$")
	public void i_create_the_composite_action_for_context_click() throws Throwable {
	  //Create composite action
		actions=new Actions(driver);
	    actions=actions.contextClick(driver.findElement(By.id("droptarget")));  //Right Click
	}

	@When("^i build the action$")
	public void i_build_the_action() throws Throwable {
	   //build the action by using build method
		action=actions.build();//Action is an interface
	}

	@Then("^i perform the action$")
	public void i_perform_the_action() throws Throwable {
	    //Perform the action by calling perform method
		action.perform();
		Thread.sleep(5000);
	}
	 @When("^i create the composite action for drag & drop$")
	    public void i_create_the_composite_action_for_drag_drop() throws Throwable {
	        actions=new Actions(driver);
	        WebElement source=driver.findElement(By.id("draggable"));
	        WebElement target=driver.findElement(By.id("droptarget"));	        		
	        actions.dragAndDrop(source, target);
	    }

	 @When("^i create the composite action for click and hold$")
	    public void i_create_the_composite_action_for_click_and_hold() throws Throwable {
	        actions=new Actions(driver);
	        WebElement source=driver.findElement(By.id("draggable"));
	        actions.clickAndHold(source);
	        
	    }

	 @When("^i create the composite action for keyboard$")
	    public void i_create_the_composite_action_for_keyboard() throws Throwable {		 
		 WebElement element=driver.findElement(By.id("example-search"));
		 actions=new Actions(driver);
		 actions=actions.keyDown(element,Keys.LEFT_SHIFT)//simulate the pressing of left shift key
				 .sendKeys(element, "Selenium")          //enter text
				 .keyUp(element,Keys.LEFT_SHIFT); //simulate the release of left shift key		 
	    }
	 
	 @Then("^i take the screenshot$")
	 public void i_take_the_screenshot() throws Throwable {
//		File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); //this will create temp file
//		FileUtils.copyFile(screenshot, new File("src.png"));   //C:\Users\312234\AppData\Local\Temp
		service.getGenericHelper().takeScreenShot("Screenshots", "abc.png");
	 }
	
}
