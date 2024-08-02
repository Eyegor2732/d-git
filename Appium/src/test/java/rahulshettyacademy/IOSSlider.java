  package rahulshettyacademy;

import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class IOSSlider extends IOSBaseTest{
	
	@Test
	public void iOSSliderTest() throws InterruptedException {
		driver.findElement(AppiumBy.iOSNsPredicateString("name == 'Sliders'")).click();
		
		WebElement tintedSlider = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeSlider[2]"));
		tintedSlider.sendKeys("0.4");  // range from 0 to 1.
		// for some reason on big move it gives wrong value, i.e. move from 0 to 0.9 gives 0.93%. 
		Assert.assertEquals(tintedSlider.getAttribute("value"), "40%");
		
	}		
}
