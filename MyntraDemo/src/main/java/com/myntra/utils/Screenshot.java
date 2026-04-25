package com.myntra.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Screenshot {

	public static void captureScreenshot(RemoteWebDriver driver, String testName) {

		// Take screenshot
		File src = driver.getScreenshotAs(OutputType.FILE);

		// date and time
		String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
		String DateTime = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
		// Destination path
		File dest = new File("screenshots/" + testName + "_" + DateTime + ".png");

		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
