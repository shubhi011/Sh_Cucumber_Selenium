package com.webdriver.helper;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {
	
	private static WaitHelper waitHelper;
	private static WebDriver wdriver;
	
	private WaitHelper(WebDriver driver)
	{
		wdriver=driver;
	}
	
	public static WaitHelper getInstance(WebDriver driver)
	{
		//if instance is not already present create the instance otherwise return current class instance
		if(waitHelper==null || wdriver.hashCode()!=driver.hashCode()) //same hashcode means same webdriver instance
			waitHelper= new WaitHelper(driver);
		    return waitHelper;
	}
	
	@SuppressWarnings("deprecation")
	public WebDriverWait getWait(int timeOutInSeconds,int pollingEveryInMiliSec) {
		
		WebDriverWait wait = new WebDriverWait(wdriver, timeOutInSeconds);
		wait.pollingEvery(pollingEveryInMiliSec, TimeUnit.MILLISECONDS);
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(NoSuchFrameException.class);
		return wait;
	}

}
