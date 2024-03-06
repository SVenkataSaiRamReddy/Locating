//==================SOURCE CODE==============================//
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class SeleniumAutomation1 {
	public static void main(String[] args) throws IOException {
		automate();
	}
	public static void automate() throws IOException {
		int count=1;
		System.setProperty("webdriver.chrome.driver", "A:\\SELENIUM\\chromedriver.exe");
		WebDriver webDriver = new ChromeDriver();
		webDriver.manage().window().maximize();
		webDriver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
		
		webDriver.get("https://www.saucedemo.com/");
	
		WebElement eleById = webDriver.findElement(By.id("user-name"));
		eleById.sendKeys("standard_user");
		
		WebElement eleByName = webDriver.findElement(By.name("password"));
		eleByName.sendKeys("secret_sauce");
		takeScreenshot(webDriver, count++);
		WebElement eleByClass = webDriver.findElement(By.className("submit-button"));
		eleByClass.click();
		takeScreenshot(webDriver, count++);
		WebElement eleByLinkText = webDriver.findElement(By.linkText("Sauce Labs Backpack"));
		takeScreenshot(webDriver, count++);
		eleByLinkText.click();
		
		WebElement eleByXPath = webDriver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]"));
		takeScreenshot(webDriver, count++);
		eleByXPath.click();
		
		WebElement eleByCssSelector = webDriver.findElement(By.cssSelector("#remove-sauce-labs-backpack"));
		takeScreenshot(webDriver, count++);
		eleByCssSelector.click();
		webDriver.close();
		
	}
	public static void takeScreenshot(WebDriver wd, int number) throws IOException {
		File file = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
		Files.copyFile(file, new File("C:\\Users\\DELL\\OneDrive\\Pictures\\2023-04-13 (4).png\"  +number+ ".png"));
}
}