package com.common.reporter;

import com.aventstack.extentreports.ExtentTest;
import com.common.driver.Driver;
import com.common.util.Utils;

public class ExtentTestLogger {
	
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
	
	public static void setExtentTest(ExtentTest et) {
		extentTest.set(et);
	}
	
	public static ExtentTest getExtentTest() {
		return extentTest.get();
	}
	
	public static void tearDown() {
		extentTest.remove();
	}
	
	public static void pass(String message) {
		getExtentTest().pass(message);
	}
	
	public static void fail(String message) {
		getExtentTest().fail(message);
	}
	
	public static void skip(String message) {
		getExtentTest().skip(message);
	}
	
	public static void info(String message) {
		getExtentTest().info(message);
	}
	
	public static void warning(String message) {
		getExtentTest().warning(message);
	}
	
	public static void attachScreenshot() {
		getExtentTest().addScreenCaptureFromPath(Utils.takeSnapShot(Driver.getDriver()));
	}

}
