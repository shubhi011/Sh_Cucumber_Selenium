package com.webdriver.helper;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertHelper {

	// singleton design pattern:Only a single instance throughout the application.
	// private constructor:To restrict object creation from outside.
	// public method:-to provide the access of the instance to other classes.
	private static AlertHelper alertHelper;
	private static WebDriver wdriver;
	

	private AlertHelper(WebDriver driver) {
		wdriver = driver;
	}

	public static AlertHelper getInstance(WebDriver driver) {
		// if instance is not already present create the instance otherwise return
		// current class instance
		if (alertHelper == null || wdriver.hashCode() != driver.hashCode()) // same hashcode means same webdriver
																			// instance
			alertHelper = new AlertHelper(driver);
		return alertHelper;
	}


	private WebDriverWait getWait() {
		WebDriverWait wait = new WebDriverWait(wdriver, 60);
		wait.pollingEvery(250, TimeUnit.MILLISECONDS);
		wait.ignoring(NoAlertPresentException.class);
		return wait;

	}

	private Alert waitForAlert() {
		WebDriverWait wait = getWait();
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		return alert;
	}

	public void acceptAlert() {
		Alert alert = waitForAlert();// wait for alert and switch the control to it
		alert.accept();

	}

	public void dismissAlert() {
		Alert alert = waitForAlert();
		alert.dismiss();

	}

	public void setAlertText(String arg) {
		Alert alert = waitForAlert();
		alert.sendKeys(arg);
		alert.accept();

	}

	public String getAlertText() {
		Alert alert = waitForAlert();
		return alert.getText();

	}

}
