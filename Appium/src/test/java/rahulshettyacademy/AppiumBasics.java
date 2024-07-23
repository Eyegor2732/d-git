package rahulshettyacademy;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class AppiumBasics extends BaseTest{
	
	@Test
	public void appiumWifiSettingsNameTest() throws MalformedURLException, URISyntaxException {
		// xpath, id, accessibilityID(AppiumBy only), className, androidUIAutomator(AppiumBy only)
		WebElement preferenceLink = driver.findElement(AppiumBy.accessibilityId("Preference"));
		preferenceLink.click();
		
		WebElement preferenceDependenciesLink = driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies"));
		preferenceDependenciesLink.click();
		
		WebElement wifiCheckbox = driver.findElement(AppiumBy.id("android:id/checkbox"));
		if (!wifiCheckbox.isSelected()) {
			wifiCheckbox.click();
		}
		
		WebElement wifiSettings = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"WiFi settings\"]"));
		wifiSettings.click();
		
		WebElement alertPanel = driver.findElement(By.id("android:id/parentPanel"));
		Assert.assertTrue(alertPanel.isDisplayed());
		
		WebElement alertTitle = driver.findElement(By.id("android:id/alertTitle"));
		String actualTitleText = alertTitle.getText();
		String expectedTitleText = "WiFi settings";
		Assert.assertEquals(actualTitleText, expectedTitleText, "It's not expected text.");
		
		WebElement wifiNameInput = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/edit\")"));
		wifiNameInput.sendKeys("ShmotekDeco");
		
		WebElement okButton = driver.findElement(By.id("android:id/button1"));
		okButton.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		Assert.assertTrue(wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("android:id/parentPanel"))));

	}

}
