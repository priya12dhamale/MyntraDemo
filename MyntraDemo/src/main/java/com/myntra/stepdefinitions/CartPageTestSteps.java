package com.myntra.stepdefinitions;

import static com.myntra.base.KeyWord.*;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.myntra.pages.CartPage;
import com.myntra.pages.HomePage;
import com.myntra.pages.ProductDetailPage;
import com.myntra.pages.ProductListingPage;
import com.myntra.pages.SearchResultPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartPageTestSteps {

	HomePage home = new HomePage();
	ProductListingPage plp = new ProductListingPage();
	SearchResultPage srp = new SearchResultPage();
	ProductDetailPage pdp = new ProductDetailPage();
	CartPage cart = new CartPage();

	@Given("user is on home page")
	public void userIsOnHomePage() {

	}

	@When("user hover on Women menu")
	public void userHoverOnWomenMenu() {

		home.hoverOnWomenMenu();
	}

	@When("user clicks on Indian Fusion Wear")
	public void userClicksOnIndianFusionWear() {

		home.clickIndianFusionWear();
	}

	@When("user select category c {string}")
	public void user_selects_category(String category) {

		plp.selectCategory(category);
	}

	@When("user clicks product with index {int}")
	public void user_clicks_product_with_index(Integer index) {

		srp.clickProductByIndex(index);
	}

	@When("user switches to new window")
	public void user_switches_to_new_window() {

		switchToNewWindow();
	}

	@When("user selects size c {string}")
	public void user_selects_size(String size) {

		pdp.selectSize(size);
	}

	@When("user clicks on Add to Bag")
	public void user_clicks_on_add_to_bag() {

		pdp.clickOnAddToBag();
	}

	@When("user clicks on Go to Bag")
	public void user_clicks_on_go_to_bag() {

		pdp.clickOnGoToBag();
	}

	@Then("product should be displayed in cart")
	public void product_should_be_displayed_in_cart() {

		Assert.assertTrue(cart.isProductDispayed(), "Product not displayed in cart");
	}

	@Then("cart page URL and title should be correct")
	public void verifyCartPageUrlAndTitle() {

		String currentUrl = driver.getCurrentUrl();

		SoftAssert softAssert = new SoftAssert();

		softAssert.assertTrue(currentUrl.contains("/checkout/cart"), "Cart page URL not correct");

		String title = driver.getTitle();

		softAssert.assertTrue(title.toUpperCase().contains("SHOPPING BAG"), "Cart page title not correct");

		softAssert.assertAll();
	}

	@When("user select colour {string}")
	public void selectColour(String colour) {

		ProductListingPage plp = new ProductListingPage();

		plp.selectColour(colour);
	}

	@Then("Place Order button should be displayed in cart")
	public void verifyPlaceOrderButtonDisplayed() {

		CartPage cart = new CartPage();

		Assert.assertTrue(cart.isPlaceOrderButtonDisplayed(), "Place Order button not displayed in cart");
	}

	@Given("user navigates directly to cart page")
	public void navigateToCartDirectly() {

		driver.get("https://www.myntra.com/checkout/cart");
	}

	@Then("empty cart message should be displayed")
	public void verifyEmptyCartMessage() {

		CartPage cart = new CartPage();

		Assert.assertTrue(cart.isEmptyCartMessageDisplayed(),
				"Empty cart message not displayed when navigating directly to cart");
	}

	@Then("Apply Coupon button should be displayed in cart")
	public void verifyApplyCouponButtonDisplayed() {

		CartPage cart = new CartPage();

		Assert.assertTrue(cart.isApplyCouponButtonDisplayed(), "Apply Coupon button not displayed");
	}

	@When("user select discount {string}")
	public void selectDiscount(String discount) {

		ProductListingPage plp = new ProductListingPage();

		plp.selectDiscount(discount);
	}

	@When("user clicks on Remove button")
	public void clickRemoveButton() {

		CartPage cart = new CartPage();

		cart.clickRemoveButton();
	}

	@When("user confirms remove product")
	public void confirmRemoveProduct() {

		CartPage cart = new CartPage();

		cart.confirmRemoveProduct();
	}

	@When("user clicks on Enter Pincode field")
	public void clickEnterPincode() {

		CartPage cart = new CartPage();

		cart.clickEnterPinCode();
	}

	@When("user enters invalid pincode {string}")
	public void enterInvalidPincode(String pincode) {

		CartPage cart = new CartPage();

		cart.enterPincode(pincode);
	}

	@When("user clicks on Check button")
	public void clickCheckButton() {

		CartPage cart = new CartPage();

		cart.clickCheckButton();
	}

	@Then("error message should be displayed for invalid pincode")
	public void verifyInvalidPincodeErrorMessage() {

		CartPage cart = new CartPage();

		Assert.assertTrue(cart.isErrorMessageDisplayed(), "Error message not displayed for invalid pincode");
	}

}
