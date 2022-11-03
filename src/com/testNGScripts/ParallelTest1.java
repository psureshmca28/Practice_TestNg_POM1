package com.testNGScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelTest1 {

	WebDriver driver;
	
	
	@Test
	public void btest1() throws InterruptedException{
		System.out.println("Parallel Test1:"+"Thread:"+Thread.currentThread().getId());
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_WP_practice_18_04_22\\Practice_TestNg\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://example.testproject.io/web/");
		
	}
	
	@Test(dependsOnMethods = "btest1")
	public void atest2() throws InterruptedException {
		System.out.println("Parallel Test2:"+"Thread:"+Thread.currentThread().getId());
		Thread.sleep(5000);
		driver.findElement(By.id("name")).sendKeys("Suresh");
		Thread.sleep(5000);
		
	}
	
	
	@Test(dependsOnMethods = "btest1")
	public void test3() throws InterruptedException {
		System.out.println("Parallel Test3:"+"Thread:"+Thread.currentThread().getId());
		Thread.sleep(5000);
		driver.quit();
		
	}
	
	
}
