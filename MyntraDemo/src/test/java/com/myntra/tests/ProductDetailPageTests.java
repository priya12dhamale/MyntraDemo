package com.myntra.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.myntra.base.BaseClass;
import com.myntra.pages.HomePage;
import com.myntra.pages.ProductDetailPage;
import com.myntra.pages.ProductListingPage;
import com.myntra.pages.SearchResultPage;
import static com.myntra.base.Keyword.*;

public class ProductDetailPageTests extends BaseClass {

	@Test(groups = "smoke")
	public void verifyProductDetailPageOpens() {

		HomePage home = new HomePage();

		home.hoverOnWomenMenu();
		home.clickIndianFusionWear();

		SearchResultPage srp = new SearchResultPage();
		// Step 2 — Click Product
		srp.clickProductByIndex(3);

		switchToNewWindow();

		String currentUrl = driver.getCurrentUrl();

		System.out.println("Current URL: " + currentUrl);

		Assert.assertTrue(currentUrl.contains("buy"), "Product Detail Page not opened");
	}

	@Test(groups = "regression")
	public void verifySameProductDisplayedOnPDP() {

		HomePage home = new HomePage();

		home.hoverOnWomenMenu();
		home.clickIndianFusionWear();

		SearchResultPage srp = new SearchResultPage();

		int index = 2;

		String brandPLP = srp.getProductBrandByIndex(index);

		System.out.println("Brand on PLP: " + brandPLP);

		srp.clickProductByIndex(index);

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

		home.hoverOnWomenMenu();
		home.clickIndianFusionWear();

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
		plp.selectCategory1("Kurtas");

		SearchResultPage srp = new SearchResultPage();

		srp.clickProductByIndex(1);

		switchToNewWindow();

		ProductDetailPage pdp = new ProductDetailPage();

		String size = "M";

		// Step 1 — Select size
		pdp.selectSize(size);

		// Step 2 — Click Add to Bag
		pdp.clickOnAddToBag();

		// Step 3 Validate
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
		plp.selectCategory1("Jeggings");

		SearchResultPage srp = new SearchResultPage();

		srp.clickProductByIndex(1);

		switchToNewWindow();

		ProductDetailPage pdp = new ProductDetailPage();

		String size = "40";

		// Step 1 — Select size
		pdp.selectSize(size);

		// Step 2 — Click Add to Bag
		pdp.clickOnAddToBag();

		// Step 3 — Verify product added
		boolean isAdded = pdp.isProductAddedToBag();

		System.out.println("Product added: " + isAdded);

		// Assert.assertTrue(isAdded, "Product was not added to bag");
		Assert.assertTrue(pdp.isGoToBagButtonDisplayed(), "Product was not added to bag");
	}

	@Test(groups = "regression")
	public void verifyWithoutLoginClickingWishlistItRedirectsToLoginPage() {

		HomePage home = new HomePage();

		home.hoverOnWomenMenu();
		home.clickIndianFusionWear();

		ProductListingPage plp = new ProductListingPage();
		plp.selectCategory1("Kurtas");

		SearchResultPage srp = new SearchResultPage();

		srp.clickProductByIndex(1);

		switchToNewWindow();

		ProductDetailPage pdp = new ProductDetailPage();

		// FIX: click from PDP
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
		// ProductDetailPage pdp = new ProductDetailPage();
		home.hoverOnWomenMenu();
		home.clickIndianFusionWear();

		plp.selectCategory1("Kurta Sets");

		plp.selectColour1("Yellow");

//	srp.clickProductByIndex(2);
		// srp.clickProduct(2);
		// srp.clickOnFirstProduct();
		srp.clickProductByIndex(1);
		switchToNewWindow();

		ProductDetailPage pdp = new ProductDetailPage();

		pdp.clickOnAddToBag();

		String actuallMsg = pdp.getSizeErrorMessage();
		System.out.println(actuallMsg);
		String expectedMsg = "Please select a size";
		Assert.assertEquals(actuallMsg, expectedMsg, "Size error message is not displayed correctly");
	}

}
