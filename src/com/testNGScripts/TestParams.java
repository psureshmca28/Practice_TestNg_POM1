package com.testNGScripts;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestParams {
	
	 @Parameters({"username","password"})
	  @Test
	  public void rrrr(String u,String p) {
		  System.out.println("Username:"+u+"Password:"+p);
	  }
	 
	 @Test
	 public void test2() {
		 System.out.println("Excluded");
	 }
	 
}
