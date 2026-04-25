package com.myntra.tests;

import static com.myntra.base.KeyWord.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.myntra.base.BaseClass;
import com.myntra.pages.HomePage;
import com.myntra.pages.ProductDetailPage;
import com.myntra.pages.ProductListingPage;
import com.myntra.pages.SearchResultPage;

public class ProductDetailPageTests extends BaseClass {

	@Test
	public void verifyProductDetailPageOpens() {

		HomePage home = new HomePage();

		home.hoverOnWomenMenu();
		home.clickIndianFusionWear();

		SearchResultPage srp = new SearchResultPage();

		srp.clickProductByIndex(3);
		switchToNewWindow();

		String currentUrl = driver.getCurrentUrl();

		System.out.println("Current URL: " + currentUrl);

		Assert.assertTrue(currentUrl.contains("buy"), "Product Detail Page not opened");
	}

	@Test
	public void verifySameProductDisplayedOnPDP() {

		HomePage home = new HomePage();

		home.hoverOnWomenMenu();
		home.clickIndianFusionWear();

		SearchResultPage srp = new SearchResultPage();

		// int index = 2;
		String brandPLP = srp.getProductBrandByIndex(2);

		System.out.println("Brand on PLP: " + brandPLP);

		srp.clickProductByIndex(2);

		switchToNewWindow();

		ProductDetailPage pdp = new ProductDetailPage();

		String brandPDP = pdp.getProductBrand();

		System.out.println("Brand on PDP: " + brandPDP);

		Assert.assertEquals(brandPDP, brandPLP, "Different product brand displayed on PDP");
	}

	@Test
	public void verifyProductPriceDisplayed() {

		HomePage home = new HomePage();

		home.hoverOnWomenMenu();
		home.clickIndianFusionWear();

		SearchResultPage srp = new SearchResultPage();

		srp.clickProductByIndex(1);

		switchToNewWindow();

		ProductDetailPage pdp = new ProductDetailPage();

		boolean isPriceDisplayed = pdp.isProductPriceDisplayed();

		System.out.println("Price displayed: " + isPriceDisplayed);

		Assert.assertTrue(isPriceDisplayed, "Product price is not displayed on PDP");

	}

	@Test
	public void verifyDifferentSizeOptionsDisplayed() {

		HomePage home = new HomePage();
		ProductListingPage plp = new ProductListingPage();
		home.hoverOnWomenMenu();
		home.clickIndianFusionWear();
		plp.selectCategory("Kurtas");

		SearchResultPage srp = new SearchResultPage();

		srp.clickProductByIndex(1);

		switchToNewWindow();

		ProductDetailPage pdp = new ProductDetailPage();

		boolean sizesDisplayed = pdp.areSizeOptionsDisplayed();

		System.out.println("Number of sizes: " + +pdp.getSizeOptionsCount());

		Assert.assertTrue(sizesDisplayed, "Size options are not displayed on PDP");
	}

	@Test
	public void verifySizeSelection() {

		HomePage home = new HomePage();

		home.hoverOnWomenMenu();
		home.clickIndianFusionWear();

		ProductListingPage plp = new ProductListingPage();
		plp.selectCategory("Kurtas");

		SearchResultPage srp = new SearchResultPage();

		srp.clickProductByIndex(1);

		switchToNewWindow();

		ProductDetailPage pdp = new ProductDetailPage();

		String size = "M";

		pdp.selectSize(size);

		pdp.clickOnAddToBag();

		boolean isSelected = pdp.isSizeSelectionSuccessful();

		System.out.println("Selected size: " + size);

		Assert.assertTrue(isSelected, "Size was not selected");
	}

	@Test
	public void verifyAddToBag() {

		HomePage home = new HomePage();

		home.hoverOnWomenMenu();
		home.clickIndianFusionWear();

		ProductListingPage plp = new ProductListingPage();
		plp.selectCategory("Jeggings");

		SearchResultPage srp = new SearchResultPage();

		srp.clickProductByIndex(1);

		switchToNewWindow();

		ProductDetailPage pdp = new ProductDetailPage();

		String size = "40";

		pdp.selectSize(size);

		pdp.clickOnAddToBag();

		boolean isAdded = pdp.isProductAddedToBag();

		System.out.println("Product added: " + isAdded);

		Assert.assertTrue(pdp.isGoToBagButtonDisplayed(), "Product was not added to bag");
	}

	@Test
	public void verifyWithoutLoginClickingWishlistItRedirectsToLoginPage() {

		HomePage home = new HomePage();

		home.hoverOnWomenMenu();
		home.clickIndianFusionWear();

		ProductListingPage plp = new ProductListingPage();
		plp.selectCategory("Kurtas");

		SearchResultPage srp = new SearchResultPage();

		srp.clickProductByIndex(1);

		switchToNewWindow();

		ProductDetailPage pdp = new ProductDetailPage();

		pdp.clickOnWishlist();
		boolean isLoginDisplayed = home.LoginOptionDisplayeclickingWishlist();

		System.out.println("Login page displayed: " + isLoginDisplayed);

		Assert.assertTrue(isLoginDisplayed, "Login page not displayed after clicking Wishlist");

	}

	@Test
	public void VerifyErrorMessageWhenSizeIsNotSelected() throws InterruptedException {

		HomePage home = new HomePage();
		ProductListingPage plp = new ProductListingPage();
		SearchResultPage srp = new SearchResultPage();

		home.hoverOnWomenMenu();
		home.clickIndianFusionWear();

		plp.selectCategory("Kurta Sets");

		plp.selectColour("Yellow");

		srp.clickProductByIndex(1);
		switchToNewWindow();

		ProductDetailPage pdp = new ProductDetailPage();

		pdp.clickOnAddToBag();

		String actuallMsg = pdp.getSizeErrorMessage();
		System.out.println(actuallMsg);
		String expectedMsg = "Please select a size";
		Assert.assertEquals(actuallMsg, expectedMsg, "Size error message is not displayed correctly");
	}

	@Test
	public void verifyInvalidPincodeErrorMessage() {

		HomePage home = new HomePage();
		ProductListingPage plp = new ProductListingPage();
		ProductDetailPage pdp = new ProductDetailPage();
		SearchResultPage srp = new SearchResultPage();
		// Step 1: Navigate to PDP
		home.hoverOnWomenMenu();
		home.clickIndianFusionWear();
		srp.clickProductByIndex(1);
		switchToNewWindow();
		
		pdp.enterPincode("123");

	
		pdp.clickOnCheckButton();
	
		Assert.assertTrue(pdp.isInvalidPinMessageDisplayed(), "Invalid pincode error message should be displayed");
	//	Assert.assertEquals(actualError, "Please enter a valid pincode",
				//"Error message is not displayed for invalid pincode");
	}

}
