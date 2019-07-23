package stepDefinitions;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.webdriver.browser.CustomChromeDriver;
import com.webdriver.helper.ButtonHelper;
import com.webdriver.helper.WindowHelper;
import com.webdriver.services.DriverService;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class IframesStepDef {

	private WebDriver driver;
//	private CustomChromeDriver chromeDriver;
//	private ButtonHelper buttonHelper;
	private WebElement element;
	private ArrayList<String>windowId;
	//private WindowHelper windowHelper;
	private DriverService service;
	
	public IframesStepDef(DriverService service)
	{
		this.service=service;
		this.driver=service.getDriver();
	}

	@Given("^I navigate to the webpage \"([^\"]*)\"$")
	public void i_navigate_to_the_webpage(String url) throws Throwable {
//		chromeDriver = new CustomChromeDriver();
//		driver = chromeDriver.getChromeDriver();
//		buttonHelper = buttonHelper.getInstance(driver);
//		windowHelper=windowHelper.getInstance(driver);
		driver.get(url);
//		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
//		driver.manage().window().maximize();

	}

	@When("^i click on element present in iframe then it should be successful$")
	public void i_click_on_element_present_in_iframe_then_it_should_be_successful() throws Throwable {
		driver.switchTo().frame("iframeResult");
		element = driver.findElement(By.cssSelector("[src='https://www.w3schools.com']"));
		driver.switchTo().frame(element);
		service.getButtonHelper().click(By.cssSelector("[title='Search W3Schools']"));
		
		driver.switchTo().defaultContent(); //switch to parent dom
		System.out.println("switched to default content");
		driver.switchTo().parentFrame();
		System.out.println("switched to parent frame");
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("iframeResult")));
		//this can be used for switching to both parent & child frames
		
//		As per the specifications, driver.switchTo().parentFrame(); invokes the following:
//
//			Switch To Parent Frame
//
//			Where, the Switch to Parent Frame command sets the current browsing context for future commands to the parent of the current browsing context.
//
//			As per the Java Docs parentFrame() method changes the focus to the parent context. If the current context is the top level browsing context, the context remains unchanged.
//
//			driver.switchTo().defaultContent();
//			As per the Java Docs, defaultContent() method selects either the first frame on the page, or the main document when a page contains iframes
	}
	
	
	@Given("^i open the web page \"([^\"]*)\"$")
    public void i_open_the_web_page_something(String strArg1) throws Throwable {
		driver.get(strArg1);
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"main\"]/div[4]/a")));
		
    }

    @When("^i click on a button it will open child window$")
    public void i_click_on_a_button_it_will_open_child_window() throws Throwable {
    	service.getButtonHelper().click(By.xpath("//*[@id=\"main\"]/div[4]/a"));
    	windowId=new ArrayList<String>(driver.getWindowHandles());
    	WebDriverWait wait=new WebDriverWait(driver, 60);
    	//wait.until(ExpectedConditions.numberOfWindowsToBe(1));
    	//driver.switchTo().window(windowId.get(1));
    	service.getWindowHelper().switchToWindow(1);
        
    }

    @Then("^click on home button$")
    public void click_on_home_button() throws Throwable {
    	service.getButtonHelper().click(By.xpath("//a[@id='tryhome']"));
    }
    @And("^close the browser$")
    public void close_the_browser() throws Throwable {
    // driver.quit();
    }
	
	
	
}
