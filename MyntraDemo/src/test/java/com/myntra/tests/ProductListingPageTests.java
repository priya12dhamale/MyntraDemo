package com.myntra.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import static com.myntra.base.Keyword.*;
import com.myntra.base.BaseClass;
import com.myntra.dataprovider.DataProviderClass;
import com.myntra.pages.HomePage;
import com.myntra.pages.ProductListingPage;
import com.myntra.pages.SearchPage;
import com.myntra.pages.SearchResultPage;
import com.myntra.utils.ConfigReader;
import com.myntra.utils.WaitFor;

public class ProductListingPageTests extends BaseClass {

//	HomePage home = new HomePage();

	@Test
	public void verifyProductListingPageDisplayed() {

		HomePage home = new HomePage();

		home.hoverOnWomenMenu();

		home.clickIndianFusionWear();

		ProductListingPage plp = new ProductListingPage();

		Assert.assertTrue(plp.isProductDisplayed(), "Product Listing Page is not displayed");
	}

	@Test
	public void verifyCountOfProductInProductListingPage() {

		HomePage home = new HomePage();
		home.hoverOnWomenMenu();

		home.clickIndianFusionWear();

		ProductListingPage plp = new ProductListingPage();

		int productCount = plp.getProductCount();

		System.out.println("Product Count: " + productCount);

		Assert.assertTrue(productCount == 50, "No products displayed on Product Listing Page");
		// Assert.assertTrue(productCount > 0, "No products displayed on Product Listing
		// Page");
	}

	@Test
	public void verifyColourFilterApplied() {

		HomePage home = new HomePage();
		home.hoverOnWomenMenu();
		home.clickIndianFusionWear();
		ProductListingPage plp = new ProductListingPage();

		// int before = plp.getProductCount();
		String colour = "Black";
		plp.selectColour1(colour);
		// Get count after filter
		int after = plp.getProductCount();
//	    System.out.println("Before filter count: " + before);
//	    System.out.println("After filter count: " + after);
		Assert.assertTrue(plp.isColourFilterApplied(colour), colour + " filter is not applied");
	}

	@Test
	public void verifyCategoryFilter() {

		HomePage home = new HomePage();
		ProductListingPage plp = new ProductListingPage();

		home.hoverOnWomenMenu();

		home.clickIndianFusionWear();

		int countBefore = plp.getProductCount();

		plp.selectCategory1("Sarees");

		int countAfter = plp.getProductCount();

		System.out.println("Before: " + countBefore);
		System.out.println("After: " + countAfter);

		Assert.assertTrue(countAfter <= countBefore, "Category filter not applied");

	}

	@Test
	public void verifyProductClickNavigatesToPDP() {

		HomePage home = new HomePage();

		home.hoverOnWomenMenu();

		home.clickIndianFusionWear();

		SearchResultPage srp = new SearchResultPage();

		srp.clickOnFirstProduct1();

		switchToNewWindow();

		String currentUrl = driver.getCurrentUrl();

		System.out.println("Current URL: " + currentUrl);

		Assert.assertTrue(currentUrl.contains("/buy"), "Product Detail Page not opened");
	}

	@Test
	public void verifyClearAllFiltersFunctionality() {

		SearchPage search = new SearchPage();

		search.searchProduct("kurtas");

		ProductListingPage plp = new ProductListingPage();

		// Apply filters
		plp.selectBrand1("Biba");
		plp.selectColour1("Black");

		// Clear all filters
		plp.clearAllFilters();

		int productCountAfterClearingFilters = plp.getProductCount();

		System.out.println("product count after clearing filters: " + productCountAfterClearingFilters);

		Assert.assertTrue(productCountAfterClearingFilters > 0,
				"after click on clear filter no products are displayed ");
	}

	@Test
	public void verifyBreadcrumbNavigation() {

		HomePage home = new HomePage();
		ProductListingPage plp = new ProductListingPage();

		home.hoverOnWomenMenu();

		home.clickIndianFusionWear();

		String breadcrumbText = plp.getBreadCrumbText();

		Assert.assertTrue(breadcrumbText.toLowerCase().contains("fusion wear for women".toLowerCase()),
				"Breadcrumb navigation is incorrect");
	}

	@Test(dataProvider = "categoryData", dataProviderClass = DataProviderClass.class)
	public void verifyCategoryFilterApplied(String category) throws InterruptedException {

		driver.get(ConfigReader.getProperties("url"));

		HomePage home = new HomePage();

		home.hoverOnWomenMenu();
		home.clickIndianFusionWear();

		ProductListingPage plp = new ProductListingPage();

		plp.selectCategory1(category);

		String currentUrl = driver.getCurrentUrl();

		System.out.println("URL: " + currentUrl);

		String encodedCategory = category.replace(" ", "%20");

		Assert.assertTrue(currentUrl.toLowerCase().contains(encodedCategory.toLowerCase()), category + " filter not applied");
	}

}
