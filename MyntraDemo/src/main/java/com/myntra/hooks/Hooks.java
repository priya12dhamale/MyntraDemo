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

		openBrowser();
		LOG.info("Browser is opened..!");

		launchUrl();
	}

	@After
	public void tearDown() {
		
		closeBrowser();
		LOG.info("Driver is Quit successfully....!");
	}
}
