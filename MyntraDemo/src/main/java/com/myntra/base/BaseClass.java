package com.myntra.base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.myntra.utils.ConfigReader;
import com.myntra.utils.ConfigReader;

import static com.myntra.base.Keyword.*;

import java.io.IOException;

public class BaseClass {

	// public static RemoteWebDriver driver;
//	String appurl = "https://www.myntra.com/";

//	@BeforeMethod
//	public void setUp() {
//		
//		openBrowser("chrome");
//		 driver = Keyword.driver;//
//	//	driver.get(appurl);
//		launchUrl(appurl);
//		maximizeWindow();
//
//	}

	@BeforeMethod
	public void setUp() throws IOException {

		// Read values from config.properties
		String browser = "";
		String url = "";

		browser = ConfigReader.getProperties("browser");
		url = ConfigReader.getProperties("url");

		// Open browser
		openBrowser(browser);

		// Maximize window
		maximizeWindow();

		// Launch application/
		launchUrl(url);
		// getUrl(url);
	}

	// @AfterMethod
	// public void tearDown() {
	// closeBrowser();
	// }

}
