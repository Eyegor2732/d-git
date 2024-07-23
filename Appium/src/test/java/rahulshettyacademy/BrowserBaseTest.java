package rahulshettyacademy;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BrowserBaseTest {

	public AndroidDriver driver;
	public AppiumDriverLocalService service;

	private String chromeDriverPath = "D:\\git\\d-git-appium-java\\Appium\\src\\test\\java\\resources\\chromedriver.exe";
	
	
	@BeforeClass
	public void configureAppium() throws MalformedURLException, URISyntaxException {
		File mainJsFile = new File(
				"C:\\Users\\koval\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");
		service = new AppiumServiceBuilder().withAppiumJS(mainJsFile).withIPAddress("127.0.0.1").usingPort(4723)
				.build();
		service.start();

		// Set UiAutomator2 Options
		UiAutomator2Options options = new UiAutomator2Options();
		options.setChromedriverExecutable(chromeDriverPath);
		options.setDeviceName("Pixel 2 API 35"); // optional - emulator
//		options.setPlatformName("Android");
//		options.setNoReset(true);
//		options.setEventTimings(true);
		options.setCapability("browserName", "Chrome");

		driver = new AndroidDriver(new URI("http://127.0.0.1:4723/").toURL(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
		driver.quit();
		service.stop();
	}

}
