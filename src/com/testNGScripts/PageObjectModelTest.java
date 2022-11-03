package com.testNGScripts;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.EmpPage;
import com.pages.LoginPage;
import com.utils.AppUtils;

public class PageObjectModelTest extends AppUtils
{
	LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
	@Test
	public void checkAdminLogin()
	{
		
		lp.login("Admin", "Qedge123!@#");
		boolean res = lp.isAdminModuleDisplayed();
		Assert.assertTrue(res);
		//lp.logout();
	}	
	
	
	@Test
	public void empList() throws Exception
	{
		EmpPage lp = PageFactory.initElements(driver, EmpPage.class);
		lp.dispEmployee();
		lp.addEmployee();
		lp.searchEmployee();
		//lp.logout();
	}	
	
}
