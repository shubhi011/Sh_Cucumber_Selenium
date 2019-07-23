package com.webdriver.page;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageClass {
	
	private WebDriver driver;
	/*
	 * we will use driver inside this class so it needs to be initialised otherwise it throws null pointer exception
	 * for that we will use constructor
	 */
	
	public LoginPageClass (WebDriver driver)
	{
		this.driver=driver;
	}
	
	//WebElements
	public By ele1=By.id("");
	
	
	//Action
	public void Search(String str)
	{
		
	}
	
	//Navigation
	public void navigateToLoginPage(String uname,String password)//As this method will redirect to login page so it should return the instance of login page
	{
		LoginPageClass loginPage=new LoginPageClass(driver);
		//driver.findElement(By.id(id));
		//WebDriver wait=getWait();
		//wait.until(ExpectedConditions.elementToBeClickable(LoginPage loginButton));
		
	}
	
	private WebDriverWait getWait()
	{ 
		WebDriverWait wait=new WebDriverWait(driver,60);
		//wait.pollingEvery(250,TimeUnit.MILLISECONDS);
		wait.ignoring(NoSuchElementException.class);
		return wait;
	}
	

}
