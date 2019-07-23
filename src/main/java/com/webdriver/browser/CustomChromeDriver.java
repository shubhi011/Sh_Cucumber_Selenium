package com.webdriver.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.webdriver.util.ResourceUtils;

public class CustomChromeDriver implements BrowserConfiguration{	
	
	private void setDriverExecutable() {
		//System.setProperty("webdriver.chrome.driver","C:/Users/312234/Downloads/chromedriver.exe");		
	String chromePath=ResourceUtils.getResourcePath("chromedriver.exe");
	System.setProperty("webdriver.chrome.driver",chromePath);
	}
	
	private ChromeOptions getChromeOptions()
	{
		ChromeOptions options=new ChromeOptions();
	     options.setAcceptInsecureCerts(true); //to ignore insecure certificate warning
	    // options.setHeadless(true);
	     return options;
	}
	
	//this method gives object of chrome driver
	 public WebDriver getChromeDriver()
	 {
		 setDriverExecutable();
		 ChromeOptions options=getChromeOptions();
		 ChromeDriver driver=new ChromeDriver(options);
		 return driver;
	 }

	@Override
	public WebDriver getBrowserDriver() {	
		return getChromeDriver() ;
	}

}
