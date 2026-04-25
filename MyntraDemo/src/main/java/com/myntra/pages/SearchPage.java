package com.myntra.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myntra.base.KeyWord;
import com.myntra.utils.WaitFor;


public class SearchPage {
//search box element
	@FindBy(xpath = "//input[@placeholder=\"Search for products, brands and more\"]")
	WebElement searchBox;

	@FindBy(xpath = "//ul[contains(@class,'desktop-group')]/li")
	List<WebElement> suggestions;
	
	@FindBy(xpath = "//li[contains(@class,'product-base')]")
	List<WebElement> productcards;

	{
		PageFactory.initElements(KeyWord.driver, this); // initialization of page factory

	}

	public void enterTextInSearchBox(String text) {
		WaitFor.elementToBeVisible(searchBox);
		searchBox.sendKeys(text);
	}

	// search product and press enter using keys class from actions class
	public void searchProduct(String product) {
		WaitFor.elementToBeVisible(searchBox);
		searchBox.sendKeys(product);
		searchBox.sendKeys(Keys.ENTER);
	}

	public boolean searchBoxIsDisplayed() {
		return searchBox.isDisplayed();
	}

}
