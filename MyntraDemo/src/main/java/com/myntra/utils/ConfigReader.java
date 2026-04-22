package com.myntra.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

//	// Path of the properties file
//	public static String file_path = System.getProperty("user.dir") + "/src/test/resources/config.properties";
//
//	// Create Properties object
//	private static final Properties prop = new Properties();
//
//	// Method to read value from properties file using key
//	public static String getProperties(String key) {
//
//		try {
//			// Open the properties file
//			FileInputStream file = new FileInputStream(file_path);
//
//			// Load file data into Properties object
//			prop.load(file);
//
//		} catch (IOException e) {
//			System.out.println(e.getMessage());
//		}
//
//		// Return value of the given key
//		return prop.getProperty(key);
//	}
//
////	public static String getProperties(String key) {
////		// TODO Auto-generated method stub
////		return null;
////	}


	/**
	 * ConfigReader ───────────── Reads key=value pairs from config.properties file.
	 *
	 * Usage (anywhere in the project): String browser =
	 * ConfigReader.get("browser"); // returns "chrome" String url =
	 * ConfigReader.get("base.url"); // returns the URL
	 */

		private static final Properties props = new Properties();

		/**
		 * This block runs once automatically when ConfigReader is first used. It opens
		 * the config.properties file and loads all the values.
		 */
		static {

			try {
				FileInputStream file = new FileInputStream("src/test/resources/config.properties");
				props.load(file);
			} catch (IOException e) {
				throw new RuntimeException("ERROR: config.properties not found! " + e.getMessage());
			}

		}

		/**
		 * No objects needed — all methods are static
		 */

		private ConfigReader() {

		}

		/**
		 * Returns the value for the given key. Example: ConfigReader.get("browser") →
		 * "chrome"
		 */
		public static String get(String key) {
			String value = props.getProperty(key);
			if (value == null) {
				throw new RuntimeException("Key '" + key + "' not found in config.properties");
			}
			return value.trim();
		}

	}

