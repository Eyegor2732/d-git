 package rahulshettyacademy;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class IOSScrollTest extends IOSBaseTest{
	
	@Test
	public void iOSScrollTest() throws InterruptedException {
		WebElement webViewtitle = driver.findElement(AppiumBy.accessibilityId("Web View"));

		scrollToElementAction(webViewtitle, "down");
		Assert.assertTrue(webViewtitle.isDisplayed());

		webViewtitle.click();
		
		Assert.assertTrue(driver.findElement(AppiumBy.accessibilityId("This is HTML content inside a ")).isDisplayed());
		
		WebElement backButton = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"UIKitCatalog\"`]"));
		
		backButton.click();
		Assert.assertTrue(webViewtitle.isDisplayed());
		
		WebElement pickerViewTitle = driver.findElement(AppiumBy.accessibilityId("Picker View"));
		Assert.assertTrue(pickerViewTitle.isDisplayed());
		pickerViewTitle.click();
		
		// enter value to wheel selectors
		WebElement redColorWheel = driver.findElement(AppiumBy.accessibilityId("Red color component value"));
		String originalValue = redColorWheel.getText();
		String inputValue = "-100"; // it's out of range, therefore original value should remain
		redColorWheel.sendKeys(inputValue);
		String actualValue = redColorWheel.getText();
		Assert.assertEquals(actualValue, originalValue);
		
		WebElement greenColorWheel = driver.findElement(AppiumBy.iOSNsPredicateString("name == 'Green color component value'"));
		inputValue = "150";
		greenColorWheel.sendKeys(inputValue);
		actualValue = greenColorWheel.getText();
		Assert.assertEquals(actualValue, inputValue);
		
		WebElement blueColorWheel = driver.findElement(AppiumBy.xpath("//XCUIElementTypePickerWheel[@name=\"Blue color component value\"]"));
		inputValue = "10";
		blueColorWheel.sendKeys(inputValue);
		actualValue = blueColorWheel.getText();
		Assert.assertEquals(actualValue, inputValue);
	}		
}

