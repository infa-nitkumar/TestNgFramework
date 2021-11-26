package com.common.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;

import com.common.constants.FrameworkConstants;

public final class ExcelUtils {
	
	private ExcelUtils() {};
	
	public static List<Map<String,String>> getTestDetail(){
		FileInputStream fs = null;
		XSSFWorkbook workbook = null;
		XSSFSheet sheet = null;
		List<Map<String,String>> excelRecords = new ArrayList<>();
		try {
			 fs = new FileInputStream(FrameworkConstants.driverExcel);
			 workbook = new XSSFWorkbook(fs);
			 sheet = workbook.getSheet("TestCase");
			 Map<String,String> records = null;
				int lastrownum = sheet.getLastRowNum();
				int lastcolnum = sheet.getRow(0).getLastCellNum();
				for(int i=1; i<=lastrownum;i++) {
					records = new HashMap<>();
					for(int j=0;j<lastcolnum;j++) {
						String key = sheet.getRow(0).getCell(j).getStringCellValue().trim();
						String value = sheet.getRow(i).getCell(j).getStringCellValue().trim();
						records.put(key, value);
					}
					excelRecords.add(records);
				}
		} catch (IOException e) {
			e.printStackTrace();
			Assert.fail();
		}finally{
			try {
				if(Objects.nonNull(fs))
				   fs.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return excelRecords;
	}

}
