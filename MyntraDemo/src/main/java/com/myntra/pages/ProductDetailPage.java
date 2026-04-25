package com.myntra.pages;

import static com.myntra.base.KeyWord.*;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.myntra.base.BaseClass;
import com.myntra.base.KeyWord;
import com.myntra.utils.WaitFor;

public class ProductDetailPage extends BaseClass {

	// size locator
	@FindBy(xpath = "//p[text()=\"30\"]")
	WebElement size;

//	@FindBy(xpath = "//div[contains(@class,'size-buttons')]//p")
//	List<WebElement> sizeOptions;

	@FindBy(xpath = "//p[contains(@class,'size')]") //
	List<WebElement> sizeOptions;

	// @FindBy(xpath="//span[text()=\"ADD TO BAG\"]")
	@FindBy(xpath = "//div[contains(@class,\"pdp-add-to-bag pdp-button\")]")
	WebElement addToBagBtn;

	@FindBy(xpath = "//h1[@class=\"pdp-name\"]")
	WebElement productName;

	@FindBy(xpath = "//h1/preceding-sibling::h1")
	WebElement productBrand;
//	

	// @FindBy(xpath = "(//h1)[1]")
	// WebElement productBrand;

	@FindBy(xpath = "(//h1)[2]")
	WebElement productTitle;

	@FindBy(xpath = "//span[contains(text(),'GO TO BAG')]")
	WebElement goToBagButton;

	@FindBy(xpath = "(//a[contains(@href,'checkout/cart')])[1]")
	WebElement bagIcon;

	@FindBy(xpath = "//span[text()='Please select a size']")
	WebElement sizeErrorMsg;

	@FindBy(xpath = "//span[contains(@class,'pdp-price')]")
	WebElement productPrice;

	@FindBy(xpath = "//button[contains(text(),'LOGIN')]")
	WebElement loginButton;

	@FindBy(xpath = "//span[contains(text(),'WISHLIST')]")
	WebElement wishlistButton;
	
	@FindBy(xpath = "//input[@placeholder=\"Enter pincode\"]")
	WebElement pincodeTextbox;

	@FindBy(xpath = "//input[@value=\"Check\"]")
	WebElement checkButton;

	@FindBy(xpath = "//p[@class=\"pincode-error pincode-enterPincode\"]")
	WebElement invalidPinMessage;
	
	@FindBy(xpath = "//button[text()='Change']")
	WebElement changePincodeButton;

	public ProductDetailPage() {
		PageFactory.initElements(KeyWord.driver, this);
	}
	
	public boolean isChangeButtonDisplayed() {

	    WaitFor.elementToBeVisible(changePincodeButton);

	    return changePincodeButton.isDisplayed();
	}

	public void enterPincode(String pin) {

		WaitFor.elementToBeVisible(pincodeTextbox);
		WaitFor.elementToBeClickable(pincodeTextbox);

		pincodeTextbox.clear();
		pincodeTextbox.sendKeys(pin);
	}

	public void clickOnCheckButton() {

		WaitFor.elementToBeVisible(checkButton);
		WaitFor.elementToBeClickable(checkButton);

		checkButton.click();
	}

	public String getInvalidPinMessage() {

		WaitFor.elementToBeVisible(invalidPinMessage);
		return invalidPinMessage.getText();
	}


	public boolean isInvalidPinMessageDisplayed() {

		try {
			WaitFor.elementToBeVisible(invalidPinMessage); 
			return invalidPinMessage.isDisplayed();

		} catch (Exception e) {

			return false;
		}
	}

	public boolean isSizeSelectionSuccessful() {

		try {
			if (sizeErrorMsg.isDisplayed()) {
				return false; // error message visible
			}
		} catch (Exception e) {
			return true; // error message not found
		}

		return true;
	}

	public boolean isSizeSelected(String expectedSize) {

		WaitFor.visibilityOfAllElements(sizeOptions);

		for (WebElement size : sizeOptions) {

			if (size.getText().trim().equalsIgnoreCase(expectedSize)) {

				String classValue = size.getAttribute("class");

				System.out.println("Class value: " + classValue);

				return classValue.contains("selected");
			}
		}
		return false;
	}

	public void selectSize(String sizeValue) {

		WaitFor.visibilityOfAllElements(sizeOptions);

		for (WebElement size : sizeOptions) {

			// if (size.getText().equals(sizeValue)) {
			if (size.getText().trim().equalsIgnoreCase(sizeValue)) {
				WaitFor.elementToBeClickable(size);
				size.click();
				break;

			}
		}
	}

	public void clickOnAddToBag() {
		WaitFor.elementToBeVisible(addToBagBtn);
		WaitFor.elementToBeClickable(addToBagBtn);
		addToBagBtn.click();
		KeyWord.WaitForSeconds(4000);
	}

	public String getProductName() {
		WaitFor.elementToBeVisible(productName);
		WaitFor.elementToBeClickable(productName);
		return productName.getText();
	}

	public void clickOnGoToBag() {
		WaitFor.elementToBeVisible(goToBagButton);
		WaitFor.elementToBeClickable(goToBagButton);

		goToBagButton.click();
	}
	
	public void clickBagIcon() {
		WaitFor.elementToBeVisible(bagIcon);
		bagIcon.click();

	}

	public String getSizeErrorMessage() {
		WaitFor.elementToBeVisible(sizeErrorMsg);
		return sizeErrorMsg.getText();
	}


	public String getProductBrand() {
		return productBrand.getText();
	}

	public boolean isProductPriceDisplayed() {

		WaitFor.elementToBeVisible(productPrice);

		return productPrice.isDisplayed();
	}

	public int getSizeOptionsCount() {

		WaitFor.visibilityOfAllElements(sizeOptions);

		return sizeOptions.size();
	}

	public boolean areSizeOptionsDisplayed() {

		WaitFor.visibilityOfAllElements(sizeOptions);

		return sizeOptions.size() > 0;
	}

	public boolean isProductAddedToBag() {

		WaitFor.elementToBeVisible(goToBagButton);

		return goToBagButton.isDisplayed();
	}

	public boolean isGoToBagButtonDisplayed() {

		WaitFor.elementToBeVisible(goToBagButton);

		return goToBagButton.isDisplayed();
	}

	public boolean isLoginPageDisplayed() {

		WaitFor.elementToBeVisible(loginButton);

		return loginButton.isDisplayed();
	}

	public void clickOnWishlist() {

		WaitFor.elementToBeVisible(wishlistButton);
		WaitFor.elementToBeClickable(wishlistButton);

		wishlistButton.click();
	}

}
