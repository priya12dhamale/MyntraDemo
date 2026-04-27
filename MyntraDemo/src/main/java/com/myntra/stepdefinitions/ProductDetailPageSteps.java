package com.myntra.stepdefinitions;

import static com.myntra.base.KeyWord.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.myntra.pages.CartPage;
import com.myntra.pages.HomePage;
import com.myntra.pages.ProductDetailPage;
import com.myntra.pages.ProductListingPage;
import com.myntra.pages.SearchResultPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductDetailPageSteps {

	private static final Logger LOG = LogManager.getLogger(ProductDetailPageSteps.class);
	String brandPLP;

	@Given("user is on Women Indian Fusion Wear page")
	public void userIsOnWomenIndianFusionWearPage() {

		HomePage home = new HomePage();
		home.hoverOnWomenMenu();
		home.clickIndianFusionWear();
	}

	@When("user clicks on the third product")
	public void ClicksOnThirdProduct() {

		SearchResultPage srp = new SearchResultPage();
		srp.clickProductByIndex(3);
		switchToNewWindow();
	}

	@Then("Product Detail Page should open in new window")
	public void productDetailPageShouldOpen() {
		String currentUrl = driver.getCurrentUrl();
		LOG.info("Current URL: " + currentUrl);
		Assert.assertTrue(currentUrl.contains("buy"), "Product Detail Page not opened");
	}

//	@Given("user is on Women Indian Fusion Wear page")
//	public void userIsOnWomenIndianFusionWearPage() {
//
//	    HomePage home = new HomePage();
//
//	    home.hoverOnWomenMenu();
//	    home.clickIndianFusionWear();
//	}
	@When("user captures the brand of the second product on PLP")
	public void CapturesBrandFromPLP() {

		SearchResultPage srp = new SearchResultPage();

		brandPLP = srp.getProductBrandByIndex(2);

		LOG.info("Brand on PLP: " + brandPLP);
	}

	@When("user clicks on the second product")
	public void ClicksSecondProduct() {

		SearchResultPage srp = new SearchResultPage();

		srp.clickProductByIndex(2);

		switchToNewWindow();
	}

	@Then("same product brand should be displayed on Product Detail Page")
	public void verifySameProductBrandOnPDP() {

		ProductDetailPage pdp = new ProductDetailPage();

		String brandPDP = pdp.getProductBrand();

		LOG.info("Brand on PDP: " + brandPDP);

		Assert.assertEquals(brandPDP, brandPLP, "Different product brand displayed on PDP");
	}

	@Given("user navigates to Women Indian Fusion Wear category")
	public void userIsOnIndianFusionWear() {

		HomePage home = new HomePage();

		home.hoverOnWomenMenu();
		home.clickIndianFusionWear();
	}

	@When("user clicks on the first product from search results")
	public void clicksOnTheFirstProductFromSearchResults() {

		SearchResultPage srp = new SearchResultPage();

		srp.clickProductByIndex(1);

		switchToNewWindow();
	}

	@Then("product price should be displayed on Product Detail Page")
	public void productPriceShouldBeDisplayedOnPdp() {

		ProductDetailPage pdp = new ProductDetailPage();

		boolean isPriceDisplayed = pdp.isProductPriceDisplayed();

		System.out.println("Price displayed: " + isPriceDisplayed);

		Assert.assertTrue(isPriceDisplayed, "Product price is not displayed on PDP");
	}

	@Then("different size options should be displayed on Product Detail Page")
	public void sizeOptionsShouldBeDisplayedOnPdp() {

		ProductDetailPage pdp = new ProductDetailPage();

		boolean sizesDisplayed = pdp.areSizeOptionsDisplayed();

		System.out.println("Number of sizes: " + pdp.getSizeOptionsCount());

		Assert.assertTrue(sizesDisplayed, "Size options are not displayed on PDP");
	}

	@Given("user selects category {string}")
	public void selectCategoryFromFilter(String category) {

		ProductListingPage plp = new ProductListingPage();

		plp.selectCategory("Kurtas");
	}

	@When("user clicks the first product from search results")
	public void clickFirstProductFromSearchResults() {

		SearchResultPage srp = new SearchResultPage();

		srp.clickProductByIndex(1);

		switchToNewWindow();
	}

	@When("user selects size {string}")
	public void selectSizeOnProduct(String size) {

		ProductDetailPage pdp = new ProductDetailPage();

		pdp.selectSize("M");
	}

	@When("user clicks on Add to Bag button")
	public void clickAddToBagButton() {

		ProductDetailPage pdp = new ProductDetailPage();

		pdp.clickOnAddToBag();
	}

	@Then("size selection should be successful")
	public void sizeSelectionShouldBeSuccessful() {

		ProductDetailPage pdp = new ProductDetailPage();

		boolean isSelected = pdp.isSizeSelectionSuccessful();

		System.out.println("Size selection successful: " + isSelected);

		Assert.assertTrue(isSelected, "Size was not selected");
	}

	@Given("user select category {string}")
	public void selectCategoryFromTheFilter(String category) {

		ProductListingPage plp = new ProductListingPage();

		plp.selectCategory(category);
	}

	@When("user click on the first product from search results")
	public void clickOnFirstProductFromSearchResults() {

		SearchResultPage srp = new SearchResultPage();

		srp.clickProductByIndex(1);

		switchToNewWindow();
	}

	@When("user select size {string}")
	public void selectSizeProduct(String size) {

		ProductDetailPage pdp = new ProductDetailPage();

		pdp.selectSize(size);
	}

	@When("user clicks Add to Bag button")
	public void clicksAddToBagButton() {

		ProductDetailPage pdp = new ProductDetailPage();

		pdp.clickOnAddToBag();
	}

	@Then("product should be added to bag successfully")
	public void productShouldBeAddedToBagSuccessfully() {

		ProductDetailPage pdp = new ProductDetailPage();

		boolean isAdded = pdp.isProductAddedToBag();

		System.out.println("Product added: " + isAdded);

		Assert.assertTrue(pdp.isGoToBagButtonDisplayed(), "Product was not added to bag");
	}

	@Given("user select category {string} PDP")
	public void selectCategoryPDP(String category) {

		ProductListingPage plp = new ProductListingPage();
		plp.selectCategory(category);

	}

	@When("user click on the first product from search results PDP")
	public void clickFirstProductPDP() {

		SearchResultPage srp = new SearchResultPage();
		srp.clickProductByIndex(1);
		switchToNewWindow();

	}

	@When("user select size {string} PDP")
	public void selectSizePDP(String size) {

		ProductDetailPage pdp = new ProductDetailPage();
		pdp.selectSize(size);

	}

	@When("user clicks Add to Bag button PDP")
	public void clickAddToBagPDP() {

		ProductDetailPage pdp = new ProductDetailPage();
		pdp.clickOnAddToBag();

	}

	@Then("product should be added to bag successfully PDP")
	public void verifyProductAddedPDP() {

		ProductDetailPage pdp = new ProductDetailPage();

		Assert.assertTrue(pdp.isGoToBagButtonDisplayed(), "Product was not added to bag");

	}

	@Given("user opens any product detail page")
	public void userOpensAnyProductDetailPage() {

		HomePage home = new HomePage();
		SearchResultPage srp = new SearchResultPage();

		home.hoverOnWomenMenu();
		home.clickIndianFusionWear();

		srp.clickProductByIndex(1);

		switchToNewWindow();
	}

	@When("user provides invalid pincode {string}")
	public void userProvidesInvalidPincode(String invalidPin) {

		ProductDetailPage pdp = new ProductDetailPage();

		pdp.enterPincode(invalidPin);
	}

	@When("user taps on Check availability button")
	public void userTapsOnCheckAvailabilityButton() {

		ProductDetailPage pdp = new ProductDetailPage();

		pdp.clickOnCheckButton();
	}

	@Then("invalid pincode warning message should appear")
	public void invalidPincodeWarningMessageShouldAppear() {

		ProductDetailPage pdp = new ProductDetailPage();

		Assert.assertTrue(pdp.isInvalidPinMessageDisplayed(), "Invalid pincode error message should be displayed");
	}

	@Given("shopper lands on a product detail screen")
	public void shopperLandsOnProductDetailScreen() {

		HomePage home = new HomePage();
		SearchResultPage srp = new SearchResultPage();

		home.hoverOnWomenMenu();
		home.clickIndianFusionWear();

		srp.clickProductByIndex(1);

		switchToNewWindow();
	}

	@When("shopper submits serviceable pincode {string}")
	public void shopperSubmitsServiceablePincode(String validPin) {

		ProductDetailPage pdp = new ProductDetailPage();

		pdp.enterPincode(validPin);
	}

	@When("shopper presses Check delivery button")
	public void shopperPressesCheckDeliveryButton() {

		ProductDetailPage pdp = new ProductDetailPage();

		pdp.clickOnCheckButton();
	}

	@Then("delivery details should be visible for that pincode")
	public void deliveryDetailsShouldBeVisibleForThatPincode() {

		ProductDetailPage pdp = new ProductDetailPage();

		Assert.assertTrue(pdp.isChangeButtonDisplayed(), "Delivery information is not displayed for valid pincode");
	}

	@Then("product rating should be displayed on Product Detail Page")
	public void verifyProductRatingDisplayed() {

		ProductDetailPage pdp = new ProductDetailPage();

		Assert.assertTrue(pdp.isRatingDisplayed(), "Product rating is not displayed");
	}

	@Then("product image should be displayed on Product Detail Page")
	public void verifyProductImageDisplayedOnPdp() {

		ProductDetailPage pdp = new ProductDetailPage();

		Assert.assertTrue(pdp.isProductImageDisplayed(), "Product image is not displayed");
	}
	
	@Then("Product Details section should be displayed on Product Detail Page")
	public void verifyProductDetailsSectionDisplayed() {

	    ProductDetailPage pdp = new ProductDetailPage();

	    Assert.assertTrue(
	            pdp.isProductDetailsSectionDisplayed(),
	            "Product Details section is not displayed"
	    );
	}
}
