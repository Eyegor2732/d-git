package rahulshettyacademy;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class IOSBasics extends IOSBaseTest{
	
	@Test
	public void iOSBasicsTest() {
		// Xpath, classname, css, iosClassChain, IOSPredicateString, accessibilityID, ID
		driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();;
	}
}
