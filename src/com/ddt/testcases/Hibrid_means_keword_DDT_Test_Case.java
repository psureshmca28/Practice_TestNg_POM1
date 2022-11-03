package com.ddt.testcases;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.pages.LoginPage;
import com.utils.AppUtils;
import com.utils.XLUtils;



public class Hibrid_means_keword_DDT_Test_Case extends AppUtils 
{

	
	String keywordfile = "D:\\Selenium_WP_practice_18_04_22\\Practice_TestNg\\keyword_files\\Book1.xlsx";
	
	String tcsheet = "TestCases";
	String tssheet = "TestSteps";
	
	@Test
	public void checkOrangeHRM() throws IOException, InterruptedException
	{
	
		int tccount,tscount;
		String tcid,tcexeflag,tstcid,keyword;
		String stepres,tcres;
		String adminuid,adminpwd;
		LoginPage lp= PageFactory.initElements(driver, LoginPage.class);
		
		boolean res=false;
		
		tccount = XLUtils.getRowCount(keywordfile, tcsheet);
		tscount = XLUtils.getRowCount(keywordfile, tssheet);
		
		System.out.println("tccount:"+tccount+":: tscount:"+tscount);
		for(int i=1;i<=tccount;i++)
		{
			
			tcid = XLUtils.getStringCellData(keywordfile, tcsheet, i, 0);
			tcexeflag = XLUtils.getStringCellData(keywordfile, tcsheet, i, 2);
			if(tcexeflag.equalsIgnoreCase("y"))
			{
				for(int j=1;j<=tscount;j++)
				{
					tstcid = XLUtils.getStringCellData(keywordfile, tssheet, j, 0);
					if(tstcid.equalsIgnoreCase(tcid))
					{
						keyword = XLUtils.getStringCellData(keywordfile, tssheet, j, 4);
						switch (keyword.toLowerCase()) 
						{
						case "adminlogin":
							adminuid = XLUtils.getStringCellData(keywordfile, tssheet, j, 5);
							adminpwd = XLUtils.getStringCellData(keywordfile, tssheet, j, 6);
							lp.login(adminuid, adminpwd);
							res = lp.isAdminModuleDisplayed();
							break;
						case "logout":
							res = lp.logout();
							break;
						}
						
						// Code to update Step Result
						if(res)
						{
							stepres = "Pass";
							XLUtils.setCellData(keywordfile, tssheet, j, 3, stepres);
							XLUtils.fillGreenColor(keywordfile, tssheet, j, 3);
						}else
						{
							stepres = "Fail";
							XLUtils.setCellData(keywordfile, tssheet, j, 3, stepres);
							XLUtils.fillRedColor(keywordfile, tssheet, j, 3);
						}
						
						// Code to update TestCase Result
						tcres = XLUtils.getStringCellData(keywordfile, tcsheet, i, 3);
						if(!tcres.equalsIgnoreCase("fail"))
						{
							XLUtils.setCellData(keywordfile, tcsheet, i, 3, stepres);
						}
						tcres = XLUtils.getStringCellData(keywordfile, tcsheet, i, 3);
						if(tcres.equalsIgnoreCase("pass"))
						{
							XLUtils.fillGreenColor(keywordfile, tcsheet, i, 3);
						}else
						{
							XLUtils.fillRedColor(keywordfile, tcsheet, i, 3);
						}
						
						
						
					}
				}
				
			}else
			{
				XLUtils.setCellData(keywordfile, tcsheet, i, 3, "Blocked");
				XLUtils.fillRedColor(keywordfile, tcsheet, i, 3);
			}
			
		}
	}
	
	
}
