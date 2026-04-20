package com.myntra.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myntra.base.Keyword;
import com.myntra.utils.WaitFor;

public class HomePage {

	// myntra logo
	@FindBy(xpath = "//a[contains(@class,'desktop-logo')]")
	WebElement myntraLogo;

	// search box
	@FindBy(xpath = "//input[@placeholder=\"Search for products, brands and more\"]")
	WebElement searchBox;

	// profile icon
	@FindBy(xpath = "//span[text()=\"Profile\"]")
	WebElement profileIcon;

	// wishlist icon
	@FindBy(xpath = "//span[text()=\"Wishlist\"]")
	WebElement wishlist;

	@FindBy(xpath = "//button[contains(text(),'LOGIN')]")
	WebElement loginButton;

	@FindBy(xpath = "//input[@type='tel']")
	WebElement mobileNumberField;

	// bag icon
	@FindBy(xpath = "//span[text()=\"Bag\"]")
	WebElement bagIcon;

	// women menu
	@FindBy(xpath = "//a[@data-group=\"women\"]")
	WebElement womenMenu;
	
	@FindBy(xpath = "//li[contains(@class,'product-base')]")
	List<WebElement> productcards;
	
	@FindBy(xpath = "//ul[contains(@class,'desktop-group')]/li")
	List<WebElement> suggestions;

	@FindBy(xpath = "//a[text()='Indian & Fusion Wear']")
	WebElement indianFusionWear;

	@FindBy(xpath = "//a[text()='Western Wear']")
	WebElement westernWear;

	@FindBy(xpath = "//a[@href='/women-jewellery']")
	WebElement jewelleryOption;
	
	

	public HomePage() {

		PageFactory.initElements(Keyword.driver, this); // initialization of page factory
	}

	public boolean myntaraLogoIsDisplayed() {
		WaitFor.elementToBeVisible(myntraLogo);
		return myntraLogo.isDisplayed();
	}

	public boolean searchBoxIsDisplayed() {
		WaitFor.elementToBeVisible(searchBox);
		return searchBox.isDisplayed();
	}

	public boolean bagIconIsDisplayed() {
		WaitFor.elementToBeVisible(bagIcon);
		return bagIcon.isDisplayed();
	}

	public boolean isWomenMenuDisplayed() {
		return womenMenu.isDisplayed();
	}

	public void hoverOnWomenMenu() {
		WaitFor.elementToBeClickable(womenMenu);
		Keyword.hover(womenMenu);
	}
	// creating the method to check the profile icon is displayed or not we using
	// wait for class to wait for
	public boolean profileIconIsDisplayed() {
		WaitFor.elementToBeVisible(profileIcon);
    	return profileIcon.isDisplayed();
	}

	public boolean wishlistIconIsDisplayed() {
		WaitFor.elementToBeVisible(wishlist);
		return wishlist.isDisplayed();
	}

	public boolean womenMenuIsDisplayed() {
		WaitFor.elementToBeVisible(womenMenu);
		return womenMenu.isDisplayed();
	}

	public void clickIndianFusionWear() {
		WaitFor.elementToBeClickable(indianFusionWear);
		indianFusionWear.click();
	}

	public void clickWesternWear() {
		WaitFor.elementToBeClickable(westernWear);
		westernWear.click();
	}

	public void clickJewelleryOption() {
		WaitFor.elementToBeClickable(jewelleryOption);
		jewelleryOption.click();
	}

//	public void clickOnWishlist() {
//
//	    WaitFor.elementToBeVisible(wishlist);
//	    WaitFor.elementToBeClickable(wishlist);
//
//	    wishlist.click();
//	}
	public boolean LoginOptionDisplayeclickingWishlist() {
		WaitFor.elementToBeVisible(mobileNumberField);
		return mobileNumberField.isDisplayed();
	}
	public void searchProduct(String product) {
		WaitFor.elementToBeVisible(searchBox);
		searchBox.sendKeys(product);
		searchBox.sendKeys(Keys.ENTER);
	}
	
	public boolean searchResultsAreDisplayed() {
		WaitFor.visibilityOfElements(productcards);
		// Check if there are any product cards displayed
		return productcards.size() > 0;

	}
	public void searchProductUsingSuggestions(String products) {
		WaitFor.elementToBeVisible(searchBox);
		searchBox.sendKeys(products);
		WaitFor.visibilityOfElements(suggestions);
		for (WebElement option : suggestions) {
			// we can find any product using suggestion by using contains method
			if (option.getText().toLowerCase().contains(products.toLowerCase())) {

				option.click();
				break;
			}
		}

	}

}
