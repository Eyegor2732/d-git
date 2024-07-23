package rahulshettyacademy;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class eCommerce_tc_2 extends BaseTest{
	
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
		
		WebElement inputNameField = driver.findElement(By.id("com.androidsample.generalstore:id/nameField"));
		inputNameField.sendKeys("Eyegor");
		Assert.assertTrue(inputNameField.getText().equals("Eyegor"), "Wrong name is shown");
		driver.hideKeyboard();
		
		WebElement letsShopButton = driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop"));
		letsShopButton.click();
		
		WebElement productsPageTitle = driver.findElement(By.xpath("//android.widget.TextView[@text='Products']"));
		Assert.assertTrue(productsPageTitle.isDisplayed());
		
		///// cace tc_2
		String itemToBuy = "Air Jordan 9 Retro";
		scrollToElementAction(itemToBuy);
		// My way
//		WebElement productCard = driver.findElement(By.xpath("//android.widget.TextView[@text=itemToBuy]/.."));
//		WebElement addToCardButton = productCard.findElement(By.id("com.androidsample.generalstore:id/productAddCart"));
//				//productCard.findElement(By.xpath("//android.widget.TextView[@text='ADD TO CART']"));
//		addToCardButton.click();
//		String addToCardButtonText = addToCardButton.getText();
//		Assert.assertEquals(addToCardButtonText, "ADDED TO CART", "Button text is not correct.");
		//Rahul's way
		List<WebElement> cardsOnDcreen = driver.findElements(By.id("com.androidsample.generalstore:id/productName"));
		int productCount = cardsOnDcreen.size();
		
		for (int i=0; i<productCount; i++) {
			String productName = cardsOnDcreen.get(i).getText();
			
			if (productName.equalsIgnoreCase(itemToBuy)) {
				WebElement addToCardButton = driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i);
				addToCardButton.click();
				String addToCardButtonText = addToCardButton.getText();
				Assert.assertEquals(addToCardButtonText, "ADDED TO CART", "Button text is not correct.");
			}
		}
		
		WebElement cartCounter = driver.findElement(By.id("com.androidsample.generalstore:id/counterText"));
		Assert.assertTrue(cartCounter.isDisplayed());
		int cartCounterAmount = Integer.parseInt(cartCounter.getText());
		
		WebElement cardButton = driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart"));
		cardButton.click();
		
		// My way
//		WebElement cartPageTitle = driver.findElement(By.xpath("//android.widget.TextView[@text='Cart']"));
		// Rahul's way. It's wrong, because we already have implicit way in BaseTest.
		WebElement cartPageTitle = driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(cartPageTitle, "text", "Cart"));
		
		Assert.assertTrue(cartPageTitle.isDisplayed());
		
		List<WebElement> itemsInCart = driver.findElements(By.id("com.androidsample.generalstore:id/productName"));
		int itemsInCartCount = itemsInCart.size();
		Assert.assertEquals(itemsInCartCount, cartCounterAmount, "Cart counter is not equal to amount items in cart");
		String actualItemText = itemsInCart.get(itemsInCartCount-1).getText();
		Assert.assertEquals(actualItemText, itemToBuy, "Wrong item was added to cart.");
		
		List<WebElement> pricesInCart = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		float sum = 0;
		for (WebElement item: pricesInCart) {
			sum = sum + Float.parseFloat(item.getText().substring(1));
		}
		
		WebElement totalPurchaseAmount = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl"));
		float totalPurchaseAmountNumber = Float.parseFloat(totalPurchaseAmount.getText().substring(1));
		
		Assert.assertEquals(totalPurchaseAmountNumber, sum, "Cart total price is incorrect.");
		
	}

}
