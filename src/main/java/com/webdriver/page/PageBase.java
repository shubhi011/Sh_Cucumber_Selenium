package com.webdriver.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {
	
	private WebDriver driver;
	
	@FindBy(how=How.XPATH,using="//input[@data-testid='royal_login_button']")
	 public WebElement login;

	public PageBase(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	protected WebDriverWait getWait()  //protected so that child class can redefine implementation if needed
	{ 
		WebDriverWait wait=new WebDriverWait(driver,60);
		wait.pollingEvery(250,TimeUnit.MILLISECONDS);
		wait.ignoring(NoSuchElementException.class);
		return wait;
	}
	
	//adding common methods 
	protected HomePageClass loginApplication()   //return type can also be PageBase
	{
		login.click();	
		//create instance of page on which u r landed
		HomePageClass homePage=new HomePageClass(driver);
		WebDriverWait wait=getWait();
		wait.until(ExpectedConditions.elementToBeClickable(homePage.loginEmail));
	   	return homePage;
	}
	
	protected void logoutFromApplication()
	{
		//To Do
	}
	
	

}
