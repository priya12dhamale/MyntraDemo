package com.myntra.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.myntra.base.BaseClass;
import com.myntra.base.Keyword;
import com.myntra.pages.CartPage;
import com.myntra.pages.HomePage;
import com.myntra.pages.ProductDetailPage;
import com.myntra.pages.ProductListingPage;
import com.myntra.pages.SearchResultPage;
import static com.myntra.base.Keyword.*;

public class EndToEndTests extends BaseClass {

	@Test
	public void verifyAddToBag() throws InterruptedException {

		HomePage home = new HomePage();
		ProductListingPage plp = new ProductListingPage();
		SearchResultPage srp = new SearchResultPage();
		ProductDetailPage pdp = new ProductDetailPage();
		CartPage cart = new CartPage();

		home.hoverOnWomenMenu();
		home.clickWesternWear();

		plp.selectCategory1("Jeans");

		plp.selectBrand1("Roadster");

		plp.selectColour1("Black");
          
		//srp.clickOnFirstProduct();
      srp.clickProductByIndex(1);
		switchToNewWindow();

		pdp.selectSize("30");

		pdp.clickOnAddToBag();

		pdp.clickOnGoToBag();

		Assert.assertTrue(cart.isProductDispayed(), "Product is not added to the cart");
	}

}
