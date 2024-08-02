package rahulshettyacademy;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {

	public AndroidDriver driver;
//	public AppiumDriverLocalService service;
//	public WebDriverWait wait;
	
//	private String apkPath = "D:\\git\\d-git-appium-java\\Appium\\src\\test\\java\\resources\\ApiDemos-debug.apk";
//	private String appPackage = "io.appium.android.apis";
	
	private String apkPath = "/Users/michaels-mac-mini/Desktop/rahul/d-git-appium-java/Appium/src/test/java/resources/ApiDemos-debug.apk";	
	private String appPackage = "io.appium.android.apis";
	
//	private String apkPath = "/Users/michaels-mac-mini/Desktop/rahul/d-git-appium-java/Appium/src/test/java/resources/General-Store.apk";	
//	private String appPackage = "com.androidsample.generalstore";
	
	private String chromeDriverPath = "/Users/michaels-mac-mini/Desktop/rahul/d-git-appium-java/Appium/src/test/java/resources/chromedriver";
	
	
	@BeforeClass
	public void configureAppium() throws MalformedURLException, URISyntaxException {
//		File mainJsFile = new File(
//				"C:\\Users\\koval\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");
//		service = new AppiumServiceBuilder().withAppiumJS(mainJsFile).withIPAddress("127.0.0.1").usingPort(4723)
//				.build();
//		service.start();

		// Set UiAutomator2 Options2
		UiAutomator2Options options = new UiAutomator2Options();
		options.setChromedriverExecutable(chromeDriverPath);
		options.setDeviceName("Pixel 2 API 35"); // optional - emulator
		options.setPlatformName("Android");
		options.setNoReset(true);
		options.setEventTimings(true);
		options.setApp(apkPath);

		driver = new AndroidDriver(new URI("http://127.0.0.1:4723/").toURL(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}

	public void longPressAction(WebElement ele) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "duration", 2000));
	}

	public void scrollToEndAction() {
		boolean canScrollMore;
		do {
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap
					.of("left", 100, "top", 100, "width", 200, "height", 200, 
							"direction", "down", 
							"percent", 3.0
							));
		} while (canScrollMore);
	}
	
	public void scrollFullAction(WebElement ele, String direction) {
		boolean canScrollMore;
		do {
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap
					.of(
							"elementId", ele, 
							"direction", direction, 
							"percent", 3.0
							));
		} while (canScrollMore);
	}

	public void scrollToElementAction(String title) {
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector())"
						+ ".scrollIntoView(text(\"" + title + "\"));"));

	}
	
	public void swipeAction(WebElement ele, String direction, double percent) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", 
				ImmutableMap.of(
						"elementId", ((RemoteWebElement) ele).getId(),
						"direction", direction, 
						"percent", percent
						));
	}
	
	public void dragDropAction(WebElement ele, int endX, int endY) {
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) ele).getId(),
			    "endX", endX,
			    "endY", endY
			));
	}
	
	public void appPackageActivityAction(String appPackage, String appActivity) {
		((JavascriptExecutor) driver).executeScript("mobile: startActivity",
				ImmutableMap.of(
						"intent", appPackage + "/" + appActivity
						));
	}
	
	public void appPackageActivityAction1(String appPackageActivity) {
		((JavascriptExecutor) driver).executeScript("mobile: startActivity",
				ImmutableMap.of(
						"intent", appPackageActivity
						));
	}
	
	// Convert String value, like "$120.0" to Double value 120.0
	public Double getDoubleAmount(String amount) {
		return Double.parseDouble(amount.substring(1));
	}
	
	// Convert String value, like "$120.0" to Double value 120.0
		public int getIntegerAmount(String amount) {
			return Integer.parseInt(amount.substring(1));
		}
	
	@AfterClass
	public void tearDown() {
		driver.terminateApp(appPackage);
		driver.quit();
//		service.stop();
	}

}
