  package rahulshettyacademy;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;


public class IOSSwipeTest extends IOSbuildInAppsBaseTest{
	
	@Test
	public void iosSwipeTest() throws InterruptedException {
		// https://learn.microsoft.com/en-us/mem/intune/configuration/bundle-ids-built-in-ios-apps
		//https://support.apple.com/guide/deployment/bundle-ids-for-native-iphone-and-ipad-apps-depece748c41/web
		// built-in iOS "Photos" app
		launchAppAction("com.apple.mobileslideshow"); // built-in iOS "Photos" app
		
		WebElement allPhotosButton = driver.findElement(AppiumBy.iOSNsPredicateString("name=='All Photos'"));
		allPhotosButton.click();
		
		List<WebElement> photosGrid = driver.findElements(AppiumBy.iOSClassChain("**/XCUIElementTypeCell"));
		int photosCount = photosGrid.size();

		if(photosCount > 1) {
			WebElement firstPhoto = photosGrid.get(0);
			Assert.assertTrue(firstPhoto.isDisplayed());
			firstPhoto.click();
			
			// Two options - two different methods
			fullSwipeAction("left", photosCount);
			
			// these assertions could not work, if photos are made in the same minute - time stamp does not include seconds, milliseconds etc.
//			int i = 0;
//			while (i < (photosCount-1)) {
//				String previousPhotoName = driver.findElement((AppiumBy.iOSClassChain("**/XCUIElementTypeNavigationBar"))).getAttribute("name");
//				singleSwipeAction("left");
//				String currentPhotoName = driver.findElement((AppiumBy.iOSClassChain("**/XCUIElementTypeNavigationBar"))).getAttribute("name");
//				Assert.assertNotEquals(currentPhotoName, previousPhotoName);
//				i++;
//			}
		}	
		
		// two methods
		// WebElement backAllPhotosButton = driver.findElement((AppiumBy.accessibilityId("All Photos")));
		// backAllPhotosButton.click();
		driver.navigate().back();
		
		WebElement albumsButton = driver.findElement(AppiumBy.iOSNsPredicateString("name=='Albums'"));
		albumsButton.click();
		
		WebElement recentPhotos = driver.findElement(AppiumBy.accessibilityId("Recents"));
		int expectedValue = Integer.parseInt(recentPhotos.getAttribute("value").split(" ")[0]);	 // it looks like value="6 photos"	
		Assert.assertEquals(photosCount, expectedValue);
	}		
	
}

