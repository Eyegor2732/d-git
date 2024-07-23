package rahulshettyacademy;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class MiscellaneousAppiumActions2 extends BaseTest{
	
	@Test
	public void miscellaneousTest() throws MalformedURLException {
		// xpath, id, accessibilityID(AppiumBy only), className, androidUIAutomator(AppiumBy only)
		// App Package and App Activity
		// Open neede page of the app in Appium Inspector
		// in cmd type
		// for Mac:
		// adb shell dumpsys window | grep -E "mCurrentFocus"
		// for Windows:
		// adb shell dumpsys window | find "mCurrentFocus"
		// or in two steps for all platforms:
		// adb shell
		// dumpsys window displays | grep -E "mCurrentFocus"
		String appPackage = "io.appium.android.apis";
		String appActivity = "io.appium.android.apis.preference.PreferenceDependencies";
		
//		Activity activity = new Activity(appPackage, appActivity); 
//		driver.startActivity(activity); // deprecated
		
		appPackageActivityAction(appPackage, appActivity);

		// or in one line
//		String appPackageActivity = "io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies";
//		appPackageActivityAction1(appPackageActivity);
		

//		WebElement preferenceLink = driver.findElement(AppiumBy.accessibilityId("Preference"));
//		preferenceLink.click();
//		
//		WebElement preferenceDependenciesLink = driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies"));
//		preferenceDependenciesLink.click();
		
		WebElement wifiCheckbox = driver.findElement(AppiumBy.id("android:id/checkbox"));
		String checkedAttribute = wifiCheckbox.getAttribute("checked");
		if (checkedAttribute.equals("false")) {
			wifiCheckbox.click();
		}

//		Two options of device rotation
//		DeviceRotation landscape = new DeviceRotation(0, 0, 90);
//		driver.rotate(landscape);
		driver.rotate(ScreenOrientation.LANDSCAPE);
		
		WebElement wifiSettings = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"WiFi settings\"]"));
		wifiSettings.click();
		
//		WebElement alertPanel = driver.findElement(By.id("android:id/parentPanel"));
//		Assert.assertTrue(alertPanel.isDisplayed());
		
		WebElement alertTitle = driver.findElement(By.id("android:id/alertTitle"));
		String actualTitleText = alertTitle.getText();
		String expectedTitleText = "WiFi settings";
		Assert.assertEquals(actualTitleText, expectedTitleText, "It's not expected text.");
		// copy to clipboard
		driver.setClipboardText("ShmotekDeco");
		WebElement wifiNameInput = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/edit\")"));
		// paste from clipboard
		wifiNameInput.sendKeys(driver.getClipboardText());
		
		WebElement okButton = driver.findElement(By.id("android:id/button1"));
		okButton.click();
		
		driver.rotate(ScreenOrientation.PORTRAIT);
		WebElement wifiCheckbox1 = driver.findElement(AppiumBy.id("android:id/checkbox"));
		String checkedAttribute1 = wifiCheckbox1.getAttribute("checked");
		if (checkedAttribute1.equals("true")) {
			wifiCheckbox1.click();
		}
		
		// tapping on Android keys
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		Assert.assertTrue(wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("android:id/parentPanel"))));

	}

}
