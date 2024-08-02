package org.rahulshettyacademy.pageObjects.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.opentelemetry.sdk.metrics.data.Data;

import com.fasterxml.jackson.core.type.*;

public class AppiumUtils {
//	AppiumDriver driver;
	
//	public AppiumUtils(AppiumDriver driver) {
//		this.driver = driver;
//	}

	// Convert String value, like "$120.0" to Double value 120.0
	public Double getDoubleAmount(String amount) {
		return Double.parseDouble(amount.substring(1));
	}

	// Convert String value, like "$120.0" to Double value 120.0
	public int getIntegerAmount(String amount) {
		return Integer.parseInt(amount.substring(1));
	}
	
//	private WebDriverWait webDriverWaitSettings(int seconds) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
//		return wait;
//	}
	
	private WebDriverWait webDriverWaitSettings(int seconds, AppiumDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		return wait;
	}
	
	public void waitForElementToAppear(WebElement element, int seconds, String attribute, String value, AppiumDriver driver) {
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		WebDriverWait wait =  webDriverWaitSettings(seconds, driver);
		wait.until(ExpectedConditions.attributeContains((element), attribute, value));
		//wait = null;
	}
	
	// for stale elements
	public void waitForInvisibilityOfElementLocated(By locator, int seconds, AppiumDriver driver) {
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebDriverWait wait =  webDriverWaitSettings(seconds, driver);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
		//wait = null;
	}
	
	public void waitForInvisibilityOfElementLocated(AppiumBy locator, int seconds, AppiumDriver driver) {
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebDriverWait wait =  webDriverWaitSettings(seconds, driver);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
		//wait = null;
	}
	
	public List<HashMap<String, String>> getJsonData(String jsonFilePath) throws IOException {
		// converts JSON file content to JSON string
		String jsonContent = FileUtils.readFileToString(new File(jsonFilePath), StandardCharsets.UTF_8);
		
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {		
				});
		return data;
	}
	
//	public void appPackageActivityAction(String appPackage, String appActivity) {
//		((JavascriptExecutor) driver).executeScript("mobile: startActivity",
//				ImmutableMap.of(
//						"intent", appPackage + "/" + appActivity
//						));
//	}
//	
//	public void appPackageActivityAction1(String appPackageActivity) {
//		((JavascriptExecutor) driver).executeScript("mobile: startActivity",
//				ImmutableMap.of(
//						"intent", appPackageActivity
//						));
//	}

}
