package rahulshettyacademy;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URISyntaxException;
import java.time.Duration;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class IOSBaseTest {

    public IOSDriver driver;
    public AppiumDriverLocalService service;

    @BeforeClass
    public void configureAppium() throws MalformedURLException, URISyntaxException {
        File mainJsFile = new File(
                "/Users/eyegor/node_modules/appium/build/lib/main.js");
        service = new AppiumServiceBuilder().withAppiumJS(mainJsFile).withIPAddress("127.0.0.1").usingPort(4723)
                .build();
        service.start();
        System.out.println ("Service Running: " + service.isRunning());

        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName("iPhone 15 Pro");
        options.setApp("/Users/eyegor/Desktop/UIKitCatalog.app");
        options.setPlatformVersion("17.4");
        options.setWdaLaunchTimeout(Duration.ofSeconds(20));

        driver = new IOSDriver(new URI("http://127.0.0.1:4723/").toURL(), options);
//        driver = new IOSDriver(new URL("http://127.0.0.1:4723/"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        service.stop();
        System.out.println ("Service Running: " + service.isRunning());
    }

}
