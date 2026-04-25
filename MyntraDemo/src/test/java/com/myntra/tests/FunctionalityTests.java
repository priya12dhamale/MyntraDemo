package com.myntra.tests;

import static com.myntra.base.KeyWord.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.myntra.base.BaseClass;
import com.myntra.pages.CartPage;
import com.myntra.pages.HomePage;
import com.myntra.pages.ProductDetailPage;
import com.myntra.pages.ProductListingPage;
import com.myntra.pages.SearchResultPage;

public class FunctionalityTests extends BaseClass {

	@Test
	public void verifyAddToBag() throws InterruptedException {

		HomePage home = new HomePage();
		ProductListingPage plp = new ProductListingPage();
		SearchResultPage srp = new SearchResultPage();
		ProductDetailPage pdp = new ProductDetailPage();
		CartPage cart = new CartPage();
		SoftAssert softAssert = new SoftAssert();

		home.hoverOnWomenMenu();
		home.clickWesternWear();

		plp.selectCategory("Jeans");

		plp.selectBrand("Roadster");

		plp.selectColour("Black");

		plp.selectDiscount("50%");

		srp.clickProductByIndex(1);
		switchToNewWindow();

		pdp.selectSize("30");

		pdp.clickOnAddToBag();

		pdp.clickOnGoToBag();

		softAssert.assertTrue(cart.isPlaceOrderButtonDisplayed(), "Place Order button is not displayed");

		cart.clickOnPlaceOrderButton();

		softAssert.assertTrue(home.isLoginPageDisplayed(), "User is not navigated to Login page");

	}

}
