package com.testNGScripts;

import org.testng.annotations.Test;

public class TestNgTestAttributes {
	
	
	@Test(description = "Suresh")
	public void testDesc() {
		System.out.println("testDesc method");
	}
	
	
	@Test(enabled = false)
	public void testEnabled() {
		System.out.println("enabled method");
	}
	
	@Test(invocationCount = 2)
	public void test_invocation() {
		System.out.println("test_invocation method");
	}
	

	@Test(expectedExceptions = ArithmeticException.class)
	public void test() {
		int x=1/0;
		System.out.println("Test method");
	}
	
	@Test(priority = 1)
	public void sub() {
		System.out.println("prority method1");
	}
	
	@Test(priority = 2)
	public void add() {
		System.out.println("prority method2");
	}
	
	@Test(dependsOnMethods = "sub")
	public void aestqq() {
		System.out.println("Dependon methods");
	}
	
	@Test(timeOut = 1000)
	public void test_timeout() {
		System.out.println("test_timeout method");
		try {
			Thread.sleep(2000);
		}catch(InterruptedException e) {
			
		}
	}
}
