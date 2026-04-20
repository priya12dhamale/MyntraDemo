package com.myntra.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.myntra.base.BaseClass;
import com.myntra.base.Keyword;
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

//	
//	WebElement productTitle;
//	
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

//	By sizeErrorMsg = By.xpath("//span[text()='Please select a size']");

	@FindBy(xpath = "//span[text()='Please select a size']")
	WebElement sizeErrorMsg;

	@FindBy(xpath = "//span[contains(@class,'pdp-price')]")
	WebElement productPrice;

	@FindBy(xpath = "//button[contains(text(),'LOGIN')]")
	WebElement loginButton;

	@FindBy(xpath = "//span[contains(text(),'WISHLIST')]")
	WebElement wishlistButton;

	public ProductDetailPage() {
		PageFactory.initElements(Keyword.driver, this);//
	}

	public void selectSize1() {
		WaitFor.elementToBeVisible(size);//
		WaitFor.elementToBeClickable(size);//
		size.click();
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

//	public void selectSize(String size) {
//
//	    By sizeOption =
//	        By.xpath("//p[text()='" + size + "']");
//
//	    WaitFor.elementToBeVisible(sizeOption);
//	    WaitFor.elementToBeClickable(sizeOption);
//
//	    driver.findElement(sizeOption).click();
//	}
	public void selectSize(String sizeValue) {

		WaitFor.visibilityOfAllElements(sizeOptions);
		// WaitFor.elementToBeClickable();

		for (WebElement size : sizeOptions) {

			// if (size.getText().equals(sizeValue)) {
			if (size.getText().trim().equalsIgnoreCase(sizeValue)) {
				WaitFor.elementToBeClickable(size);//
				size.click();
				break;

			}
		}
	}

//	public void selectSize(String sizeValue) {
//
//	    WaitFor.visibilityOfAllElements(sizeOptions);
//
//	    for (WebElement size : sizeOptions) {
//
//	        if (size.getText().equalsIgnoreCase(sizeValue)) {
//
//	            WaitFor.elementToBeClickable(size);
//
//	            Keyword.clickOnElement(size);
//
//	            System.out.println("Selected size: " + sizeValue);
//
//	            return;
//	        }
//	    }
//
//	    throw new RuntimeException("Size not available: " + sizeValue);
//	}
//	
//	
//	
	public void clickOnAddToBag() {
		WaitFor.elementToBeVisible(addToBagBtn);//
		WaitFor.elementToBeClickable(addToBagBtn);//
		addToBagBtn.click();
		Keyword.WaitForSeconds(4000);
	}

	public String getProductName() {
		WaitFor.elementToBeVisible(productName);//
		WaitFor.elementToBeClickable(productName);//
		return productName.getText();
	}

	public void clickOnGoToBag() {
		WaitFor.elementToBeVisible(goToBagButton);//
		WaitFor.elementToBeClickable(goToBagButton);//
//		 WebDriverWait wait =
//			        new WebDriverWait(driver,
//			            Duration.ofSeconds(10));
//
//			    wait.until(ExpectedConditions
//			        .visibilityOf(goToBagButton));
//
//			    wait.until(ExpectedConditions
//			        .elementToBeClickable(goToBagButton));
//			    
		// driver.executeScript("arguments[0].click();", goToBagButton);
		goToBagButton.click();
	}

//	public void clickOnBagIcon() {
//		 WebDriverWait wait =
//			        new WebDriverWait(driver,
//			            Duration.ofSeconds(20));
//
//			    wait.until(ExpectedConditions
//			        .visibilityOf(bagIcon));
//
//			    wait.until(ExpectedConditions
//			        .elementToBeClickable(bagIcon));
//			    
//			  //  driver.executeScript("arguments[0].click();", bagIcon);
//		bagIcon.click();
//	}

//	public String getSizeErrorMessage() {
//	     
//		WaitFor.elementToBeVisible(sizeErrorMsg);
//		
//		return driver.findElement(sizeErrorMsg).getText();
//	}
//	
	public void clickBagIcon() {
      WaitFor.elementToBeVisible(bagIcon);
		bagIcon.click();

	}

	public String getSizeErrorMessage() {
		WaitFor.elementToBeVisible(sizeErrorMsg);
		return sizeErrorMsg.getText();
	}

//	public String getProductFullName() {
//
//	    String brand = productBrand.getText();
//	    String title = productTitle.getText();
//
//	    return brand + " " + title;
//	}
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
