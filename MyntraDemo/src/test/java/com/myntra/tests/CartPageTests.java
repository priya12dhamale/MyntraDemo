package com.myntra.tests;

import static com.myntra.base.KeyWord.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.myntra.base.BaseClass;

import com.myntra.pages.CartPage;
import com.myntra.pages.HomePage;
import com.myntra.pages.ProductDetailPage;
import com.myntra.pages.ProductListingPage;
import com.myntra.pages.SearchResultPage;

import org.testng.asserts.SoftAssert;

public class CartPageTests extends BaseClass {

	@Test
	public void verifyProductDisplayedInCart() {

		HomePage home = new HomePage();
		ProductListingPage plp = new ProductListingPage();
		SearchResultPage srp = new SearchResultPage();
		ProductDetailPage pdp = new ProductDetailPage();
		CartPage cart = new CartPage();

		home.hoverOnWomenMenu();

		home.clickIndianFusionWear();
		plp.selectCategory("Kurtas");

		srp.clickProductByIndex(1);

		switchToNewWindow();

		pdp.selectSize("L");
		pdp.clickOnAddToBag();
		pdp.clickOnGoToBag();

		Assert.assertTrue(cart.isProductDispayed(), "Product not displayed in cart");
	}

	@Test
	public void verifyCartPageUrlNavigation() {

		HomePage home = new HomePage();
		home.hoverOnWomenMenu();
		home.clickIndianFusionWear();
		ProductListingPage plp = new ProductListingPage();
		plp.selectCategory("Sarees");
		SearchResultPage srp = new SearchResultPage();
		srp.clickProductByIndex(2);
		switchToNewWindow();
		ProductDetailPage pdp = new ProductDetailPage();
		pdp.clickOnAddToBag();
		pdp.clickOnGoToBag();
		String currentUrl = driver.getCurrentUrl();

	
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
		plp.selectCategory("Dress Material");
		plp.selectColour("Pink");

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
	public void verifyApplyCouponButtonDisplayed() {

		SoftAssert softAssert = new SoftAssert();

		HomePage home = new HomePage();
		home.hoverOnWomenMenu();
		home.clickIndianFusionWear();

		ProductListingPage plp = new ProductListingPage();
		plp.selectCategory("Sarees");
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

		HomePage home = new HomePage();
		home.hoverOnWomenMenu();
		home.clickIndianFusionWear();
		ProductListingPage plp = new ProductListingPage();
		plp.selectCategory("Sarees");
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
        
	}

	// Negative test cases
	@Test
	public void verifyInvalidPincodeEntry_OnCartPage() {

		HomePage home = new HomePage();
		ProductListingPage plp = new ProductListingPage();
		SearchResultPage srp = new SearchResultPage();
		ProductDetailPage pdp = new ProductDetailPage();
		CartPage cart = new CartPage();

		home.hoverOnWomenMenu();
		home.clickIndianFusionWear();

		plp.selectCategory("Sarees");

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
