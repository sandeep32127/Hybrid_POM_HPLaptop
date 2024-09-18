package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	private static Properties prop;
	
	public ConfigReader() {
		loadProperties();
	}
	
	public void loadProperties() {
		prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("./src/main/resources/config.properties")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getProperty(String propertyName) {
		String propertyValue = prop.getProperty(propertyName);
		return propertyValue;
	}

}
