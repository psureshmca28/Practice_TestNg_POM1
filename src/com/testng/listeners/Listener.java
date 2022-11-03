package com.testng.listeners;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener{  
  
    public void onTestStart(ITestResult result) {  
    	 System.out.println("Success of test cases and its onTestStart are : "+result.getName());
    }  
  
    public void onTestSuccess(ITestResult result) {  
        System.out.println("Success of test cases and its details are : "+result.getName());  
    }  
  
    public void onTestFailure(ITestResult result) {  
        System.out.println("Failure of test cases and its details are : "+result.getName());
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium_WP_practice_18_04_22\\Practice_TestNg\\chromedriver.exe");
        WebDriver driver =new ChromeDriver();
		driver.get("http://demo.nopcommerce.com/");
        TakesScreenshot ts = (TakesScreenshot)driver;
		File src =  ts.getScreenshotAs(OutputType.FILE);
		File trg = new File(".\\screenshots\\homepage.png");
		try {
		FileUtils.copyFile(src, trg);
		}catch (Exception e) {
		}
        
    }  
  
    public void onTestSkipped(ITestResult result) {  
        System.out.println("Skip of test cases and its details are : "+result.getName());  
    }  
  
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {  
        System.out.println("Failure of test cases and its details are : "+result.getName());  
    }  
  
    public void onStart(ITestContext context) {  
    	System.out.println("Success of test cases and its onStart are : "+context.getName());
    }  
  
    public void onFinish(ITestContext context) {  
    	System.out.println("Success of test cases and its onFinish are : "+context.getName());  
    }  

}
