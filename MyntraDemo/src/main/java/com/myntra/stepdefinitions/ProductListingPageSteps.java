package com.myntra.stepdefinitions;

import static com.myntra.base.KeyWord.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.myntra.pages.HomePage;
import com.myntra.pages.ProductListingPage;
import com.myntra.pages.SearchResultPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductListingPageSteps {

	private static final Logger LOG = LogManager.getLogger(ProductListingPageSteps.class);

	HomePage home = new HomePage();
	ProductListingPage plp = new ProductListingPage();

	int countBefore;
	int countAfter;

	// COMMON STEPS 

	@Given("User is on Myntra home page")
	public void user_is_on_home_page() {
		LOG.info("User is on Myntra Home Page");
	}

	@When("user hovers on Women menu")
	public void user_hovers_on_women_menu() {
		home.hoverOnWomenMenu();
	}

	@When("user clicks on Indian Fusion Wear category")
	public void user_clicks_on_indian_fusion_wear_category() {
		home.clickIndianFusionWear();
	}


	@Then("product listing page should be displayed")
	public void product_listing_page_should_be_displayed() {
		Assert.assertTrue(plp.isProductDisplayed());
	}


	@When("User notes the product count before applying category filter")
	public void get_product_count_before_filter() {
		countBefore = plp.getProductCount();
	}

	@When("User selects category filter {string}")
	public void select_category_filter(String category) {
		plp.selectCategory(category);
	}

	@Then("Product count should be updated after applying category filter")
	public void verify_product_count_after_filter() {
		countAfter = plp.getProductCount();
		Assert.assertTrue(countAfter <= countBefore);
	}


	@When("user apply brand filter")
	public void user_apply_brand_filter() {
		plp.selectBrand("Biba");
	}

	@Then("only selected brand products should be displayed")
	public void verify_brand_filter() {
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.toLowerCase().contains("biba"));
	}

	// ---------- TC 4 : PRODUCT COUNT ----------

	@Then("user should see {int} products on Product Listing Page")
	public void verify_product_count(int expectedCount) {
		int productCount = plp.getProductCount();
		Assert.assertEquals(productCount, expectedCount);
	}

	@When("user clicks on the first product")
	public void user_clicks_on_the_first_product() {

		SearchResultPage srp = new SearchResultPage();
		srp.clickOnFirstProduct1();
	}

	@When("user switches to the new window")
	public void user_switches_to_the_new_window() {

		switchToNewWindow();
	}

	@Then("user should be navigated to Product Detail Page")
	public void user_should_be_navigated_to_product_detail_page() {

		String currentUrl = driver.getCurrentUrl();

		LOG.info("Current URL: " + currentUrl);

		Assert.assertTrue(currentUrl.contains("/buy"), "Product Detail Page not opened");
	}
	
	@When("user applies brand filter {string}")
	public void user_applies_brand_filter(String brand) {

	    ProductListingPage plp = new ProductListingPage();

	    plp.selectBrand(brand);
	}
	@Then("only selected brand {string} products should be displayed")
	public void only_selected_brand_products_should_be_displayed(String brand) {

	    ProductListingPage plp = new ProductListingPage();

	    boolean isDisplayed = plp.verifyProductsBelongToBrand(brand);

	    Assert.assertTrue(
	            isDisplayed,
	            "Products from selected brand are not displayed correctly"
	    );
	}
}
