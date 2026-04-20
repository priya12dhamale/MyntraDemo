package com.myntra.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static com.myntra.base.Keyword.*;
import com.myntra.base.BaseClass;
import com.myntra.base.Keyword;
import com.myntra.pages.HomePage;

public class WomenMenuTest extends BaseClass {

	HomePage home;

	@BeforeMethod
	public void setupPage() {

		home = new HomePage();
	}
//
//	@BeforeMethod
//	//Page object tries to use driver
//	//But driver not started yet because of that it will give
//	//NullPointerException 
//	

	// verify women menu is visible or not
	@Test
	public void verifyWomenMenuIsVisible() {

		home.hoverOnWomenMenu();
		Assert.assertTrue(home.womenMenuIsDisplayed(), "women menu is not displayed");
		// home.clickOnWomenMenu();

	}

	@Test
	public void verifyWomenSectionNavigation() {

		home.hoverOnWomenMenu();

		home.clickIndianFusionWear();

		String currentUrl = driver.getCurrentUrl();

		System.out.println("Current URL: " + currentUrl);

		Assert.assertTrue(currentUrl.contains("myntra.com/fusion-wear"), "Women section not opened");
	}
	
	

}
