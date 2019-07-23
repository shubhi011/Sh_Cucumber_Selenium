package com.webdriver.helper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowHelper {
	
	//singleton design pattern:Only a single instance throughout the application.
	//private constructor:To restrict object creation from outside.
	//public method:-to provide the access of the instance to other classes.
	private static WindowHelper windowHelper;
	private static WebDriver wdriver;
	private WebElement element;
	
	private WindowHelper(WebDriver driver)
	{
		wdriver=driver;
	}
   
	public static WindowHelper getInstance(WebDriver driver)
	{
		//if instance is not already present create the instance otherwise return current class instance
		if(windowHelper==null || wdriver.hashCode()!=driver.hashCode()) //same hashcode means same webdriver instance
			windowHelper= new WindowHelper(driver);
		    return windowHelper;
	}

	private List<String> getWindowIds()
	{
		 ArrayList<String> windowIds=new ArrayList<String>(wdriver.getWindowHandles());
		 //put a restriction so that this list cannot be modified by some other method
		 return Collections.unmodifiableList(windowIds);
	}
	
	private WebDriverWait getWait()
	{
		WebDriverWait wait =new WebDriverWait(wdriver,60);
		return wait;
		
	}
	
	public void switchToWindow(int index)  
	{
		WebDriverWait wait=getWait();
		wait.until(ExpectedConditions.numberOfWindowsToBe(index));
		ArrayList<String>windowIds=	new ArrayList(getWindowIds());
		//put a check on index
		if(index<0 || index>windowIds.size())
			throw new IllegalArgumentException("Index is invalid");
		
		wdriver.switchTo().window(windowIds.get(index));
		
	}
	
	public void switchToParent()
	{
		ArrayList<String>windowIds=	new ArrayList<String>(getWindowIds());
		wdriver.switchTo().window(windowIds.get(0));  //index of parent window is always zero
	}
	
	
	public void switchToParentWithClose()   //This method will close all the child windows before switching to parent and keeps only parent window open
	{
		ArrayList<String>windowIds=	new ArrayList<String>(getWindowIds());
		for(int i=1;i<windowIds.size();i++)
		{
			wdriver.switchTo().window(windowIds.get(i));
			wdriver.close();
		}
		
		switchToParent();
	}
	
	
}
