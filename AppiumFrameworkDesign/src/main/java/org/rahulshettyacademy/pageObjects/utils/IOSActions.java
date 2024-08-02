package org.rahulshettyacademy.pageObjects.utils;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.ios.IOSDriver;

public class IOSActions extends AppiumUtils{
	
	IOSDriver driver;
	
	public IOSActions(IOSDriver driver) {
		//super(driver);
		this.driver = driver;
	}
	
	public void touchAndHoldAction(WebElement element, int duration) {
    	Map<String, Object> params = new HashMap<>();
	    params.put("element", ((RemoteWebElement) element).getId());
	    params.put("duration", duration);
	    driver.executeScript("mobile:touchAndHold", params);
	}
    
    public void scrollToElementAction(WebElement element, String direction) {
    	Map<String, Object> params = new HashMap<>();
	    params.put("element", ((RemoteWebElement) element).getId());
	    params.put("direction", direction);
	    driver.executeScript("mobile:scroll", params);
	}
    
    public void launchAppAction(String bundleId) {
    	Map<String, String> params = new HashMap<>();
	    params.put("bundleId", bundleId);
	    driver.executeScript("mobile:launchApp", params);
	}
		
}
