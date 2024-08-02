package rahulshettyacademy;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class IOSBasics extends IOSBaseTest{
	
	@Test
	public void iOSBasicsTest() throws InterruptedException {
		// Xpath, classname, css, iosClassChain, IOSPredicateString, accessibilityID, ID
		driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
		
//		// xpath
//		driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Text Entry\"]")).click();
		// the same but ios specific
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Text Entry\"`]")).click();
		
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeTextField")).sendKeys("Hello World");
		
		driver.findElement(AppiumBy.accessibilityId("OK")).click();
		
//		// different options for predicateString
//		driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value == 'Confirm / Cancel'")).click();
//		driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value BEGINSWITH[c] 'Confirm'")).click();
//		driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value ENDSWITH 'Cancel'")).click();
		driver.findElement(AppiumBy.iOSNsPredicateString("name == \"Confirm / Cancel\"")).click();
		
		String message = driver.findElement(AppiumBy.iOSNsPredicateString("value BEGINSWITH 'A message'")).getText();
		System.out.println(message);
		Assert.assertTrue(message.contains("short, complete sentence"));

		driver.findElement(AppiumBy.iOSNsPredicateString("name == \"Confirm\"")).click();
		
		// longpress, scroll, swipe, slides
		
	}
}
