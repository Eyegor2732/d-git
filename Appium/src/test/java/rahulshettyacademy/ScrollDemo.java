package rahulshettyacademy;

import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;

public class ScrollDemo extends BaseTest{
	
	@Test
	public void scrollDemoTest() throws URISyntaxException, InterruptedException {
		// xpath, id, accessibilityID(AppiumBy only), className, androidUIAutomator(AppiumBy only)
		
		WebElement viewsLink = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Views\")"));
		viewsLink.click();
		
//		//Google way
//		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
		scrollToElementAction("WebView");
		
		// Appium way
//		// Where to scroll is known prior
		WebElement listView = driver.findElement(By.id("android:id/list"));
//		scrollFulltAction(listView, "down");
		
		WebElement webViewLink = driver.findElement(AppiumBy.accessibilityId("WebView"));
		Assert.assertTrue(webViewLink.isDisplayed());
		
		scrollFullAction(listView, "up");
		
		// No prior idea. Keep scrolling until end.
//		scrollToEndAction();	
		
	}

}

