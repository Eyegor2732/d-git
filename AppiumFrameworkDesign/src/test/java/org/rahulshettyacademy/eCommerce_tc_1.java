package org.rahulshettyacademy;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class eCommerce_tc_1 extends AndroidBaseTest{
	
	
	@BeforeMethod
	public void preSetup() throws InterruptedException {
//		String appPackage = "com.androidsample.generalstore";
//		String appActivity = "com.androidsample.generalstore.MainActivity"; // For some reason it gives error
////		String appActivity = "com.androidsample.generalstore.SplashActivity" ;// It does not give error, but does not work
//		formPage.appPackageActivityAction(appPackage, appActivity);
//		String appPackageActivity = "com.androidsample.generalstore/com.androidsample.generalstore.MainActivity";
//		formPage.appPackageActivityAction1(appPackageActivity);
		System.out.println("@BeforeMethod");
	}
	
	@Test
	public void fillFormPositiveFlowTest() {
		
		WebElement inputNameField = driver.findElement(By.id("com.androidsample.generalstore:id/nameField"));
		inputNameField.sendKeys("Eyegor");
		driver.hideKeyboard();
		
		WebElement dropdownArrow = driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry"));
		dropdownArrow.click();
		
		WebElement itemUs = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Argentina\")"));
		itemUs.click();
		Assert.assertNotNull(itemUs, "'Argentina' is not in the list");
		Assert.assertTrue(itemUs.isDisplayed(), "'Argentina' country is not in the dropdown list.");
		Assert.assertTrue(itemUs.getText().equals("Argentina"), "Wrong country is shown as selected");
		
		WebElement femaleRadioButton = driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale"));
		Assert.assertTrue(femaleRadioButton.isDisplayed(), "'Female' radio button is not displayed.");
		Assert.assertTrue(femaleRadioButton.isEnabled(), "'Female' radio button is displayed, but not enabled.");
		String checkedAttribute = femaleRadioButton.getAttribute("checked");
		if (checkedAttribute.equals("false")) {
			femaleRadioButton.click();
		}
		
		WebElement letsShopButton = driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop"));
		letsShopButton.click();
//		Assert.assertTrue(letsShopButton.isDisplayed(), "'Lets Shop' button is not displayed.");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		Assert.assertTrue(wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("(com.androidsample.generalstore:id/btnLetsShop"))));
		
		List<WebElement> errorToast = driver.findElements(By.xpath("(//android.widget.Toast)[1]"));		
		int errorToastSize = errorToast.size();
		Assert.assertTrue((errorToastSize == 0), "Error message is shown");
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		Assert.assertTrue(wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//android.widget.Toast)[1]"))));
	}
	
	@Test
	public void fillFormErrorValidationTest() {
		WebElement dropdownArrow = driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry"));
		dropdownArrow.click();
		
		WebElement itemUs = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Argentina\")"));
		itemUs.click();
		Assert.assertNotNull(itemUs, "'Argentina' is not in the list");
		Assert.assertTrue(itemUs.isDisplayed(), "'Argentina' country is not in the dropdown list.");
		Assert.assertTrue(itemUs.getText().equals("Argentina"), "Wrong country is shown as selected");
		
		WebElement femaleRadioButton = driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale"));
		Assert.assertTrue(femaleRadioButton.isDisplayed(), "'Female' radio button is not displayed.");
		Assert.assertTrue(femaleRadioButton.isEnabled(), "'Female' radio button is displayed, but not enabled.");
		String checkedAttribute = femaleRadioButton.getAttribute("checked");
		if (checkedAttribute.equals("false")) {
			femaleRadioButton.click();
		}
		
		WebElement letsShopButton = driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop"));
		letsShopButton.click();
		Assert.assertTrue(letsShopButton.isDisplayed(), "'Lets Shop' button is not displayed.");
		
		WebElement errorToast = driver.findElement(By.xpath("(//android.widget.Toast)[1]"));		
		String actualErrorToastText = errorToast.getAttribute("name");
		Assert.assertEquals(actualErrorToastText, "Please enter your name", "Unexpected error toast text.");
		System.out.println("fillFormErrorValidationTest");
	}
	
	

}
