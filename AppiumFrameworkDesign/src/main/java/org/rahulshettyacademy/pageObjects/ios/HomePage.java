package org.rahulshettyacademy.pageObjects.ios;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.rahulshettyacademy.pageObjects.utils.IOSActions;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class HomePage extends IOSActions{
	
	IOSDriver driver;
	
	public HomePage(IOSDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this); //
	}
	
	// Selectors
	
	@iOSXCUITFindBy(accessibility="Alert Views")
	private WebElement alertViews;
	
	// Actions
	
	public AlertViewsPage tapAlertViews() {
		alertViews.click();
		return (new AlertViewsPage(driver));
	}
}
 