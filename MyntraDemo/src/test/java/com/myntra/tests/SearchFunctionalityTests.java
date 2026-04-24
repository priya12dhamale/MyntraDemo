package com.myntra.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.myntra.base.BaseClass;
import com.myntra.pages.SearchPage;
import com.myntra.pages.SearchResultPage;
import com.listener.MyTestListener;

@Listeners(MyTestListener.class)
public class SearchFunctionalityTests extends BaseClass {

	@Test
	public void verifyEnterTextInSearchBox() {

		SearchPage search = new SearchPage();
		search.searchProduct("pefume");
		// Assert.assertTrue(search.searchResultsAreDisplayed(), "Text is not entered in
		// search box");
	}

}
