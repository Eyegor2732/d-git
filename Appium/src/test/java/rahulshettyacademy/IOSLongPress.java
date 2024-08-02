  package rahulshettyacademy;

import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class IOSLongPress extends IOSBaseTest{
	
	@Test
	public void iOSLongPressTest() throws InterruptedException {
		driver.findElement(AppiumBy.iOSNsPredicateString("name == 'Steppers'")).click();
		
		WebElement defaultIncrementButton = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"Increment\"`][3]"));
		int counterBefore = Integer.parseInt(driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[4]")).getAttribute("value"));
		touchAndHoldAction(defaultIncrementButton, 5);
		int counterAfter = Integer.parseInt(driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[4]")).getAttribute("value"));
		Assert.assertTrue(counterBefore < counterAfter);
	}		
}
