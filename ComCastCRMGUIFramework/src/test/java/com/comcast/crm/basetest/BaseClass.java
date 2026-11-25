package com.comcast.crm.basetest;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class BaseClass {
	public DataBaseUtility dLib=new DataBaseUtility();
	public FileUtility fLib=new FileUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public JavaUtility jLib=new JavaUtility();
	public WebDriver driver=null;
	
	
	@BeforeSuite
	public void configBS()
	{
		System.out.println("Connect to DB, Report config");
		dLib.getDBconnection();
	}

	@BeforeClass
	public void configBC() throws IOException
	{
		System.out.println("launch the browser");
	String BROWSER=	fLib.getDataFromPropertiesFile("browser");
	
	if(BROWSER.equals("chrome")
			) {
		driver=new ChromeDriver();
	}
	else if(BROWSER.equals("firefox"))
	{
		driver=new FirefoxDriver();
	}
	else if(BROWSER.equals("edge"))
	{
		driver=new EdgeDriver();	
	}
	else
	{
		driver=new ChromeDriver();
	}
	}
	
	
	@BeforeMethod
	public void configBM() throws IOException
	{
		System.out.println("Login");
		String URL=	fLib.getDataFromPropertiesFile("url");
		String USERNAME=	fLib.getDataFromPropertiesFile("username");
		String PASSWORD=	fLib.getDataFromPropertiesFile("password");
		LoginPage lp=new LoginPage(driver);
		lp.loginToapp(URL, USERNAME, PASSWORD);
		
	}
	
	@AfterMethod
	public void configAM()
	{
		System.out.println("Logout");
		HomePage hp=new HomePage(driver);
		hp.logout();
	}
	
	
	@AfterClass
	public void configAC()
	{
		System.out.println("Close the browser");
		driver.quit();
	}
	
	@AfterSuite
	public void configAS() throws SQLException
	{
		System.out.println("Close DB,Report back up");
		dLib.closeDBconnection();
	}
}
