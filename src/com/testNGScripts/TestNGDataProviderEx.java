package com.testNGScripts;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import net.bytebuddy.asm.Advice.OffsetMapping.ForOrigin.Renderer.ForReturnTypeName;

public class TestNGDataProviderEx {
	
	
	@DataProvider(name = "dpval")
	public Object[][] dpMethod() {
		return new Object[][] {{"Suresh"},{"Pelluru"},{"Naresh"}};
		
	}
	
	@Test(dataProvider = "dpval")
	public void myTest(String val) {
		System.out.println("Value:"+val);
	}
	
	
	@DataProvider(name="dpVal1")
	public Object[][] dpMethod1(){
		return new Object[][] {{"Suresh"},{"Hari"},{"Prasad"}};
	}
	
	@Test(dataProvider = "dpVal1")
	public void testDP(String x) {
		System.out.println("X:"+x);
		
		
	}
		
	

}
