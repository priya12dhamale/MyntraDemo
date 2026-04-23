package com.myntra.basetest;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.myntra.utils.ConfigReader;
import com.myntra.utils.ConfigReader;

import static com.myntra.basetest.KeyWord.*;

import java.io.IOException;

public class BaseClass {

	@BeforeMethod
	public void setUp() throws IOException {

		// Read values from config.properties
//		String browser = "";
//		String url = "";
//
//		browser = ConfigReader.getProperties("browser");
//		url = ConfigReader.getProperties("url");

		// Open browser
		//openBrowser(browser);
          openBrowser();
		// Maximize window
		//maximizeWindow();
    openUrl();
		// Launch application/
	//	launchUrl(url);
		// getUrl(url);
	}
//
//	@AfterMethod
//	public void tearDown() {
//		closeBrowser();
//	}

}
