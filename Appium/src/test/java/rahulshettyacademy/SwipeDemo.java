package rahulshettyacademy;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class SwipeDemo extends BaseTest{
	
	@Test
	public void swipeDemoTest() throws MalformedURLException, URISyntaxException, InterruptedException {
		// xpath, id, accessibilityID(AppiumBy only), className, androidUIAutomator(AppiumBy only)
		
		WebElement viewsLink = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Views\")"));
		viewsLink.click();

		WebElement galleryLink = driver.findElement(AppiumBy.accessibilityId("Gallery"));
		galleryLink.click();
		
		WebElement photosLink = driver.findElement(AppiumBy.accessibilityId("1. Photos"));
		photosLink.click();
				
		WebElement firstPhoto = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(0)"));
		// Assert the first photo is selected before  swipe
		Assert.assertTrue(firstPhoto.isSelected());
		swipeAction(firstPhoto, "left", 0.15);
		// Assert the first photo is not selected after swipe
		firstPhoto = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(0)"));
		Assert.assertFalse(firstPhoto.isSelected());

		Thread.sleep(2000);
	}

}


