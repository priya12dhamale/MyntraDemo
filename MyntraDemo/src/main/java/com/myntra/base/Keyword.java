package com.myntra.base;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.exceptions.InvalidBrowserNameExc;
import com.myntra.utils.ConfigReader;
import com.myntra.utils.WaitFor;

public class KeyWord {

	/*
	 * here we declare all the methods as static because we can directly call the
	 * method using class name and no need to create object of this class
	 */
	static public RemoteWebDriver driver;
	static String browser = ConfigReader.get("browser");

	public static void openBrowser() {

		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			throw new InvalidBrowserNameExc();
		}
		driver.manage().window().maximize();
	}

	public static void launchUrl() {

		String url = ConfigReader.get("base.url");
		driver.get(url);
	}

	public static void closeBrowser() {
		
		driver.quit();

	}

	/*
	 * here we are using if else to find the element using different locator type
	 * and then we are sending the text to that element
	 */
	public static void enterText(String locatorType, String locatorValue, String textToEnter) {

		if (locatorType.equalsIgnoreCase("id")) {
			driver.findElement(By.id(locatorValue)).sendKeys(textToEnter);
		} else if (locatorType.equalsIgnoreCase("name")) {
			driver.findElement(By.name(locatorValue)).sendKeys(textToEnter);

		} else if (locatorType.equalsIgnoreCase("classname")) {
			driver.findElement(By.className(locatorValue)).sendKeys(textToEnter);

		} else if (locatorType.equalsIgnoreCase("cssselector")) {
			driver.findElement(By.cssSelector(locatorValue)).sendKeys(textToEnter);
		} else if (locatorType.equalsIgnoreCase("xpath")) {
			driver.findElement(By.xpath(locatorValue)).sendKeys(textToEnter);
		} else if (locatorType.equalsIgnoreCase("tagname")) {
			driver.findElement(By.tagName(locatorValue)).sendKeys(textToEnter);
		} else if (locatorType.equalsIgnoreCase("partiallinktext")) {
			driver.findElement(By.partialLinkText(locatorValue)).sendKeys(textToEnter);
		} else {

			throw new RuntimeException("invalid locator type" + locatorType);
		}
	}

	// this method is used to click on element
	public static void click(String locatorType, String locatorValue) {
		if (locatorType.equalsIgnoreCase("id")) {
			driver.findElement(By.id(locatorValue)).click();
		} else if (locatorType.equalsIgnoreCase("name")) {
			driver.findElement(By.name(locatorValue)).click();

		} else if (locatorType.equalsIgnoreCase("classname")) {
			driver.findElement(By.className(locatorValue)).click();

		} else if (locatorType.equalsIgnoreCase("cssselector")) {
			driver.findElement(By.cssSelector(locatorValue)).click();
		} else if (locatorType.equalsIgnoreCase("xpath")) {
			driver.findElement(By.xpath(locatorValue)).click();
		} else if (locatorType.equalsIgnoreCase("tagname")) {
			driver.findElement(By.tagName(locatorValue)).click();
		} else if (locatorType.equalsIgnoreCase("linktext")) {
			driver.findElement(By.linkText(locatorValue)).click();
		} else if (locatorType.equalsIgnoreCase("partiallinktext")) {
			driver.findElement(By.partialLinkText(locatorValue)).click();
		} else {

			throw new RuntimeException("invalid locator type" + locatorType);
		}

	}

	public static void hover(String locatorType, String locatorValue) {

		WebElement element = null;
		if (locatorType.equalsIgnoreCase("xpath")) {
			element = driver.findElement(By.xpath(locatorValue));
		} else if (locatorType.equalsIgnoreCase("id")) {
			element = driver.findElement(By.id(locatorValue));
		} else {
			throw new RuntimeException("invalid locator type" + locatorType);
		}
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}

	public static void hover(WebElement womenMenu) {
		Actions action = new Actions(driver);
		action.moveToElement(womenMenu).perform();

	}

	public static void switchToNewWindow() {
		Set<String> win = driver.getWindowHandles();
		for (String windows : win) {
			driver.switchTo().window(windows);
		}
	}

	public static void clickOnElement(WebElement element) {
		WaitFor.elementToBeClickable(element);
		element.click();
	}

	public static void WaitForSeconds(int miliseconds) {
		try {
			Thread.sleep(miliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void scrollToElement(WebElement element) {
		driver.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public static void clickOn(WebElement element) {
		WaitFor.elementToBeClickable(element);
		element.click();
	}
}
