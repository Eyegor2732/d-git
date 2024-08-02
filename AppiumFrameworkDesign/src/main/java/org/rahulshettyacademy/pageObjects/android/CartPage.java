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

public class CartPage extends AndroidActions{
	
AndroidDriver driver;
	
	public CartPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this); 		
	}
	
	// Selectors
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
	private List<WebElement> pricesInCart;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement totalPurchaseAmount;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/termsButton")
	private WebElement termsButton;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/alertTitle")
	private WebElement termsAlertTitle;
	
	@AndroidFindBy(id="android:id/button1")
	private WebElement alertCloseButton;
	
	@AndroidFindBy(className="android.widget.CheckBox")
	private WebElement sendMeCheckBox;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")
	private WebElement completePurchaseButton;
	
	// Actions
	private double sumItemPricesInCart() {
		double sum = 0;
		for (WebElement item: pricesInCart) {
			sum = sum + getDoubleAmount(item.getText());
		}
		
		return sum;
	}
	
	private double totalPurchaseAmountNumber() {
		return getDoubleAmount(totalPurchaseAmount.getText());
	}
	
	public void verifyPurchaseAmount() {
		Assert.assertEquals(totalPurchaseAmountNumber(), sumItemPricesInCart(), "Cart total price is incorrect.");
	}
	
	public void longPressTermsButton() {
		longPressAction(termsButton);
	}
	
	public void verifyTermsAlertTitle() {
		String actualAlertTitle = termsAlertTitle.getText();
		Assert.assertEquals(actualAlertTitle, "Terms Of Conditions");
	}
	
	public void closeTermsAlert() {
		alertCloseButton.click();
	}
	
	public void selectSendMeEmail() {
		if (!sendMeCheckBox.isSelected()) {
			sendMeCheckBox.click();
		}
	}
	
	public void completePurchase() {
		completePurchaseButton.click();
		driver.navigate().back();
	}

}
