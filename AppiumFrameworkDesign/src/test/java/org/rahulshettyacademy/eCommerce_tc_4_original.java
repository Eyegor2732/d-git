package org.rahulshettyacademy;

import org.testng.annotations.Test;

import org.rahulshettyacademy.pageObjects.android.ProductCatalog;

import org.rahulshettyacademy.pageObjects.android.CartPage;


public class eCommerce_tc_4_original extends AndroidBaseTest{
	

	
	@Test()
	public void fillFormTest() {
	formPage.setCountrySelection("Argentina");
	formPage.setInputNameField("Eyegor");
	formPage.selectGender("female");
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
}
