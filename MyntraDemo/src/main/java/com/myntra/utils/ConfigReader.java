package com.myntra.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	// Path of the properties file
	public static String file_path = System.getProperty("user.dir") + "/src/test/resources/config.properties";

	// Create Properties object
	private static final Properties prop = new Properties();

	// Method to read value from properties file using key
	public static String getProperties(String key) {

		try {
			// Open the properties file
			FileInputStream file = new FileInputStream(file_path);

			// Load file data into Properties object
			prop.load(file);

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		// Return value of the given key
		return prop.getProperty(key);
	}

//	public static String getProperties(String key) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
