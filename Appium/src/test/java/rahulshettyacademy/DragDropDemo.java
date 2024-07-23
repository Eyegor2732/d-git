package rahulshettyacademy;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class DragDropDemo extends BaseTest{
	
	@Test
	public void dragDropDemoTest() throws MalformedURLException, URISyntaxException, InterruptedException {
		// xpath, id, accessibilityID(AppiumBy only), className, androidUIAutomator(AppiumBy only)
		
		WebElement viewsLink = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Views\")"));
		viewsLink.click();

		WebElement dragDropLink = driver.findElement(AppiumBy.accessibilityId("Drag and Drop"));
		dragDropLink.click();
		
		WebElement sourceDot = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));
		WebElement targetDot = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_2"));
		// targetDot center x coordinate
		int endX = targetDot.getRect().getX() + targetDot.getRect().getWidth() / 2;
		// targetDot center y coordinate
		int endY = targetDot.getRect().getY() + targetDot.getRect().getHeight() / 2;
		
		dragDropAction(sourceDot, endX, endY);
		
		WebElement dragResultText = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_result_text"));
		String actualValue = dragResultText.getAttribute("text");
		String expectedValue = "Dropped!";
		Assert.assertEquals(actualValue, expectedValue, "Actual value is wrong.");
	}

}


