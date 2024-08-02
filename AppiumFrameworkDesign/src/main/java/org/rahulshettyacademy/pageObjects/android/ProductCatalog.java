package org.rahulshettyacademy.pageObjects.android;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.rahulshettyacademy.pageObjects.utils.AndroidActions;
import org.testng.Assert;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductCatalog extends AndroidActions {

	AndroidDriver driver;

	public ProductCatalog(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this); //
	}

	// Selectors

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='ADD TO CART']")
	private List<WebElement> addToCardButtons;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement cartButton;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/rvProductList")
	private WebElement productList;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/counterText")
	private WebElement cartCounter;
	
	
	
	// Actions

	public CartPage goToCart() {
		cartButton.click();
		return (new CartPage(driver));
	}

	public void addItemToCardByIndex(int index) {
		if (addToCardButtons.size() > index) {
			addToCardButtons.get(index).click();
		}
	}
	// this works for items from list only
	public void addItemToCardByName(String itemToBuy) {
		scrollFullAction(productList, "up");
		scrollToElementAction(itemToBuy);
		WebElement productCard = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productName\" and @text=\"" + itemToBuy + "\"]/.."));	
		WebElement addToCardButton = productCard.findElement(By.id("com.androidsample.generalstore:id/productAddCart"));
		addToCardButton.click();
		String addToCardButtonText = addToCardButton.getText();
		Assert.assertEquals(addToCardButtonText, "ADDED TO CART", "Button text is not correct.");
	}
	
	// this works for non existing items too
	public void addItemToCardByName2(String itemToBuy) {
		scrollFullAction(productList, "up");
		if (scrollToElementAction2(itemToBuy)) {
			WebElement productCard = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productName\" and @text=\"" + itemToBuy + "\"]/.."));	
			WebElement addToCardButton = productCard.findElement(By.id("com.androidsample.generalstore:id/productAddCart"));
			addToCardButton.click();
			String addToCardButtonText = addToCardButton.getText();
			Assert.assertEquals(addToCardButtonText, "ADDED TO CART", "Button text is not correct.");
		}
	}
	
	public boolean isCartCounter() {
		try {
			cartCounter.isDisplayed();
			return true;
		}
		catch(Exception e){
			return false;
		}	
	}
	
//	public void addItemToCardByName1(String itemToBuy) {
//		scrollFullAction(productList, "up");
//		scrollToElementAction(itemToBuy);
//		int productCount = productsList.size();
//		System.out.println(productCount);
//		
//		for (int i=0; i<productCount; i++) {
//			String productName = productsList.get(i).getText();
//			
//			if (productName.equalsIgnoreCase(itemToBuy)) {
//				WebElement addToCardButton = driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i);
//				addToCardButton.click();
//				String addToCardButtonText = addToCardButton.getText();
//				Assert.assertEquals(addToCardButtonText, "ADDED TO CART", "Button text is not correct.");
//			}
//		}
//	}
	
//	public void addItemToCardByName1(String itemToBuy) {
//		scrollFullAction(productList, "up");
//		boolean item = scrollToElementAction1(itemToBuy);
//		System.out.println(itemToBuy + " : " + item);
//		if (item) {
//			WebElement productCard = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productName\" and @text=\"" + itemToBuy + "\"]/.."));	
//			WebElement addToCardButton = productCard.findElement(By.id("com.androidsample.generalstore:id/productAddCart"));
//			addToCardButton.click();
//			String addToCardButtonText = addToCardButton.getText();
//			Assert.assertEquals(addToCardButtonText, "ADDED TO CART", "Button text is not correct.");
//		}
//	}

}
