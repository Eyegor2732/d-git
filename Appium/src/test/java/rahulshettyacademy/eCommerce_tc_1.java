package rahulshettyacademy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class eCommerce_tc_1 extends BaseTest{
	
	@Test
	public void fillFormTest() throws InterruptedException {
		WebElement dropdownArrow = driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry"));
		dropdownArrow.click();
		
		scrollToElementAction("Argentina");
		
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
		
		WebElement inputNameField = driver.findElement(By.id("com.androidsample.generalstore:id/nameField"));
		inputNameField.sendKeys("Eyegor");
		Assert.assertTrue(inputNameField.getText().equals("Eyegor"), "Wrong name is shown");
		driver.hideKeyboard();
		
		letsShopButton.click();
		
		WebElement productsPageTitle = driver.findElement(By.xpath("//android.widget.TextView[@text='Products']"));
		Assert.assertTrue(productsPageTitle.isDisplayed());
//		
//		scrollToElementAction("Air Jordan 9 Retro");
//		WebElement productCard = driver.findElement(By.xpath("//android.widget.TextView[@text='Air Jordan 9 Retro']/.."));
//		WebElement addToCardButton = productCard.findElement(By.xpath("//android.widget.TextView[@text='ADD TO CART']"));
//		addToCardButton.click();
	}

}
