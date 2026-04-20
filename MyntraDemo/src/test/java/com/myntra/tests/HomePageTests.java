package com.myntra.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.myntra.base.BaseClass;
import com.myntra.pages.HomePage;
import com.myntra.pages.ProductListingPage;
import com.myntra.pages.SearchPage;
import com.myntra.pages.SearchResultPage;
import com.myntra.utils.ConfigReader;
import static com.myntra.base.Keyword.*;

public class HomePageTests extends BaseClass {

	@Test
	public void verifyHomePageLoadsSuccessfully() {

		driver.get(ConfigReader.getProperties("url"));
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("myntra"), "Home page not loaded");
	}

	@Test
	public void verifyWomenMenuDisplayed() {

		HomePage home = new HomePage();
		Assert.assertTrue(home.isWomenMenuDisplayed(), "Women menu is not displayed");
	}

	@Test
	public void verifyWomenSectionNavigation() {

		HomePage home = new HomePage();
		home.hoverOnWomenMenu();
		home.clickIndianFusionWear();
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("fusion-wear"), "Women section not opened");
	}

	@Test
	public void verifyLogoIsDisplayed() {

		HomePage home = new HomePage();
		Assert.assertTrue(home.myntaraLogoIsDisplayed(), "Logo is not displayed on Home Page");
	}

	@Test
	public void verifyUserCanSearchProduct() {

		HomePage home = new HomePage();
		home.searchProduct("Kurta");
		Assert.assertTrue(home.searchResultsAreDisplayed(), "Text is not entered in search box");
	}

	@Test
	public void verifySearchUsingSuggestions() {

		HomePage home = new HomePage();
		ProductListingPage plp = new ProductListingPage();
		// String product = "Women Top";
		home.searchProductUsingSuggestions("Women Top");
		Assert.assertTrue(plp.getLastBreadcrumbText().toLowerCase().contains("Women Top".toLowerCase()),
				"Search did not navigate to correct PLP page");
	}

	@Test
	public void verifyWishlistAccessWithoutLogin() {

		HomePage home = new HomePage();
		home.wishlistIconIsDisplayed();
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("login"), "User not redirected to login page");
	}

	@Test
	public void verifySearchUsingRandomNumber() {
		HomePage home = new HomePage();
		home.searchProduct("123456789");
		SearchResultPage srp = new SearchResultPage();
		Assert.assertTrue(srp.noResultsMessageIsDisplayed(), "No results message is not displayed");
	}

	@Test
	public void verifySearchWithEmptyInput() {

		HomePage home = new HomePage();

		home.searchProduct("");

		String currentUrl = driver.getCurrentUrl();

		Assert.assertTrue(currentUrl.contains("myntra"), "Search executed with empty input");
	}



}
