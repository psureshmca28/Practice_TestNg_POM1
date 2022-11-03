package com.testNGScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTesting {
	
	public WebDriver driver;

	  @Parameters("browser")
	  @BeforeClass
	  public void beforeTest(String browser) {

		  if(browser.equalsIgnoreCase("firefox")) {
			  System.setProperty("webdriver.gecko.driver", "D:\\Selenium_WP_practice_18_04_22\\Practice_TestNg\\geckodriver.exe");
			  driver =new FirefoxDriver();	  
		  }else if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "D:\\Selenium_WP_practice_18_04_22\\Practice_TestNg\\chromedriver.exe");
				driver = new ChromeDriver();
		  } 
	  }

	  @Test
	  public void tests() throws InterruptedException{
		  driver.get("https://www.google.com/");
		  //Send keys method
		  driver.findElement(By.name("q")).sendKeys("Facebook");
		  //driver.findElement(By.name("btnK")).click(); //Its giving ElementClickInterceptedException 
		  WebElement  button =  driver.findElement(By.name("btnK"));
		  JavascriptExecutor jse = (JavascriptExecutor)driver;
		  jse.executeScript("arguments[0].click()", button);
	  }  
	  
	  @AfterClass 
	  public void afterTest(){
			driver.quit();
	  }

}
