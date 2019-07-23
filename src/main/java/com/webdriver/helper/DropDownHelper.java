package com.webdriver.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownHelper {
	
	private static WebDriver wdriver;
	private static DropDownHelper dropDownHelper;
	private DropDownHelper(WebDriver driver)
	{
		wdriver=driver;
		
	}
	
	public static DropDownHelper getInstance(WebDriver driver)
	{
		if(dropDownHelper==null || driver.hashCode() != wdriver.hashCode())
			dropDownHelper= new DropDownHelper(driver);
		     return dropDownHelper;
	}
	
	public void SelectByVisibleText(By locator,String visibleValue)
	{
		Select oselect=new Select(wdriver.findElement(locator));
		oselect.selectByVisibleText(visibleValue);
		
	}
	
	

}
