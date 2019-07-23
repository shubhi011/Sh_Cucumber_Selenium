package com.webdriver.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ButtonHelper {
	
	//singleton design pattern:Only a single instance throughout the application.
	//private constructor:To restrict object creation from outside.
	//public method:-to provide the access of the instance to other classes.
	private static ButtonHelper buttonHelper;
	private static WebDriver wdriver;
	private WebElement element;
	
	private ButtonHelper(WebDriver driver)
	{
		wdriver=driver;
	}
   
	public static ButtonHelper getInstance(WebDriver driver)
	{
		//if instance is not already present create the instance otherwise return current class instance
		if(buttonHelper==null || wdriver.hashCode()!=driver.hashCode()) //same hashcode means same webdriver instance
			buttonHelper= new ButtonHelper(driver);
		    return buttonHelper;
	}

	public void click(By locator)
	{
		wdriver.findElement(locator).click();;
		
	}
	
	
}
