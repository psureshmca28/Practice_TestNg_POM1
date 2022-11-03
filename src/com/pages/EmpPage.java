package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmpPage 
{
	//define elements
		
	@FindBy(xpath="//a[@id='menu_pim_viewPimModule']")
	private WebElement pid_element;
	
	@FindBy(xpath="//a[@id='menu_pim_viewEmployeeList']")
	private WebElement empList_link;
	
	@FindBy(id="menu_pim_addEmployee")
	private WebElement add_employee;
	
	@FindBy(id="firstName")
	private WebElement fist_name;
	
	@FindBy(id="lastName")
	private WebElement last_name;
	
	@FindBy(id="chkLogin")
	private WebElement login_check;
	
	@FindBy(id="user_name")
	private WebElement user_name;
	
	@FindBy(id="user_password")
	private WebElement user_password;
	
	@FindBy(id="re_password")
	private WebElement re_password;
	
	@FindBy(id="btnSave")
	private WebElement emp_save;
	
	@FindBy(id="empsearch_id")
	private WebElement search_emp;
	
	@FindBy(id="employeeId")
	private WebElement empId;
	
	@FindBy(id="searchBtn")
	private WebElement search_Btn;
		
	@FindBy(partialLinkText="Welcome")
	private WebElement welcome_link;
	
	@FindBy(linkText="Logout")
	private WebElement logout;
	
		
	//define methods
	public void dispEmployee()
	{
		System.out.println("Emp Page page");
		pid_element.click();
		empList_link.click();
	}
	
	public void addEmployee()
	{
		System.out.println("Add Emp Page");
		add_employee.click();
		
		fist_name.sendKeys("FFHarsh44");
		last_name.sendKeys("LLHarsh44");
		login_check.click();
		user_name.sendKeys("LLHarsha44");
		user_password.sendKeys("Purini@2007");
		re_password.sendKeys("Purini@2007");
		emp_save.click();
	}
		
	public void searchEmployee() throws Exception{
		empList_link.click();
		Thread.sleep(5000);
		System.out.println("EmpNo trying to get val");
		String empno =empId.getAttribute("value");
		System.out.println("EmpNo :"+empno);
		search_emp.sendKeys(empno);
		search_Btn.click();
	}
		
	public void logout()
	{
		System.out.println("logout page");
		welcome_link.click();
		logout.click();
	}
	
}
