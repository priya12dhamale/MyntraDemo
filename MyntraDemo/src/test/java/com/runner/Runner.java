package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features", glue = { "com.myntra.stepdefinitions",
		"com.myntra.hooks" },tags="@validPincodeValidation", plugin = {
				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" }

)

public class Runner extends AbstractTestNGCucumberTests {

}
