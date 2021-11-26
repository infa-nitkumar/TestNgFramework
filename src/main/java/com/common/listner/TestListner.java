package com.common.listner;

import java.util.Arrays;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener ;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.common.reporter.ExtentReportManager;
import com.common.reporter.ExtentTestLogger;
import com.common.util.Utils;

public final class TestListner implements ITestListener,ISuiteListener{
	
	public TestListner() {};
	
	private ExtentReports extent;
	
	@Override
	public  void onStart(ISuite suite) {
		Utils.createOutputFolder();
		extent = ExtentReportManager.initReport();
	}

	@Override
	public void onFinish(ISuite suite) {
		ExtentReportManager.flushToReport();
		ExtentReportManager.showReport();
	}
	@Override
	public void onTestStart(ITestResult result) {
		ExtentTestLogger.setExtentTest(extent.createTest(result.getMethod().getMethodName()));
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentTestLogger.pass(result.getMethod().getMethodName()+" has passed");
		ExtentReportManager.flushToReport();
	}
	@Override
	public void onTestFailure(ITestResult result) {
		ExtentTestLogger.fail(result.getMethod().getMethodName()+" has failed");
		ExtentTestLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
		ExtentTestLogger.attachScreenshot();
		ExtentReportManager.flushToReport();
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentTestLogger.skip(result.getMethod().getMethodName()+" has skipped");
		ExtentReportManager.flushToReport();
	}


}
