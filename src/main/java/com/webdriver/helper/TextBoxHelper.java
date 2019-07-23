package com.webdriver.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextBoxHelper {
	
	//singleton design pattern:Only a single instance throughout the application.
	//private constructor:To restrict object creation from outside.
	//public method:-to provide the access of the instance to other classes.
	private static TextBoxHelper textBoxHelper;
	private static WebDriver wdriver;
	private WebElement element;
	
	private TextBoxHelper(WebDriver driver)
	{
		wdriver=driver;
	}
   
	public static TextBoxHelper getInstance(WebDriver driver)
	{
		//if instance is not already present create the instance otherwise return current class instance
		if(textBoxHelper==null || wdriver.hashCode()!=driver.hashCode()) //same hashcode means same webdriver instance
			textBoxHelper= new TextBoxHelper(driver);
		    return textBoxHelper;
	}

	public void setText(By locator,String value)
	{
		element=wdriver.findElement(locator);
		element.sendKeys(value);
	}
	
	//overloaded method
	public void setText(WebElement element,String value)
	{
		element.sendKeys(value);
	}
	
	public String getText(By locator)
	{
		element=wdriver.findElement(locator);
		String value=element.getText();
		return value;
	}
	
	public void clear(By locator)
	{
		element=wdriver.findElement(locator);
		element.clear(); 
	}
}
