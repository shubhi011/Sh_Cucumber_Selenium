package stepDefinitions;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.webdriver.browser.CustomChromeDriver;
import com.webdriver.helper.AlertHelper;
import com.webdriver.helper.ButtonHelper;
import com.webdriver.helper.WindowHelper;
import com.webdriver.services.DriverService;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AlertsStepDef {

	private WebDriver driver;
	// private CustomChromeDriver chromeDriver;
	// private ButtonHelper buttonHelper;
	private WebElement element;
	private ArrayList<String> windowId;
	// private WindowHelper windowHelper;
	// private AlertHelper alertHelper;
	private DriverService service;

	public AlertsStepDef(DriverService service) {
		this.service = service;
		this.driver = service.getDriver();
	}

	@Given("^Alerts_I navigate to the webpage \"([^\"]*)\"$")
	public void alertsi_navigate_to_the_webpage_something(String url) throws Throwable {
		// chromeDriver = new CustomChromeDriver();
		// driver = chromeDriver.getChromeDriver();
		// buttonHelper = buttonHelper.getInstance(driver);
		// windowHelper = windowHelper.getInstance(driver);
		// alertHelper = alertHelper.getInstance(driver);
		driver.get(url);
		// driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		// driver.manage().window().maximize();

	}

	@When("^i click on Try_It button it should show the alert$")
	public void i_click_on_tryit_button_it_should_show_the_alert() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tryhome")));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("iframeResult")));
		service.getButtonHelper().click(By.xpath("//button[text()='Try it']"));

	}

	@And("^i switch to alert and accept the alert$")
	public void i_switch_to_alert_and_accept_the_alert() throws Throwable {
		// WebDriverWait wait=new WebDriverWait(driver,60);
		// Alert alert=wait.until(ExpectedConditions.alertIsPresent());
		// //Alert alert= driver.switchTo().alert();
		// Thread.sleep(5000);
		// alert.accept();
		service.getAlertHelper().acceptAlert();
	}

	@Then("^i switch to default content$")
	public void i_switch_to_default_content() throws Throwable {
		driver.switchTo().defaultContent(); // no error if you remove this

	}

	@And("^i close the browser$")
	public void i_close_the_browser() throws Throwable {
		// if(driver!=null)
		// {
		// driver.close();
		// }
	}

	@When("^i navigate to the webpage \"([^\"]*)\"$")
	public void i_navigate_to_the_webpage_something(String strArg1) throws Throwable {
		driver.get(strArg1);
	}

	@And("^i provide string as \"([^\"]*)\"$")
	public void i_provide_string_as_something(String strArg1) throws Throwable {
		// WebDriverWait wait=new WebDriverWait(driver,60);
		// Alert alert=wait.until(ExpectedConditions.alertIsPresent());
		// alert.sendKeys(strArg1);
		// alertHelper.setAlertText(strArg1);
		// alertHelper.setAlertText(strArg1);
		service.getAlertHelper().setAlertText(strArg1);

	}

	@And("^i get the string of the prompt$")
	public void i_get_the_string_of_the_prompt() throws Throwable {
		// WebDriverWait wait=new WebDriverWait(driver,60);
		// Alert alert=wait.until(ExpectedConditions.alertIsPresent());
		// String text=alert.getText();
		// System.out.println(text);
		System.out.println(service.getAlertHelper().getAlertText());
	}

	@And("^i switch to the alert and cancel it$")
	public void i_switch_to_the_alert_and_cancel_it() throws Throwable {
		// WebDriverWait wait=new WebDriverWait(driver,60);
		// Alert alert=wait.until(ExpectedConditions.alertIsPresent());
		// //Alert alert= driver.switchTo().alert();
		// Thread.sleep(5000);
		// alert.dismiss();
		service.getAlertHelper().dismissAlert();
	}

	@Then("^i click on Tryit button again$")
	public void i_click_on_tryit_button_again() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tryhome")));
		// wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("iframeResult")));
		driver.switchTo().defaultContent();
		// buttonHelper.click(By.xpath("//button[text()='Try it']"));
		service.getButtonHelper().click(By.xpath("//button[text()='Try it']"));

	}

	// bootstrap pop up
	@Given("^i open to the webpage \"([^\"]*)\"$")
	public void i_open_to_the_webpage_something(String strArg1) throws Throwable {
		driver.get(strArg1);
	}

	@When("^i click on open model button$")
	public void i_click_on_open_model_button() throws Throwable {

		service.getButtonHelper().click(By.xpath("//button[@class='btn btn-success btn-lg']"));
		System.out.println("buton found");

	}

	@Then("^it should open the bootstrap popup$")
	public void it_should_open_the_bootstrap_popup() throws Throwable {
		// wait for pop up to appear
		WebDriverWait wait = new WebDriverWait(driver, 60);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Close']")));

	}

	@And("^i click on close button to close the pop up$")
	public void i_click_on_close_button_to_close_the_pop_up() throws Throwable {
		element.click();
	}

}
