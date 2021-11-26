package com.common.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.common.constants.BrowserName;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public static WebDriver getDriver(BrowserName browserName) {
		WebDriver driver = null;
		switch(browserName.toString()) {
		case "CHROME":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "FIREFOX":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "EDGE":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		}
		return driver;
	}

}
