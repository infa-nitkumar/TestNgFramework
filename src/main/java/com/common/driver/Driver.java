package com.common.driver;

import org.openqa.selenium.WebDriver;

import com.common.constants.BrowserName;
import com.common.reporter.Logger;
import com.google.common.base.Objects;

public class Driver {
	
	private static ThreadLocal<WebDriver> driver  = new ThreadLocal<>();
	
	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void initDriver(BrowserName browserName) {
		driver.set(DriverFactory.getDriver(browserName));
	}
	
	public static void quit() {
		driver.get().quit();
	}

}
