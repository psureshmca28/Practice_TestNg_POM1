package com.testNGScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.utils.AppUtils;

public class Test1  extends AppUtils{
	
	

	 @BeforeMethod
	  public void before_Method() {
		  System.out.println("Before Method");
	  }
	 
	 @AfterMethod
	  public void after_Method() {
		  System.out.println("After Method");
	  }
	  
	 @BeforeTest
	  public void Before_Test() {
		  System.out.println("Before Test");
	  }
  
	 @AfterTest
	  public void After_Test() {
		  System.out.println("After Test");
	  }
	 
	  @Test
	  public void TestCase_1() {
		  System.out.println("TestCase1");
	  }
  
	  @Test
	  public void TestCase_2() {
		  System.out.println("TestCase2");
	  }
	  
	  
	  @BeforeClass
	  public void before_Class() {
		  System.out.println("Before Class");
	  }
	  
	  @AfterClass
	  public void after_Class() {
		  System.out.println("After Class");
	  }
	  
	 
	  @BeforeGroups
	  public void beforeGroups() {
		  System.out.println("BeforeGroups");
	  }
	  
	  
	  @AfterGroups
	  public void afterGroups() {
		  System.out.println("AfterGroups");
	  }
  
  
	
}
