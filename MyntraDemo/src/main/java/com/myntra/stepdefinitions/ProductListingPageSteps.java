package com.myntra.stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.myntra.pages.HomePage;
import com.myntra.pages.ProductListingPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductListingPageSteps {

	private static final Logger LOG = LogManager.getLogger(HomePageTestSteps.class);

	HomePage home = new HomePage();
	ProductListingPage plp = new ProductListingPage();

	int countBefore;
	int countAfter;

	@Given("User is on Myntra home page")
	public void user_is_on_home_page() {
		LOG.info("User is on Myntra Home Page");
	}

	@When("User hovers on Women menu")
	public void hover_on_women_menu() {
		home.hoverOnWomenMenu();
	}

	@When("User clicks on Indian Fusion Wear category")
	public void click_indian_fusion_wear() {
		home.clickIndianFusionWear();
	}

	@When("User notes the product count before applying category filter")
	public void get_product_count_before_filter() {
		countBefore = plp.getProductCount();
		LOG.info("Before: " + countBefore);
	}

	@When("User selects category filter {string}")
	public void select_category_filter(String category) {
		plp.selectCategory1("Sarees");
	}

	@Then("Product count should be updated after applying category filter")
	public void verify_product_count_after_filter() {
		countAfter = plp.getProductCount();
		LOG.info("After: " + countAfter);
		Assert.assertTrue(countAfter <= countBefore, "Category filter not applied");
	}

}
