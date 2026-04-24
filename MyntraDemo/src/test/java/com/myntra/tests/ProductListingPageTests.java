package com.myntra.tests;

import static com.myntra.base.KeyWord.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.myntra.base.BaseClass;
import com.myntra.dataprovider.DataProviderClass;
import com.myntra.hooks.Hooks;
import com.myntra.pages.HomePage;
import com.myntra.pages.ProductListingPage;
import com.myntra.pages.SearchPage;
import com.myntra.pages.SearchResultPage;
import com.myntra.utils.ConfigReader;
import com.myntra.utils.WaitFor;

public class ProductListingPageTests extends BaseClass {

//	HomePage home = new HomePage();
	private static final Logger LOG = LogManager.getLogger(ProductListingPageTests.class);
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

		LOG.info("Product Count: " + productCount);

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
		plp.selectColour(colour);
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

		plp.selectCategory("Sarees");

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

		LOG.info("Current URL: " + currentUrl);

		Assert.assertTrue(currentUrl.contains("/buy"), "Product Detail Page not opened");
	}

	@Test
	public void verifyClearAllFiltersFunctionality() {

		SearchPage search = new SearchPage();

		search.searchProduct("kurtas");

		ProductListingPage plp = new ProductListingPage();

		// Apply filters
		plp.selectBrand("Biba");
		plp.selectColour("Black");

		// Clear all filters
		plp.clearAllFilters();

		int productCountAfterClearingFilters = plp.getProductCount();

		LOG.info("product count after clearing filters: " + productCountAfterClearingFilters);

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

	//	driver.get(ConfigReader.get("base.url"));

		HomePage home = new HomePage();

		home.hoverOnWomenMenu();
		home.clickIndianFusionWear();

		ProductListingPage plp = new ProductListingPage();

		plp.selectCategory(category);

		String currentUrl = driver.getCurrentUrl();

		LOG.info("URL: " + currentUrl);

		String encodedCategory = category.replace(" ", "%20");

		Assert.assertTrue(currentUrl.toLowerCase().contains(encodedCategory.toLowerCase()),
				category + " filter not applied");
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

		LOG.info("Actual Prices: " + actualPrices);

		List<Integer> sortedPrices = new ArrayList<>(actualPrices);

		Collections.sort(sortedPrices, Collections.reverseOrder());

		LOG.info("Sorted Prices: " + sortedPrices);

		Assert.assertEquals(actualPrices, sortedPrices, "Products are not sorted from High to Low");
	}

	@Test
	public void verifyScrollLoadsMoreProducts() {

		HomePage home = new HomePage();
		ProductListingPage plp = new ProductListingPage();

		home.hoverOnWomenMenu();
		home.clickWesternWear();

		int beforeScroll = plp.getProductCount();

		LOG.info("Before Scroll: " + beforeScroll);

		plp.scrollToLastProduct();

		// wait for new products to load
		// WaitFor.visibilityOfAllElements(plp.products);

		int afterScroll = plp.getProductCount();

		LOG.info("After Scroll: " + afterScroll);

		Assert.assertTrue(afterScroll >= beforeScroll, "Products did not load after scrolling");
	}

	@Test
	public void verifyClearFiltersRestoresProductList() {

		HomePage home = new HomePage();
		ProductListingPage plp = new ProductListingPage();

		home.hoverOnWomenMenu();
		home.clickIndianFusionWear();

		// Step 1 — Get initial product count
		int initialCount = plp.getProductCount();

		LOG.info("Initial Count: " + initialCount);

		// Step 2 — Apply filters
		plp.selectBrand("Biba");
		plp.selectColour("Black");

		int filteredCount = plp.getProductCount();

		LOG.info("Filtered Count: " + filteredCount);

		// Step 3 — Verify filter affected product list
		Assert.assertTrue(filteredCount <= initialCount, "Filters did not change product list");

		// Step 4 — Clear filters
		plp.clearAllFilters();

		int afterClearCount = plp.getProductCount();

		LOG.info("After Clear Count: " + afterClearCount);

		// Step 5 — Verify product list restored
		Assert.assertTrue(afterClearCount >= filteredCount, "Product list not restored after clearing filters");
	}

	@Test
	public void verifyFilterChipDisplayedAfterApplyingBrandFilter() {

		HomePage home = new HomePage();
		ProductListingPage plp = new ProductListingPage();

		home.hoverOnWomenMenu();
		home.clickIndianFusionWear();

		plp.selectBrand("Biba");

		boolean isChipDisplayed = plp.isFilterChipDisplayed("Biba");

		LOG.info("Brand chip displayed: " + isChipDisplayed);

		Assert.assertTrue(isChipDisplayed, "Brand filter chip not displayed");
	}

	@Test
	public void verifySelectingNonExistingBrandDoesNotChangeUI() {

		SoftAssert softAssert = new SoftAssert();

		HomePage home = new HomePage();
		ProductListingPage plp = new ProductListingPage();

		home.hoverOnWomenMenu();
		home.searchProduct("kurtas");

		softAssert.assertTrue(plp.isProductDisplayed(), "PLP page not displayed");

		int productCountBefore = plp.getProductCount();

		plp.selectBrand("NonExistingBrand");

		int productCountAfter = plp.getProductCount();

		softAssert.assertEquals(productCountAfter, productCountBefore,
				"Product count should remain same when brand not present");

		softAssert.assertAll();
	}
	
	

}
