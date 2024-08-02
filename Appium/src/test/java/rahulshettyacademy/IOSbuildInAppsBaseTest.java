package rahulshettyacademy;

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
import org.testng.annotations.AfterClass;

public class IOSbuildInAppsBaseTest {

    public IOSDriver driver;
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
        //options.setApp("/Users/michaels-mac-mini/Desktop/rahul/ios-uicatalog-master/UIKitCatalog.app");
        options.setPlatformVersion("17.5");
        options.setWdaLaunchTimeout(Duration.ofSeconds(20));
        options.setShouldTerminateApp(true);

        driver = new IOSDriver(new URI("http://127.0.0.1:4723/").toURL(), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
    
    // without element id it will be swiped by center of the screen
    public void fullSwipeAction(String direction, int listsize) {
    	Map<String, Object> params = new HashMap<>();
	    params.put("direction", direction);
	    int i = 0;
	    while(i < listsize) {
	    	driver.executeScript("mobile:swipe", params);
	    	i++;
	    }
	}
    
    public void singleSwipeAction(String direction) {
    	Map<String, Object> params = new HashMap<>();
	    params.put("direction", direction);
	    driver.executeScript("mobile:swipe", params);
	}

    @AfterClass
    public void tearDown() {
        driver.quit();
//        service.stop();
//        System.out.println ("Service Running: " + service.isRunning());
    }

}
