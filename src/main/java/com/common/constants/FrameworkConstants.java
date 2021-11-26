package com.common.constants;

import java.io.File;

import com.common.util.Utils;

public interface FrameworkConstants {
	
	String slash = File.separator;
	String outputFolder = "Output"; 
	String frameworkDir = System.getProperty("user.dir");
	String configFilePath = slash+"Config"+slash+"config.properties";
	String reportPath = Utils.getOutputFolder()+slash+"index"+Utils.getTimeStampNow()+".html";
	String logfile = Utils.getOutputFolder()+FrameworkConstants.slash+"log.txt";
	String driverExcel = frameworkDir+slash+"Driver.xlsx";

}
