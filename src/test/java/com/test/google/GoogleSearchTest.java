package com.test.google;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.test.common.CommonUtils;

public class GoogleSearchTest extends CommonUtils{
	
	@Test
	public void launchGoogle() {
		driver.get("https://www.google.com");
		delay(3);
	}
	@Test
	public void search() {
		driver.get("https://www.google.com");
		driver.findElement(By.cssSelector("input[name=q]")).sendKeys("jobs",Keys.ENTER);
		delay(3);
	}

}
