package com.myntra.hooks;

import static com.myntra.base.KeyWord.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	private static final Logger LOG = LogManager.getLogger(Hooks.class);

	@Before
	public void setUp() {

//		String browser = "";
//		String url = "";
//
//		browser = ConfigReader.getProperties("browser");
//		url = ConfigReader.getProperties("url");

		// Open browser
		openBrowser();
		LOG.info("Browser is opened..!");
		// LOG.info("Browser opened: " + browser);
		// Maximize window
		// maximizeWindow();

		launchUrl();
	}

	@After
	public void tearDown() {
		closeBrowser();
		LOG.info("Driver is Quit successfully....!");
	}
}
