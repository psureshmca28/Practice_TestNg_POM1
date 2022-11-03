package com.ddt.testcases;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.LoginPage;
import com.utils.AppUtils;
import com.utils.XLUtils;

public class AdminLoginTestwithInvalidData extends AppUtils 
{

	String datafile = "D:\\Selenium_WP_practice_18_04_22\\Practice_TestNg\\TestDataFiles\\TestData.xlsx";
	String datasheet = "LoginInvalidData";
	String uid,pwd;
	
	
	@Test
	public void checkAdminLogin() throws IOException
	{
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);		
		int rowcount = XLUtils.getRowCount(datafile, datasheet);
		if(rowcount<=0) {
			System.out.println("We dont have data in Excel sheet");
			return;
		}
		System.out.println("LoginInvalidData RowCount:"+rowcount);
		boolean res;
		
		for(int i=1;i<=rowcount;i++)
		{
			System.out.println("LoginInvalidData Inside loop:"+lp);
			
			uid = XLUtils.getStringCellData(datafile, datasheet, i, 0);
			pwd = XLUtils.getStringCellData(datafile, datasheet, i, 1);
			System.out.println("uid:"+uid+"; password:"+uid);
			lp.login(uid, pwd);
			res = lp.isErrMsgDisplayed();
			Assert.assertTrue(res);
			if(res){
				XLUtils.setCellData(datafile, datasheet, i, 2, "Fail");
				XLUtils.fillRedColor(datafile, datasheet, i, 2);
			}
		}
	}	
}
