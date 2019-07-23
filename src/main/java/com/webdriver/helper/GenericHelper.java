package com.webdriver.helper;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class GenericHelper {
	
	private static WebDriver wdriver;
	private static GenericHelper genericHelper;
	public GenericHelper(WebDriver driver)
	{
		wdriver=driver;
	}

	
	public static GenericHelper getInstance(WebDriver driver)
	{
		if((genericHelper ==null) || (wdriver.hashCode()!=driver.hashCode()))				
			           genericHelper=new GenericHelper(driver);
			           return genericHelper;				
	}
	
	public void takeScreenShot(String aDir,String bFileName)
	{
		
		/*
		 * if dir is present,then save the screenshot in the given directory
		 * else
		 * create the dir ,take screenshot,& save it in the dir
		 */
		File directory=new File(aDir);
		if(!directory.exists())
		   directory.mkdirs();
		
		File screenshot=((TakesScreenshot)wdriver).getScreenshotAs(OutputType.FILE); //this will create temp file
		try {
			FileUtils.copyFile(screenshot, new File(directory.getAbsolutePath()+File.separator+bFileName));
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}
	
	
}
