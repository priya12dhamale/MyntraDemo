package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
     (features = "src/test/resources/features", glue = { "com.myntra.stepdefinitions", "com.myntra.hooks" }
   //  tags = "@SearchWithBlankField"

)


public class Runner extends AbstractTestNGCucumberTests {

}
