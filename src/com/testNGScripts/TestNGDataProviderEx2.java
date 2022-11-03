package com.testNGScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGDataProviderEx2 {
	
	
/*	@DataProvider(name = "dpval")
	public Object[][] dpMethod() {
		return new Object[][] 
				{
					{"Suresh","Pelluru"},
					{"abc","mno"},
					{"try","hjk"}
				};
		
	}
	
	*/

	@DataProvider(name = "dpval")
	public Object[][] dpMethod() {
		return new Object[][] 
				{
					{5,6,11},
					{3,8,11},
					{4,3,8}
				};
		
	}
	
	
/*	@Test(dataProvider = "dpval")
	public void myTest(String val1, String val2) {
		System.setProperty("webdriver.gecko.driver", "D:\\Selenium_WP_practice_18_04_22\\Practice_TestNg\\geckodriver.exe");
		WebDriver driver =new FirefoxDriver();
		driver.get("https://example.testproject.io/web/");
		driver.findElement(By.id("name")).sendKeys(val1);
		driver.findElement(By.id("password")).sendKeys(val2);
	}
*/
	
	@Test(dataProvider = "dpval")
	public void myTest(Integer val1, Integer val2,Integer val3) {
		Assert.assertEquals(val1+val2, val3);
	}
}
