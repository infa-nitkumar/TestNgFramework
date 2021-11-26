package com.test.common;

public class CommonUtils extends BaseTest{
	
	public void delay(int seconds) {
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void navigateToGoogle() {
		driver.get("https://www.google.com");
		delay(3);
	}

}
