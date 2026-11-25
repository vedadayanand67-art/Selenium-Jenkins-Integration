package com.crm.generic.baseutility;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.comcast.crm.objectrepositoryutility.LoginPage;

public class BaseClass {
	WebDriver driver=null;
	@BeforeSuite
	public void configBS()
	{
		System.out.println("Connect to DB, Report config");
	}

	@BeforeClass
	public void configBC()
	{
		System.out.println("launch the browser");
		
	}
	
	@BeforeMethod
	public void configBM()
	{
		System.out.println("Login");
		LoginPage lp=new LoginPage(driver);
		lp.loginToapp(null, null, null);
	}
	
	@AfterMethod
	public void configAM()
	{
		System.out.println("Logout");
	}
	
	
	@AfterClass
	public void configAC()
	{
		System.out.println("Close the browser");
	}
	
	@AfterSuite
	public void configAS()
	{
		System.out.println("Close DB,Report back up");
	}
}
