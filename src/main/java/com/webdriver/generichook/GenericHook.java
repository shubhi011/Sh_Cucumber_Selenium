package com.webdriver.generichook;

import org.openqa.selenium.WebDriver;

import com.webdriver.services.DriverService;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class GenericHook {
	
	//Hooks run before and after each scenario
	private DriverService service;
	private WebDriver driver;
	
	public GenericHook(DriverService service)
	{
		this.service=service;
		this.driver=service.getDriver();   //gets the driver instance from DriverService class
	}
	
	
	@Before
	public void setUp()
	{
		 
	}
	
	@After
	public void tearDown(Scenario scenario)
	{
		
		if(driver!=null)
		{
			driver.quit();
		}
		
		if(scenario.isFailed())
		{
			int random= (int) (Math.random()*1000); //unique name
			service.getGenericHelper().takeScreenShot("Screenshot","src"+random+ ".png");
		}
	}

}
