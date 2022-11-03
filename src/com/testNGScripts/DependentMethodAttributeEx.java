package com.testNGScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependentMethodAttributeEx {
	
	  @Test
	  public void start() {
		  Assert.assertFalse(false);
		  System.out.println("Server started");
	  }
	  
	  @Test(dependsOnMethods = "start")
	  public void init() {
		  
		  System.out.println("Initialization");
	  }
	  
	  @Test(dependsOnMethods = "init")
	  public void process() {
		  Assert.assertFalse(true);
		  System.out.println("Server processed");
	  }

	  @Test(dependsOnMethods = "process")
	  public void stop() {
		  System.out.println("Server stopped");
	  }
	  
}
