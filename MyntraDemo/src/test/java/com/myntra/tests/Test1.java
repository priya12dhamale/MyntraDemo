package com.myntra.tests;

import org.testng.annotations.Test;

import com.myntra.base.BaseClass;
import com.myntra.pages.HomePage;
import com.myntra.pages.ProductListingPage;



public class Test1 extends BaseClass {

	  @Test
	  public void verifyCategoryFilter() {

	        HomePage home = new HomePage();
	        ProductListingPage plp = new ProductListingPage();
	        home.hoverOnWomenMenu();
	     //   home.clickIndianFusionWear();
           // home.clickWesternWear();
            home.clickJewelleryOption();
	        plp.selectCategory1("Ring");

	    }
}
