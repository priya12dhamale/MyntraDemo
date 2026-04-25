package com.myntra.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myntra.base.KeyWord;
import com.myntra.utils.WaitFor;

public class CartPage {

	@FindBy(xpath = "//div[contains(@class,'itemContainer')]")
	WebElement cartProduct;

	@FindBy(xpath = "//div[text()=\"PLACE ORDER\"]")
	WebElement placeOrderButton;

	@FindBy(xpath = "//div[@class='emptyCart-base-emptyDesc']")
	WebElement emptyCartMessage;

	@FindBy(xpath = "//button[@font-size=\"body3\"]")
	WebElement applyButton;

	@FindBy(xpath = "//*[text()='REMOVE']")
	WebElement removeButton;

	@FindBy(xpath = "//div[@role='dialog']//button[text()='REMOVE']")
	WebElement confirmRemoveButton;

	@FindBy(xpath = "//div[contains(@class,'emptyCart')]")
	WebElement emptyCartContainer;

	@FindBy(xpath = "//div[text()='ENTER PIN CODE']")
	WebElement enterPinCodeButton;

	@FindBy(xpath = "//input[@placeholder='Enter Pincode']")
	WebElement pincodeInput;

	@FindBy(xpath = "//div[text()=\"CHECK\"]")
	WebElement checkButton;

	@FindBy(xpath = "//*[contains(text(),'Something went wrong')]")
	WebElement errorMessage;

	{

		PageFactory.initElements(KeyWord.driver, this);
	}

	public boolean isProductDispayed() {
		WaitFor.elementToBeVisible(cartProduct);
		return cartProduct.isDisplayed();
	}
	
	public void clickOnPlaceOrderButton() {
		
		placeOrderButton.click();
	}

	public boolean isPlaceOrderButtonDisplayed() {
		return placeOrderButton.isDisplayed();
	}

	public boolean isEmptyCartMessageDisplayed() {
		WaitFor.elementToBeVisible(emptyCartMessage);
		return emptyCartMessage.isDisplayed();
	}

	public boolean isApplyCouponButtonDisplayed() {

		WaitFor.elementToBeVisible(applyButton);

		return applyButton.isDisplayed();
	}

	public void clickRemoveButton() {

		WaitFor.elementToBeClickable(removeButton);

		removeButton.click();

		System.out.println("Clicked Remove button");
	}

	public void confirmRemoveProduct() {

		WaitFor.elementToBeVisible(confirmRemoveButton);
		WaitFor.elementToBeClickable(confirmRemoveButton);

		confirmRemoveButton.click();

		System.out.println("Confirmed Remove");
	}

	public boolean EmptyCartMsgafterRemoveCartFromBag() {

		WaitFor.elementToBeVisible(emptyCartContainer);

		return emptyCartContainer.isDisplayed();
	}

	public void clickEnterPinCode() {

		// waitForVisibility(enterPinCodeButton);
		enterPinCodeButton.click();
	}

	public void enterPincode(String pincode) {

		// waitForVisibility(pincodeInput);
		pincodeInput.clear();
		pincodeInput.sendKeys(pincode);
	}

	public void clickCheckButton() {

		// waitForVisibility(checkButton);
		checkButton.click();
	}

	public boolean isErrorMessageDisplayed() {
		WaitFor.elementToBeVisible(errorMessage);
		// waitForVisibility(errorMessage);
		return errorMessage.isDisplayed();
	}

}