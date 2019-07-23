package com.webdriver.services;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;

import com.webdriver.browser.BrowserConfiguration;
import com.webdriver.browser.CustomChromeDriver;
import com.webdriver.helper.AlertHelper;
import com.webdriver.helper.ButtonHelper;
import com.webdriver.helper.DropDownHelper;
import com.webdriver.helper.GenericHelper;
import com.webdriver.helper.TextBoxHelper;
import com.webdriver.helper.WindowHelper;
import com.webdriver.util.IReader;
import com.webdriver.util.ReadConfigProperties;

public class DriverService {
	
	//Getter Setter to return the instance of each driver
	private WebDriver driver;
	private BrowserConfiguration browserConfiguration ;
	
	
	public GenericHelper getGenericHelper() {
		return genericHelper;
	}

	public BrowserConfiguration getBrowserConfiguration() {
		return browserConfiguration;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public CustomChromeDriver getChromeDriver() {
		return chromeDriver;
	}

	public ButtonHelper getButtonHelper() {
		return buttonHelper;
	}

	public WindowHelper getWindowHelper() {
		return windowHelper;
	}

	public AlertHelper getAlertHelper() {
		return alertHelper;
	}
	
	public TextBoxHelper getTextBoxHelper() {
		return textBoxHelper;
	}
	public DropDownHelper getDropDownHelper() {
		return dropDownHelper;
	}

	private CustomChromeDriver chromeDriver;
	private ButtonHelper buttonHelper;
	private WindowHelper windowHelper;
	private AlertHelper alertHelper;
	private TextBoxHelper textBoxHelper;
	private DropDownHelper dropDownHelper;
	private GenericHelper genericHelper;
	private IReader reader;
	
	
	public IReader getReader() {
		return reader;
	}

	public void launchBrowser()
	{
		reader=new ReadConfigProperties();
		driver=getBrowserDriver();
		//creates instance of each driver
		//chromeDriver = new CustomChromeDriver();
		//driver = chromeDriver.getChromeDriver();
		//browserHelper
		buttonHelper = buttonHelper.getInstance(driver);
		windowHelper = windowHelper.getInstance(driver);
		alertHelper = alertHelper.getInstance(driver);
		textBoxHelper = textBoxHelper.getInstance(driver);
		dropDownHelper = dropDownHelper.getInstance(driver);
		genericHelper = genericHelper.getInstance(driver);
		
		driver.manage().timeouts().pageLoadTimeout(reader.getExplicitWait(), TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	 
	
	private WebDriver getBrowserDriver() {
		
		//System.out.println("abc"+reader.getBrowserType());
		switch (reader.getBrowserType()) {
		    case BrowserType.CHROME:                //BrowserType -interface in selenium
			 /*CustomChromeDriver chromeDriver=new CustomChromeDriver();
			 return chromeDriver.getChromeDriver();
			           OR */
			browserConfiguration=new CustomChromeDriver();
			return browserConfiguration.getBrowserDriver();
			
		case BrowserType.FIREFOX:                
//			 CustomChromeDriver chromeDriver=new CustomChromeDriver();
//			 return chromeDriver.getChromeDriver();
		

		default:
     		throw new RuntimeException("Invalid Browser type:" +reader.getBrowserType());
			
		}
	}
	

	public DriverService()
	{
		launchBrowser();	
	}

}
