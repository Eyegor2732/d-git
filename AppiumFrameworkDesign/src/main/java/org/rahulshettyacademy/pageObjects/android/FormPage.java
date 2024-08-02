package org.rahulshettyacademy.pageObjects.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.rahulshettyacademy.pageObjects.utils.AndroidActions;
import org.testng.Assert;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage extends AndroidActions{
	
	AndroidDriver driver;
	
	public FormPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this); //
	}
	
	// Selectors
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/spinnerCountry")
	private WebElement dropdownArrow;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement inputNameField;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioFemale")
	private WebElement femaleRadioButton;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioMale")
	private WebElement maleRadioButton;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement letsShopButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Products']")
	private WebElement productsPageTitle;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/rvProductList")
	private WebElement productList;
	
//	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
//	private WebElement cartButton;
	
	// Actions
	
	public void setCountrySelection(String country) {
		dropdownArrow.click();
		scrollToElementAction(country);
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"" + country + "\")")).click();
	}
	
	public void setInputNameField(String name) {
		inputNameField.sendKeys(name);
		driver.hideKeyboard();
		Assert.assertTrue(inputNameField.getText().equals(name), "Wrong name is shown");
	}
	
	public void selectGender(String gender) {
		if(gender.toLowerCase().contains("female")) {
			String checkedAttribute = femaleRadioButton.getAttribute("checked");
			if (checkedAttribute.equals("false")) {
				femaleRadioButton.click();
			}
		}
		else {
			String checkedAttribute = maleRadioButton.getAttribute("checked");
			if (checkedAttribute.equals("false")) {
				maleRadioButton.click();
			}
		}
	}
	
	public ProductCatalog clickLetsShopButton() {
		letsShopButton.click();
		return (new ProductCatalog(driver));
	}
	
//	public void cartButton() {
//		cartButton.click();
//	}

}
