package com.testng.listeners;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase {

	@Test 
	public void testtopass()  
	{  
		System.out.println("TesttoPass");
		Assert.assertTrue(true);  
	}  
	@Test  
	public void testtofail()  
	{  
		System.out.println("TesttoFail");
		//int x=1/0;
		Assert.assertFalse(false);  
	}  
	

}
