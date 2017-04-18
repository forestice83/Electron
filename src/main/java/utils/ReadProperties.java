package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadProperties {
	public static void main(String[] args) {
		System.out.println("PS 1. " + loadProperty("saucelabs"));
		System.out.println("PS 2. " + getProperty("employerEmail"));
		System.out.println("PS 3. " + getSaucelabsProperties("userName") );
		System.out.println("PS 4. " + getSaucelabsProperties("accessKey") );
	}

	public static String getProperty(String key) {
		String value = null;

		Properties prop = loadProperty("testRun");
		value = prop.getProperty(key);

		if (value == null) {
			String testEnv = prop.getProperty("testEnv");

			prop = loadProperty(testEnv);
			value = prop.getProperty(key);
		}
		if (value != null) {
		value =	value.trim();
		}

		return value;
	}
	
	public static String getSaucelabsProperties(String key) {
		
		String value = null;
		Properties prop = loadProperty("saucelabs");
		value = prop.getProperty(key);
		
		if (value != null) {
			value = value.trim();
		}
		return value;
		
	}

	public static Properties loadProperty(String propFileName) {
		Properties prop = new Properties();
		String filePath = "./src/main/resources/properties/" + propFileName.trim()+ ".properties";

		try {
			File file = new File(filePath);
			FileInputStream fileStream = new FileInputStream(file);
			prop.load(fileStream);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return prop;
	}


}
