package org.rahulshettyacademy;

import org.testng.annotations.Test;

import org.rahulshettyacademy.pageObjects.android.ProductCatalog;

import org.rahulshettyacademy.pageObjects.android.CartPage;


public class eCommerce_tc_4_my extends AndroidBaseTest{
	

	
	@Test()
	public void fillFormTest() {
	formPage.setCountrySelection("Argentina");
	formPage.setInputNameField("Eyegor");
	formPage.selectGender("female");
		ProductCatalog productCatalog = formPage.clickLetsShopButton();
		
//		productCatalog.addItemToCardByIndex(0);
//		productCatalog.addItemToCardByIndex(0);
		productCatalog.addItemToCardByName2("Air Jordan 9 Retro");
		productCatalog.addItemToCardByName2("PG 3");
		CartPage cartPage = productCatalog.goToCart();
		if (productCatalog.isCartCounter()) {
			cartPage.verifyPurchaseAmount();
			cartPage.longPressTermsButton();
			cartPage.verifyTermsAlertTitle();
			cartPage.closeTermsAlert();
			cartPage.selectSendMeEmail();
			cartPage.completePurchase();
		}
		
	}
}
