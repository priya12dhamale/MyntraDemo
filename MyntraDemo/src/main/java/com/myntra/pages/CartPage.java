package com.myntra.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myntra.base.Keyword;
import com.myntra.utils.WaitFor;

public class CartPage {

	@FindBy(xpath = "//div[contains(@class,'itemContainer')]")
	WebElement cartProduct;

	//@FindBy(xpath = "//span[text()='PLACE ORDER']")
	@FindBy(xpath="//div[text()=\"PLACE ORDER\"]")
	WebElement placeOrderButton;
	
	@FindBy(xpath = "//div[contains(text(),'There is nothing in your bag')]")
	WebElement emptyCartMessage;
	
	@FindBy(xpath="//button[@font-size=\"body3\"]")
	WebElement applyButton;
	
//	@FindBy(xpath = "//span[contains(text(),'Apply Coupons')]")
//	WebElement applyCouponsLink;
	
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

		PageFactory.initElements(Keyword.driver, this);
	}
	
	public boolean isProductDispayed() {
		WaitFor.elementToBeVisible(cartProduct);//
		return cartProduct.isDisplayed();
	}
	
	public boolean isPlaceOrderButtonDisplayed() {
	    return placeOrderButton.isDisplayed();
	}
	public boolean isEmptyCartMessageDisplayed() {
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

	  //  waitForVisibility(enterPinCodeButton);
	    enterPinCodeButton.click();
	}
	
	public void enterPincode(String pincode) {

	//    waitForVisibility(pincodeInput);

	    pincodeInput.clear();
	    pincodeInput.sendKeys(pincode);
	}
	
	public void clickCheckButton() {

	  //  waitForVisibility(checkButton);
	    checkButton.click();
	}
	
	public boolean isErrorMessageDisplayed() {

	  //  waitForVisibility(errorMessage);
	    return errorMessage.isDisplayed();
	}
//	public void enterPincode(String pincode) {
//
//	    pincodeInput.clear();
//	    pincodeInput.sendKeys(pincode);
//
//	    checkButton.click();
//	}
	
//	public boolean isInvalidPincodeMessageDisplayed() {
//
//	    return invalidPincodeMessage.isDisplayed();
//	}
}