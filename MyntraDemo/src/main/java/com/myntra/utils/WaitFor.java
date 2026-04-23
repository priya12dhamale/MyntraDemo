package com.myntra.utils;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.myntra.basetest.KeyWord;

public class WaitFor {
	/*
	 * here we are creating the object of WebDriverWait class and we are using
	 * static block because we want to initialize the wait object only once and we
	 * can use it in all the methods of this class
	 */

	static WebDriverWait wait;

	static {

		wait = new WebDriverWait(KeyWord.driver, Duration.ofSeconds(30));

		wait.pollingEvery(Duration.ofMillis(500));
		wait.ignoring(NoSuchElementException.class);

	}

	/*
	 * here we declare constructor because no one can create object of this class
	 * and directly use the method using class name
	 */
	private WaitFor() {

	}

	public static void elementToBeVisible(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	// wait till the WebElement is visible
	public static WebElement elementToBeVisible(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	// wait for element to be clickable using locator
	public static void elementToBeClickable(By locator) {
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

//	// wait till WebElement is clickable
//	public static WebElement elementToBeClickable(WebElement element) {
//		return wait.until(ExpectedConditions.elementToBeClickable(element));
//	}

	// wait for element to be selected using locator
	public static void elementToBeSelected(By locator) {
		wait.until(ExpectedConditions.elementToBeSelected(locator));
	}

	// wait till WebElement is selected
	public static Boolean elementToBeSelected(WebElement element) {
		return wait.until(ExpectedConditions.elementToBeSelected(element));

	}

	// wait for the presence of element using locator
	public static void visibilityOfElements(List<WebElement> elements) {
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));

	}
//	public static WebElement elementToBeVisible(By locator) {
//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	// return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//	}

	public static void numberOfElementsToBeMoreThan(By locator, int count) {
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, count));
	}

	public static void visibilityOfAllElements(List<WebElement> sizeOptions) {
		wait.until(ExpectedConditions.visibilityOfAllElements(sizeOptions));

	}

	public static void elementToBeVisible(List<WebElement> colorOptions) {
		wait.until(ExpectedConditions.visibilityOfAllElements(colorOptions));

	}

	public static void elementToBeClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

}
