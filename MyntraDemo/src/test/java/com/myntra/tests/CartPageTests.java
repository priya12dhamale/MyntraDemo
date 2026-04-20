package com.myntra.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.myntra.pages.CartPage;
import com.myntra.pages.HomePage;
import com.myntra.pages.ProductDetailPage;
import com.myntra.pages.ProductListingPage;
import com.myntra.pages.SearchResultPage;
import static com.myntra.base.Keyword.*;
import org.testng.asserts.SoftAssert;

public class CartPageTests extends Test1 {

	// Test case to verify that the product is added to the cart successfully

	@Test
	public void verifyProductDisplayedInCart() {

		// Create page objects
		HomePage home = new HomePage();
		ProductListingPage plp = new ProductListingPage();
		SearchResultPage srp = new SearchResultPage();
		ProductDetailPage pdp = new ProductDetailPage();
		CartPage cart = new CartPage();

		// Step 1: Hover Women menu
		home.hoverOnWomenMenu();

		// Step 2: Click Indian Fusion Wear
		home.clickIndianFusionWear();

		// Step 3: Select category
		plp.selectCategory1("Kurtas");

		// Step 4: Click first product
		srp.clickProductByIndex(1);

		// Step 5: Switch to new window
		switchToNewWindow();

		// Step 6: Select size
		pdp.selectSize("XL");
		pdp.clickOnAddToBag();
		pdp.clickBagIcon();
		// Step 9: Verify product displayed in cart
		Assert.assertTrue(cart.isProductDispayed(), "Product not displayed in cart");
	}

	@Test
	public void verifyCartPageUrlNavigation() {

		HomePage home = new HomePage();
		home.hoverOnWomenMenu();
		home.clickIndianFusionWear();
		ProductListingPage plp = new ProductListingPage();
		plp.selectCategory1("Sarees");
		SearchResultPage srp = new SearchResultPage();
		srp.clickProductByIndex(2);
		switchToNewWindow();
		ProductDetailPage pdp = new ProductDetailPage();
		pdp.clickOnAddToBag();
		pdp.clickOnGoToBag();
		String currentUrl = driver.getCurrentUrl();

		// Assert.assertTrue(currentUrl.contains("/checkout/cart"), "Cart page not
		// opened");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(currentUrl.contains("/checkout/cart"), "Cart page URL not correct");

		String title = driver.getTitle();
		softAssert.assertTrue(title.contains("SHOPPING BAG"), "Cart page title not correct");
		softAssert.assertAll();
	}

	@Test
	public void verifyPlaceOrderButtonDisplayed_whenCartHasItems() {

		HomePage home = new HomePage();
		home.hoverOnWomenMenu();
		home.clickIndianFusionWear();

		ProductListingPage plp = new ProductListingPage();
		plp.selectCategory1("Dress Material");
		plp.selectColour1("Pink");

		SearchResultPage srp = new SearchResultPage();
		srp.clickProductByIndex(1);

		switchToNewWindow();

		ProductDetailPage pdp = new ProductDetailPage();
		pdp.clickOnAddToBag();
		pdp.clickOnGoToBag();

		CartPage cart = new CartPage();

		Assert.assertTrue(cart.isPlaceOrderButtonDisplayed(), "Place Order button not displayed in cart");
	}

	@Test
	public void verifyEmptyCartMessageDisplayed_directCartNavigation() {

		driver.get("https://www.myntra.com/checkout/cart");

		CartPage cart = new CartPage();

		Assert.assertTrue(cart.isEmptyCartMessageDisplayed(),
				"Empty cart message not displayed when navigating directly to cart");

	}

	@Test
	public void verifyApplyCouponButtonDisplayed_usingDiscountFilter() {

		SoftAssert softAssert = new SoftAssert();

		HomePage home = new HomePage();
		home.hoverOnWomenMenu();
		home.clickIndianFusionWear();

		ProductListingPage plp = new ProductListingPage();
		plp.selectCategory1("Sarees");
		// Apply Discount filter
		plp.selectDiscount("40% and above");

		SearchResultPage srp = new SearchResultPage();
		srp.clickProductByIndex(1);

		switchToNewWindow();

		ProductDetailPage pdp = new ProductDetailPage();
		pdp.clickOnAddToBag();
		pdp.clickOnGoToBag();

		CartPage cart = new CartPage();

		softAssert.assertTrue(cart.isApplyCouponButtonDisplayed(), "Apply Coupon button not displayed");

		softAssert.assertAll();
	}

	@Test
	public void verifyRemoveProductFromCart() {

		// SoftAssert softAssert = new SoftAssert();
		HomePage home = new HomePage();
		home.hoverOnWomenMenu();
		home.clickIndianFusionWear();
		ProductListingPage plp = new ProductListingPage();
		plp.selectCategory1("Sarees");
		SearchResultPage srp = new SearchResultPage();
		srp.clickProductByIndex(1);
		switchToNewWindow();
		ProductDetailPage pdp = new ProductDetailPage();
		pdp.clickOnAddToBag();
		pdp.clickOnGoToBag();
		CartPage cart = new CartPage();
		cart.clickRemoveButton();
		cart.confirmRemoveProduct();

		Assert.assertTrue(cart.isEmptyCartMessageDisplayed(), "Product not removed from cart");
//		softAssert.assertTrue(cart.EmptyCartMsgafterRemoveCartFromBag(), "Product not removed from cart");
//
//		softAssert.assertAll();
	}

	@Test
	public void verifyInvalidPincodeEntry_OnCartPage() {

		HomePage home = new HomePage();
		ProductListingPage plp = new ProductListingPage();
		SearchResultPage srp = new SearchResultPage();
		ProductDetailPage pdp = new ProductDetailPage();
		CartPage cart = new CartPage();

		home.hoverOnWomenMenu();
		home.clickIndianFusionWear();

		plp.selectCategory1("Sarees");

		srp.clickProductByIndex(1);

		switchToNewWindow();

		pdp.clickOnAddToBag();
		pdp.clickOnGoToBag();

		cart.clickEnterPinCode();

		cart.enterPincode("000000");

		cart.clickCheckButton();

		Assert.assertTrue(cart.isErrorMessageDisplayed(), "Error message not displayed for invalid pincode");
	}
}
