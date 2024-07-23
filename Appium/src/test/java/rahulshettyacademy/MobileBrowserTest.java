package rahulshettyacademy;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileBrowserTest extends BrowserBaseTest{
	
	@Test
	public void browserTest() throws InterruptedException {
//		driver.get("https://google.com");
//		System.out.println("The WEB page title is: '" + driver.getTitle() + "'");
//		WebElement searchField = driver.findElement(By.name("q"));
//		searchField.sendKeys("rahul shetty academy");
//		searchField.sendKeys(Keys.ENTER);
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		
		WebElement hamburgerButton = driver.findElement(By.cssSelector(".navbar-toggler-icon"));
		hamburgerButton.click();
		
		WebElement productsLink = driver.findElement(By.cssSelector(".nav-link[routerlink='/products']"));
		productsLink.click();
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)", "");
		WebElement devopsLink = driver.findElement(By.linkText("Devops"));
		String devOpsTitle = devopsLink.getText();
		Assert.assertEquals(devOpsTitle, "Devops");
		devopsLink.click();
		
		Thread.sleep(2000);
	}

}
