package rahulshettyacademy;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class LongPress extends BaseTest{
	
	@Test
	public void longPressGestureTest() throws MalformedURLException, URISyntaxException, InterruptedException {
		// xpath, id, accessibilityID(AppiumBy only), className, androidUIAutomator(AppiumBy only)
		
		WebElement viewsLink = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Views\")"));
		viewsLink.click();
		
		WebElement expandableListLink = driver.findElement(AppiumBy.accessibilityId("Expandable Lists"));
		expandableListLink.click();
		
		
		WebElement customAdapterLink = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"1. Custom Adapter\"]"));
		customAdapterLink.click();
		
		WebElement peopleNamesLink = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"People Names\"]"));
		longPressAction(peopleNamesLink);

		WebElement samplesPopup = driver.findElement(AppiumBy.xpath("/h"
				+ "ierarchy/android.widget.FrameLayout/android.widget.FrameLayout"));
		Assert.assertTrue(samplesPopup.isDisplayed());
		
		WebElement sampleMenuLink = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Sample menu\")"));
		Assert.assertTrue(sampleMenuLink.isDisplayed());
		Assert.assertTrue(sampleMenuLink.isEnabled());

	}

}
