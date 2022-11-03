package com.testNGScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelTest2 {

	WebDriver driver;
	
	@Test
	public void btest4() {
		System.out.println("Parallel Test4:"+"Thread:"+Thread.currentThread().getId());
		System.setProperty("webdriver.gecko.driver", "D:\\Selenium_WP_practice_18_04_22\\Practice_TestNg\\geckodriver.exe");
		driver =new FirefoxDriver();
		driver.get("https://example.testproject.io/web/");
		
	}
	
	@Test(dependsOnMethods = "btest4")
	public void atest5() throws InterruptedException {
		System.out.println("Parallel Test5:"+"Thread:"+Thread.currentThread().getId());
		Thread.sleep(5000);
		driver.findElement(By.id("name")).sendKeys("Naresh");
		
		
	}
	
	@AfterClass
	public void test6() throws InterruptedException {
		System.out.println("Parallel Test6:"+"Thread:"+Thread.currentThread().getId());
		Thread.sleep(5000);
		driver.quit();
		
	}
}
