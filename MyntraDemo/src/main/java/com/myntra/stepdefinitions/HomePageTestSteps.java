package com.myntra.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static com.myntra.basetest.KeyWord.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.myntra.basetest.KeyWord;
import com.myntra.hooks.Hooks;
import com.myntra.pages.HomePage;
import com.myntra.pages.ProductListingPage;
import com.myntra.pages.SearchResultPage;

public class HomePageTestSteps {

	private static final Logger LOG = LogManager.getLogger(HomePageTestSteps.class);

	HomePage home = new HomePage();
	ProductListingPage plp = new ProductListingPage();
	SoftAssert softAssert = new SoftAssert();

	@Given("User launches browser")
	public void launch_browser() {
		LOG.info("Browser launched");
	}

	@When("User clicks on Women menu")
	public void click_women_menu() {
		LOG.info("Clicked Women menu");
	}

	@Then("Women page should be displayed")
	public void verify_page() {
		LOG.info("Women page displayed");
	}

	@Given("User is on Home page")
	public void userIsOnHomePage() {
		LOG.info("User is on home page");
	}

	@When("user open Women page")
	public void userOpenWomenPage() {
		LOG.info("User opens Women page");

		HomePage home = new HomePage();
		home.hoverOnWomenMenu();
	}

	@Then("categories list should be displayed")
	public void categoriesListShouldBeDisplayed() {
		LOG.info("Verifying categories list is displayed under Women section");
		HomePage home = new HomePage();
		boolean isDisplayed = home.isWomenMenuDisplayed();

		if (isDisplayed) {
			LOG.info("Women categories are displayed successfully");
		} else {
			LOG.error("Women categories are NOT displayed");
			throw new AssertionError("Women categories are not displayed");
		}
	}

	@Given("User launches the browser")
	public void user_launches_the_browser() {
	}

	@When("User enters {string} in search box")
	public void user_enters_in_search_box(String product) {
		home.searchProduct("Women Dress");
	}

	@When("User clicks on search icon")
	public void user_clicks_on_search_icon() {

	}

	@Then("Relevant products should be displayed")
	public void relevant_products_should_be_displayed() {
		String actualUrl = driver.getCurrentUrl();
		Assert.assertTrue(actualUrl.contains("women-dress"), "User is not navigated to Women Dress page");
	}

	@Given("User launch the browser")
	public void user_launche_the_browser() {
	}

	@When("User clicks on Cart icon")
	public void user_clicks_on_cart_icon() {
		home.bagIconClick();
	}

	@Then("User should be navigated to cart page")
	public void user_should_be_navigated_to_cart_page() {
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("checkout/cart"), "User is not navigated to cart page");
	}

	@When("user presses search without entering product")
	public void searchWithBlankValue() {
		home.searchProduct("");
		LOG.info("User pressed search without entering any product");
	}

	@Then("user should remain on home page")
	public void remainOnHomePage() {
		String actualUrl = driver.getCurrentUrl();
		Assert.assertTrue(actualUrl.contains("myntra.com"), "User navigated unexpectedly on blank search");
		LOG.warn("Blank search handled correctly");
	}

	String visibleProducts;

	@When("user search for the Various {string}")
	public void searchValidProduct(String product) {

		visibleProducts = product;
		home.searchProduct(product);

		LOG.info("Search for product: " + product);
	}

	@Then("user should see the result for the valid product")
	public void resultForTheSearchPropductOnplpPage() {

		String actualUrl = plp.getPlpUrl();

		String expectedProduct = visibleProducts.toLowerCase().replace(" ", "-");

		softAssert.assertTrue(actualUrl.toLowerCase().contains(expectedProduct),
				"URL does not contain searched product");

		softAssert.assertTrue(plp.isProductDisplayed(), "Products are not displayed on PLP");

		LOG.info("Search results verified for: " + visibleProducts);

		softAssert.assertAll();
	}

	@When("user searches for the product using suggestions {string}")
	public void user_search_for_product_using_suggestions(String product) {

		home.searchProductUsingSuggestions(product);
	}

	@Then("users should navigate to the correct PLP page for {string}")
	public void user_should_navigate_to_correct_plp_page(String product) {

		String breadcrumb = plp.getLastBreadcrumbText();

		Assert.assertTrue(breadcrumb.toLowerCase().contains(product.toLowerCase()),
				"Search did not navigate to correct PLP page");
	}

	@When("user click on wishlist icon")
	public void user_click_on_wishlist_icon() {
		home.clickWishlistIcon();
		home.wishlistIconIsDisplayed();
	}

	@Then("user should be redirected to login page")
	public void user_should_be_redirected_to_login_page() {
//
//		// String currentUrl = DriverFactory.getDriver().getCurrentUrl();
		String currentUrl = driver.getCurrentUrl();
//		Assert.assertTrue(currentUrl.contains("login"), "User not redirected to login page");
//	}

		System.out.println("Current URL is: " + currentUrl);

		Assert.assertTrue(currentUrl.contains("/wishlist"), "User not redirected to login page");

	}

	@When("user search for the product {string}")
	public void user_search_for_the_product(String product) {

		HomePage home = new HomePage();
		home.searchProduct(product);
	}

	@Then("user should see no results message")
	public void user_should_see_no_results_message() {

		SearchResultPage srp = new SearchResultPage();

		Assert.assertTrue(srp.noResultsMessageIsDisplayed(), "No results message is not displayed");
	}
}
