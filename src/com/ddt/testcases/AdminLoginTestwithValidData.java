package com.ddt.testcases;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.LoginPage;
import com.utils.AppUtils;
import com.utils.XLUtils;



public class AdminLoginTestwithValidData extends AppUtils{
	
	String datafile = "D:\\Selenium_WP_practice_18_04_22\\Practice_TestNg\\TestDataFiles\\TestData.xlsx";
	String datasheet = "AdminLoginValidData";
	
	@Test
	public void checkAdminLogin() throws IOException	
	{
		
		int rowcount =  XLUtils.getRowCount(datafile, datasheet);
		
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		String adminuid,adminpwd;
		boolean res;
		
		for(int i=1;i<=rowcount;i++)
		{
			adminuid = XLUtils.getStringCellData(datafile, datasheet, i, 0);
			adminpwd = XLUtils.getStringCellData(datafile, datasheet, i, 1);	
			
			System.out.println("uid:"+adminuid+"; password:"+adminpwd);
			
			lp.login(adminuid, adminpwd);
			res = lp.isAdminModuleDisplayed();
			Assert.assertTrue(res);
			if(res)
			{
				XLUtils.setCellData(datafile, datasheet, i, 2, "Pass");
				XLUtils.fillGreenColor(datafile, datasheet, i, 2);
			}else
			{
				XLUtils.setCellData(datafile, datasheet, i, 2, "Fail");
				XLUtils.fillRedColor(datafile, datasheet, i, 2);
			}
			lp.logout();
			}		
	}
	
}
