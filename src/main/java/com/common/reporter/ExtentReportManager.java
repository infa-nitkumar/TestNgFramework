package com.common.reporter;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.common.constants.FrameworkConstants;

public final class ExtentReportManager {
	
	private ExtentReportManager(){};
	
	private static ExtentReports extent;
	private static ExtentSparkReporter sparkReporter;
	
	private static void configureReport() {
		extent = new ExtentReports();
		sparkReporter = new ExtentSparkReporter(FrameworkConstants.reportPath);
		extent.attachReporter(sparkReporter);
		sparkReporter.config().setTheme(Theme.STANDARD);
		sparkReporter.config().setDocumentTitle("Automation-Result");
		sparkReporter.config().setReportName("Automation-Report");
	}
	
	public static ExtentReports initReport() {
		configureReport();
		return extent;
	}
	
	public static void flushToReport() {
		extent.flush();
	}
	
	public static void showReport() {
		try {
			Desktop.getDesktop().browse(new File(FrameworkConstants.reportPath).toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
