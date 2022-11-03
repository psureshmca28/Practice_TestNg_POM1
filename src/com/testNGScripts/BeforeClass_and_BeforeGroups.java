package com.testNGScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class BeforeClass_and_BeforeGroups {
	
	
	@BeforeGroups(value = "regression")
	public void beforeGroups() {
		System.out.println("Before Groups");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before class");
	}
	
	@Test(groups = "regression")
	public void test1() {
		System.out.println("Test1");
	}

	
	@Test(groups = "sanity")
	public void test2() {
		System.out.println("Test2");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("After class");
	}
	
	@AfterGroups(value = "sanity")
	public void afterGroups() {
		System.out.println("After Groups");
	}

}
