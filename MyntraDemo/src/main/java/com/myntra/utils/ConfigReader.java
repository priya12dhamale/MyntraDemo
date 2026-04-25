package com.myntra.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private static final Properties props = new Properties();

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
