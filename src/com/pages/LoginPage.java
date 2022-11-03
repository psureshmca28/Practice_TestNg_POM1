package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.utils.AppUtils;



public class LoginPage extends AppUtils
{

	//define elements
	
	@FindBy(id="txtUsername")
	private WebElement uid_element;
	
	@FindBy(name="txtPassword")
	private WebElement pwd_element;
	
	@FindBy(xpath="//*[@value='LOGIN']")
	private WebElement login_element;
	
	@FindBy(linkText="Admin")
	private WebElement admin_link;
	
	@FindBy(partialLinkText="Welcome")
	private WebElement welcome_link;
	
	@FindBy(linkText="Logout")
	private WebElement logout;
	
	@FindBy(xpath = "//b[text()='Dashboard']")
	private WebElement dashBoard_PagElement;
	
	//define methods
	
	public void login(String uid,String pwd)
	{
		uid_element.sendKeys(uid);
		pwd_element.sendKeys(pwd);
		login_element.click();		
	}
	
	
	public boolean isAdminModuleDisplayed()
	{
		System.out.println("Module Display");
		if(dashBoard_PagElement.isDisplayed())
		{
			return true;
		}else
		{
			return false;
		}
	}
	
	
	public boolean isErrMsgDisplayed()
	{
		
		String errmsg;
		errmsg = driver.findElement(By.id("spanMessage")).getText();
		if(errmsg.toLowerCase().contains("invalid"))
		{
			return true;
		}else
		{
			return false;
		}
		
	}
	
	public boolean logout()
	{
		System.out.println("logout page");
		welcome_link.click();
		logout.click();
		if(driver.findElement(By.id("btnLogin")).isDisplayed())
		{
			return true;
		}else
		{
			return false;
		}
	}
	
	
	
}