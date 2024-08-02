package org.rahulshettyacademy;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;


import org.rahulshettyacademy.pageObjects.android.FormPage;
import org.rahulshettyacademy.pageObjects.utils.AppiumUtils;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AndroidBaseTest extends AppiumUtils{

	public AndroidDriver driver;
	public FormPage formPage;
//	public AppiumDriverLocalService service;
//	public WebDriverWait wait;
	
//	private String apkPath = "D:\\git\\d-git-appium-java\\Appium\\src\\test\\java\\resources\\ApiDemos-debug.apk";
//	private String appPackage = "io.appium.android.apis";
	
//	private String apkPath = "/Users/michaels-mac-mini/Desktop/rahul/d-git-appium-java/Appium/src/test/java/resources/ApiDemos-debug.apk";	
//	private String appPackage = "com.androidsample.generalstore";
	
	private String apkPath = "/Users/michaels-mac-mini/Desktop/rahul/d-git-appium-java/Appium/src/test/java/resources/General-Store.apk";	
	private String appPackage = "com.androidsample.generalstore";
	
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
		formPage = new FormPage(driver);
//		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}
	
	@AfterClass
	public void tearDown() {
		driver.terminateApp(appPackage);
		driver.quit();
//		service.stop();
	}

}
