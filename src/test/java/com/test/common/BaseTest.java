package com.test.common;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.common.constants.BrowserName;
import com.common.driver.Driver;
import com.common.reporter.ExtentTestLogger;
import com.common.reporter.Logger;

public class BaseTest {
	protected WebDriver driver;
	
	@BeforeMethod	
	protected void preSetup() {
		Driver.initDriver(BrowserName.CHROME);
		driver = Driver.getDriver();
	}
	
	@AfterMethod
	protected void tearDown() {
		Logger.info("Teardown called for "+Thread.currentThread().getName());
		ExtentTestLogger.tearDown();
		Driver.quit();
	}
}
