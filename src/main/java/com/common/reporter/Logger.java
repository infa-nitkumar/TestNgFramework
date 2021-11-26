package com.common.reporter;

public class Logger {
	
	public static void info(String message) {
		LogManager.info(message);
		ExtentTestLogger.info(message);
	}
	
	public static void pass(String message) {
		LogManager.pass(message);
		ExtentTestLogger.pass(message);
	}
	
	public static void fail(String message) {
		LogManager.error(message);
		ExtentTestLogger.fail(message);
	}
	
	public static void warn(String message) {
		LogManager.warn(message);
		ExtentTestLogger.warning(message);
	}
	
	

}
