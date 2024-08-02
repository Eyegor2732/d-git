package org.rahulshettyacademy.pageObjects.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AndroidActions  extends AppiumUtils{
	
	AndroidDriver driver;
	
	public AndroidActions(AndroidDriver driver) {
		//super(driver);
		this.driver = driver;
	}
	
	public void longPressAction(WebElement ele) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "duration", 2000));
	}

	public void scrollToEndAction() {
		boolean canScrollMore;
		do {
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap
					.of("left", 100, "top", 100, "width", 200, "height", 200, 
							"direction", "down", 
							"percent", 3.0
							));
		} while (canScrollMore);
	}
	
	public void scrollFullAction(WebElement ele, String direction) {
		boolean canScrollMore;
		do {
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap
					.of(
							"elementId", ele, 
							"direction", direction, 
							"percent", 3.0
							));
		} while (canScrollMore);
	}

	public void scrollToElementAction(String title) {
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector())"
						+ ".scrollIntoView(text(\"" + title + "\"));"));
	}
	
	public boolean scrollToElementAction2(String title) {
		try {
			driver.findElement(AppiumBy
					.androidUIAutomator("new UiScrollable(new UiSelector())"
							+ ".scrollIntoView(text(\"" + title + "\"));"));
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	
//	public boolean scrollToElementAction1(String title) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
////		wait.until(ExpectedConditions.invisibilityOfElementLocated(AppiumBy
////				.androidUIAutomator("new UiScrollable(new UiSelector())"
////						+ ".scrollIntoView(text(\"" + title + "\"));")));
//		
//		if (wait.until(ExpectedConditions.invisibilityOfElementLocated(AppiumBy
//				.androidUIAutomator("new UiScrollable(new UiSelector())"
//						+ ".scrollIntoView(text(\"" + title + "\"));")))) {
//			System.out.println("kuku");
//			return false;
//		}
//		driver.findElement(AppiumBy
//				.androidUIAutomator("new UiScrollable(new UiSelector())"
//						+ ".scrollIntoView(text(\"" + title + "\"));"));	
//		
//		return true;
//	}
	
	public void swipeAction(WebElement ele, String direction, double percent) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", 
				ImmutableMap.of(
						"elementId", ((RemoteWebElement) ele).getId(),
						"direction", direction, 
						"percent", percent
						));
	}
	
	public void dragDropAction(WebElement ele, int endX, int endY) {
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) ele).getId(),
			    "endX", endX,
			    "endY", endY
			));
	}
	
	public void appPackageActivityAction(String appPackage, String appActivity) {
		((JavascriptExecutor) driver).executeScript("mobile: startActivity",
				ImmutableMap.of(
						"intent", appPackage + "/" + appActivity
						));
	}
	
	public void appPackageActivityAction1(String appPackageActivity) {
		((JavascriptExecutor) driver).executeScript("mobile: startActivity",
				ImmutableMap.of(
						"intent", appPackageActivity
						));
	}	

}
