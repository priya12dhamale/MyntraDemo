package com.myntra.base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.myntra.utils.ConfigReader;
import com.myntra.utils.ConfigReader;

import static com.myntra.base.KeyWord.*;

import java.io.IOException;

public class BaseClass {

	@BeforeMethod
	public void setUp() throws IOException {

		openBrowser();

		launchUrl();

	}
	
	@AfterMethod
	public void tearDown() {
		closeBrowser();
	}

}
