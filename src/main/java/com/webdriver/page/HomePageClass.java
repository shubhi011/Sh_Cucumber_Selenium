package com.webdriver.page;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import com.webdriver.helper.TextBoxHelper;


public class HomePageClass extends PageBase {
	
	private WebDriver driver;
	
	//private DriverService service;
	/*
	 * we will use driver inside this class so it needs to be initialised otherwise it throws null pointer exception
	 * for that we will use constructor
	 */
	
	public HomePageClass (WebDriver driver)
	{   super(driver);
		this.driver=driver;
		//PageFactory.initElements(driver, this);//this points to instance to current class i.e homepageclass.java
	}
	
	//WebElements 
	//public By loginButton=By.id("abc");          using POM
	  
	 @FindBy(how=How.ID,using="email")
	 public WebElement email;
	 
	 @FindBy(how=How.ID,using="pass")
	 public WebElement password;
	 
	 @FindBy(how=How.XPATH,using="//span[text()='Log in to Facebook']")
	 public WebElement loginEmail;
	 
	 
	//Action
	public void enterEmail(String username)
	{	
		TextBoxHelper textBoxHelper=TextBoxHelper.getInstance(driver);	
		textBoxHelper.setText(email, username);		
		System.out.println("email entered");
	}
	
	public void enterPassword(String password)
	{
		email.sendKeys(password);	
		System.out.println("password entered");
	}
	
	public void clickLogin()
	{
		loginApplication();
		System.out.println("login");
	}
	
	
	public void verifyTitle()
	{
		String expectedTitle="Facebook – log in or sign up";
		Assert.assertEquals(expectedTitle, driver.getTitle());	
		
		
	}
	
	//Navigation
	/*public void navigateToLoginPage(String uname,String password)//As this method will redirect to login page so it should return the instance of login page
	{
		LoginPageClass loginPage=new LoginPageClass(driver);
		driver.findElement(loginButton).click();
		WebDriverWait wait=getWait();
		wait.until(ExpectedConditions.elementToBeClickable(loginPage.ele1));
		
	}  */
	
	

}
