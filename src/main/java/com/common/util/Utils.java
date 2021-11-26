package com.common.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.common.constants.FrameworkConstants;
import com.common.driver.Driver;

public class Utils {
	
	public static void createOutputFolder() {
		Path path = Paths.get(getOutputFolder());
		Path path1 = Paths.get(getSnapshotDir());
		if(Files.exists(path))
			return;
		try {
			Files.createDirectories(path);
			Files.createDirectories(path1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getOutputFolder() {
		return System.getProperty("user.dir")+FrameworkConstants.slash+FrameworkConstants.outputFolder;
	}
	
	public static String getTimeStampNow() {
		Long datetime = System.currentTimeMillis();
		return datetime.toString();
	}
	
	public static String getBase64Image() {
		return ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BASE64);
	}
	
	public static String takeSnapShot(WebDriver driver) {
		String fileName = getSnapshotDir()+FrameworkConstants.slash+System.currentTimeMillis();
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			org.openqa.selenium.io.FileHandler.copy(screenshotFile , new File(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileName;
	}
	
	
	public static String getSnapshotDir() {
		return System.getProperty("user.dir")+FrameworkConstants.slash+FrameworkConstants.outputFolder+FrameworkConstants.slash+"Snapshots";
	}
	

}
