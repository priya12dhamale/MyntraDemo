package com.myntra.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static com.myntra.base.Keyword.*;

public class HomePageSteps {

	    @Given("User launches browser")
	    public void launch_browser() {

	        openBrowser("chrome");
	    }

	    @When("User clicks on Women menu")
	    public void click_women_menu() {

	        System.out.println("Clicked Women menu");
	    }

	    @Then("Women page should be displayed")
	    public void verify_page() {

	        System.out.println("Women page displayed");
	    }

	}

