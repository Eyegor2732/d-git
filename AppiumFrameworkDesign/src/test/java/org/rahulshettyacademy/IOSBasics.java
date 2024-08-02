package org.rahulshettyacademy;

import org.testng.annotations.Test;
import org.rahulshettyacademy.pageObjects.ios.AlertViewsPage;
import org.testng.annotations.Test;


public class IOSBasics extends IOSBaseTest{
	
	@Test
	public void iOSBasicsTest() throws InterruptedException {
		
		AlertViewsPage alertViewsPage = homePage.tapAlertViews();
		
		alertViewsPage.tapTextEntry();
		alertViewsPage.enterText("Hello World");
		alertViewsPage.tapOKButton();
		alertViewsPage.tapConfirmCancelButton();
		alertViewsPage.verifyMessage();
		alertViewsPage.tapConfirmButton();
		
	}
}
