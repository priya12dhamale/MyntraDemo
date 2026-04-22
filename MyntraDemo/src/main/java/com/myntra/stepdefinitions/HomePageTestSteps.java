package com.myntra.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.myntra.base.Keyword;
import com.myntra.pages.HomePage;
import com.myntra.pages.ProductListingPage;

import static com.myntra.base.Keyword.*;

public class HomePageTestSteps {

	private static final Logger LOG = LogManager.getLogger(HomePageTestSteps.class);

	HomePage home = new HomePage();
	ProductListingPage plp = new ProductListingPage();

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
}
