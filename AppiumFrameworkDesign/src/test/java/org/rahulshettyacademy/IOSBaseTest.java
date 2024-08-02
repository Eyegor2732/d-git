package org.rahulshettyacademy;

import org.testng.annotations.BeforeClass;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.rahulshettyacademy.pageObjects.ios.HomePage;
import org.testng.annotations.AfterClass;

public class IOSBaseTest {

    public IOSDriver driver;
    public HomePage homePage;
    // to finde bundleID in terminal, using full path
    // osascript -e 'id of app "[.app file name with path]"'
    private String bundleID = "com.example.apple-samplecode.UICatalog";
    private String appPath = "/Users/michaels-mac-mini/Desktop/rahul/ios-uicatalog-master/UIKitCatalog.app";
//    public AppiumDriverLocalService service;


    @BeforeClass
    public void configureAppium() throws MalformedURLException, URISyntaxException {
//        File mainJsFile = new File(
//                "/Users/eyegor/node_modules/appium/build/lib/main.js");
//        service = new AppiumServiceBuilder().withAppiumJS(mainJsFile).withIPAddress("127.0.0.1").usingPort(4723)
//                .build();
    	
//    	AppiumServiceBuilder builder = new AppiumServiceBuilder();
//        builder.withIPAddress("127.0.0.1");
//        builder.usingPort(4723);

//    	service = AppiumDriverLocalService.buildService(builder);
//        service.start();
//        System.out.println ("Service Running: " + service.isRunning());

        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName("iPhone 15 Pro");
        options.setApp(appPath);
        options.setPlatformVersion("17.5");
        options.setWdaLaunchTimeout(Duration.ofSeconds(20));

        driver = new IOSDriver(new URI("http://127.0.0.1:4723/").toURL(), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        homePage = new HomePage(driver);
    }
    
    
    
    public void touchAndHoldAction(WebElement element, int duration) {
    	Map<String, Object> params = new HashMap<>();
	    params.put("element", ((RemoteWebElement) element).getId());
	    params.put("duration", duration);
	    driver.executeScript("mobile:touchAndHold", params);
	}
    
    public void scrollToElementAction(WebElement element, String direction) {
    	Map<String, Object> params = new HashMap<>();
	    params.put("element", ((RemoteWebElement) element).getId());
	    params.put("direction", direction);
	    driver.executeScript("mobile:scroll", params);
	}
    
    public void launchAppAction(String bundleId) {
    	Map<String, String> params = new HashMap<>();
	    params.put("bundleId", bundleId);
	    driver.executeScript("mobile:launchApp", params);
	}

	@AfterClass
    public void tearDown() {
    	driver.terminateApp(bundleID);
        driver.quit();
//        service.stop();
//        System.out.println ("Service Running: " + service.isRunning());
    }

}
