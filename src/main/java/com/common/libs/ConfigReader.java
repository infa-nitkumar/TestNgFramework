package com.common.libs;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.common.constants.FrameworkConstants;

public final class ConfigReader {
	
	private ConfigReader() {};
	
	private static Properties property;
	
	static {
		property = new Properties();
		try {
			property.load(new FileInputStream(new File(FrameworkConstants.frameworkDir+FrameworkConstants.configFilePath)));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public static String getConfig(String configName) {
		return property.getProperty(configName);
	}
	

}
