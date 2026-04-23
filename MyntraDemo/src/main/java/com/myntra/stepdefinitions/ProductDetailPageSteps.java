package com.myntra.stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.myntra.pages.HomePage;
import com.myntra.pages.ProductDetailPage;
import com.myntra.pages.SearchResultPage;
import static com.myntra.basetest.KeyWord.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductDetailPageSteps {

	private static final Logger LOG = LogManager.getLogger(ProductDetailPageSteps.class);
	String brandPLP;

	@Given("user is on Women Indian Fusion Wear page")
	public void userIsOnWomenIndianFusionWearPage() {

		HomePage home = new HomePage();
		home.hoverOnWomenMenu();
		home.clickIndianFusionWear();
	}

	@When("user clicks on the third product")
	public void userClicksOnThirdProduct() {

		SearchResultPage srp = new SearchResultPage();
		srp.clickProductByIndex(3);
		switchToNewWindow();
	}

	@Then("Product Detail Page should open in new window")
	public void productDetailPageShouldOpen() {
		String currentUrl = driver.getCurrentUrl();
		LOG.info("Current URL: " + currentUrl);
		Assert.assertTrue(currentUrl.contains("buy"), "Product Detail Page not opened");
	}

//	@Given("user is on Women Indian Fusion Wear page")
//	public void userIsOnWomenIndianFusionWearPage() {
//
//	    HomePage home = new HomePage();
//
//	    home.hoverOnWomenMenu();
//	    home.clickIndianFusionWear();
//	}
	@When("user captures the brand of the second product on PLP")
	public void userCapturesBrandFromPLP() {

		SearchResultPage srp = new SearchResultPage();

		brandPLP = srp.getProductBrandByIndex(2);

		LOG.info("Brand on PLP: " + brandPLP);
	}

	@When("user clicks on the second product")
	public void userClicksSecondProduct() {

		SearchResultPage srp = new SearchResultPage();

		srp.clickProductByIndex(2);

		switchToNewWindow();
	}

	@Then("same product brand should be displayed on Product Detail Page")
	public void verifySameProductBrandOnPDP() {

		ProductDetailPage pdp = new ProductDetailPage();

		String brandPDP = pdp.getProductBrand();

		LOG.info("Brand on PDP: " + brandPDP);

		Assert.assertEquals(brandPDP, brandPLP, "Different product brand displayed on PDP");
	}
}
