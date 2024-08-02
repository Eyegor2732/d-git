package org.rahulshettyacademy;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import org.rahulshettyacademy.pageObjects.android.ProductCatalog;

import java.io.IOException;

import org.rahulshettyacademy.pageObjects.android.CartPage;


public class eCommerce_tc_4_local_DF extends AndroidBaseTest{
	
//	@Test()
//	public void fillFormTest() {
//	formPage.setCountrySelection("Argentina");
//	formPage.setInputNameField("Eyegor");
//	formPage.selectGender("female");
	
	@Test(dataProvider="getData")

	public void fillFormTest(String country, String name, String gender) {
//		System.out.println("user.dir = " + System.getProperty("user.dir"));
		formPage.setCountrySelection(country);
		formPage.setInputNameField(name);
		formPage.selectGender(gender);
		ProductCatalog productCatalog = formPage.clickLetsShopButton();
		
		productCatalog.addItemToCardByIndex(0);
		productCatalog.addItemToCardByIndex(0);
		CartPage cartPage = productCatalog.goToCart();
		
		cartPage.verifyPurchaseAmount();
		cartPage.longPressTermsButton();
		cartPage.verifyTermsAlertTitle();
		cartPage.closeTermsAlert();
		cartPage.selectSendMeEmail();
		cartPage.completePurchase();
	}

	@DataProvider
	public Object[][] getData() throws IOException {
		//each set initiate new test run
		return new Object[][] {{"Burundi", "Sarah", "female"}, {"Australia", "Crocodile Dandy", "male"}};
	}
}
