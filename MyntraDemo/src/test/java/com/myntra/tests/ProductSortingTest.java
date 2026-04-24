package com.myntra.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.myntra.base.BaseClass;
import com.myntra.pages.HomePage;
import com.myntra.pages.ProductListingPage;
import com.myntra.utils.WaitFor;

public class ProductSortingTest extends BaseClass {

	@Test
	public void verifyProductSortingLowToHigh() throws InterruptedException {
		HomePage home = new HomePage();
		ProductListingPage plp = new ProductListingPage();

		home.hoverOnWomenMenu();
		home.clickWesternWear();

		plp.selectCategory("Top");
		plp.selectBrand("H&M");

		plp.selectPriceLowToHigh();
		// WaitFor.visibilityOfAllElements(plp.productPrices);
	//	Thread.sleep(2000);
		List<Integer> actualPrices = plp.getProductPrices();
		System.out.println("Actual Prices: " + actualPrices);
		List<Integer> sortedPrices = new ArrayList<>(actualPrices);

		Collections.sort(sortedPrices);

		System.out.println("Sorted Prices: " + sortedPrices);

		Assert.assertEquals(actualPrices, sortedPrices);
	}

	@Test
	public void verifyProductSortingHighToLow() throws InterruptedException {

		HomePage home = new HomePage();
		ProductListingPage plp = new ProductListingPage();

		home.hoverOnWomenMenu();
		home.clickWesternWear();

		plp.selectCategory("Top");
		plp.selectBrand("Roadster");

		plp.selectPriceHighToLow();
		Thread.sleep(2000);
		// WaitFor.visibilityOfAllElements(productPrices);
		List<Integer> actualPrices = plp.getProductPrices();

		System.out.println("Actual Prices: " + actualPrices);

		List<Integer> sortedPrices = new ArrayList<>(actualPrices);

		Collections.sort(sortedPrices, Collections.reverseOrder());

		System.out.println("Sorted Prices: " + sortedPrices);

		Assert.assertEquals(actualPrices, sortedPrices, "Products are not sorted from High to Low");
	}
	
	
}
