package org.rahulshettyacademy;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import org.rahulshettyacademy.pageObjects.android.ProductCatalog;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.rahulshettyacademy.pageObjects.android.CartPage;


public class eCommerce_tc_4_JSON_DF extends AndroidBaseTest{
	
	@Test(dataProvider="getData")

	public void fillFormTest(HashMap<String, String> input) {
		formPage.setCountrySelection(input.get("country"));
		formPage.setInputNameField(input.get("name"));
		formPage.selectGender(input.get("gender"));
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
		String relativePath = System.getProperty("user.dir") + "/src/test/java/org/rahulshettyacademy/testdata/eCommerce.json";
		List<HashMap<String, String>> data = getJsonData(relativePath);
		return new Object[][] {{data.get(0)}, {data.get(1)}};
	}
}
