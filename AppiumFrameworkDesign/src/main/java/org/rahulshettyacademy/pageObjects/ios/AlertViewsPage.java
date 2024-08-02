package org.rahulshettyacademy.pageObjects.ios;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.rahulshettyacademy.pageObjects.utils.IOSActions;
import org.testng.Assert;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class AlertViewsPage extends IOSActions{
	
IOSDriver driver;
	
	public AlertViewsPage(IOSDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this); //
	}
	
	// Selectors

		@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeStaticText[`name == \"Text Entry\"`]")
		private WebElement textEntry;
		
		@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeTextField")
		private WebElement textField;
		
		@iOSXCUITFindBy(accessibility="OK")
		private WebElement okButton;
		
		@iOSXCUITFindBy(iOSNsPredicate="name == \"Confirm / Cancel\"")
		private WebElement confirmCancelButton;
		
		@iOSXCUITFindBy(iOSNsPredicate="value BEGINSWITH 'A message'")
		private WebElement message;
		
		@iOSXCUITFindBy(iOSNsPredicate="name == \"Confirm\"")
		private WebElement confirmButton;
		
		// Actions
		
		public void tapTextEntry() {
			textEntry.click();
		}
		
		public void enterText(String text) {
			textField.sendKeys(text);
		}
		
		public void tapOKButton() {
			okButton.click();
		}
		
		public void tapConfirmCancelButton() {
			confirmCancelButton.click();
		}
		
		public void verifyMessage() {
			Assert.assertTrue(message.getText().contains("short, complete sentence"));
		}
		
		public void tapConfirmButton() {
			confirmButton.click();
		}

}
