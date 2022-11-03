package com.testNGScripts;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.commonMethods.BaseMethods;

public class LoginModule {
	
	@BeforeMethod
	  public void OpenERPApp() {
		  BaseMethods.openBrowser();
		  BaseMethods.launchERP();
	  }
	  
	  @AfterMethod
	  public void CloseERPApp() {
		  BaseMethods.driver.close();
	  }
	  
	  @Test (priority = 1)
	  public void TC1_ValidLogin() {
		  BaseMethods.loginERP();
	  }
	  
	  @Test (priority = 3)
	  public void TC2_Logout() {
		  BaseMethods.loginERP();
		  BaseMethods.logoutERP();
	  }
	  
	  @Test (priority = 2, enabled=false)
	  public void TC3_InvalidLogin() {
		  BaseMethods.loginERP("admin1", "master"); //to check Invalid login
	  }
	  
	  @Test (priority = 4)
	  public void TC4_RESET() {
		    BaseMethods.driver.findElement(By.xpath("//button[@id='btnreset']")).click();
			
			String uname = BaseMethods.driver.findElement(By.xpath("//input[@id='username']")).getAttribute("value");
			String password = BaseMethods.driver.findElement(By.xpath("//input[@id='password']")).getAttribute("value");
			
			Assert.assertTrue(uname.isEmpty() && password.isEmpty());
			
		}
	
}
