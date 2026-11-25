package com.comcast.crm.orgtest;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationPage;



public class CreateOrganizationPOMPractice {

    public static void main(String[] args) throws IOException {
	FileUtility fLib=new FileUtility();
	ExcelUtility eLib=new ExcelUtility();
	JavaUtility jLib=new JavaUtility();
		//Create object
		
		String BROWSER=fLib.getDataFromPropertiesFile("browser");
		String URL=fLib.getDataFromPropertiesFile("url");
		String USERNAME=fLib.getDataFromPropertiesFile("username");
		String PASSWORD=fLib.getDataFromPropertiesFile("password");
		
			//read testscript data from excel file
			
		String orgName=eLib.getDataFromExcel("org", 1, 2) +jLib.getRandomNumber();
		WebDriver driver=null;
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
		
		
		//Step 1:login to app
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
	LoginPage lp=new LoginPage(driver);
	lp.loginToapp(URL, USERNAME, PASSWORD);
		
		//Step 2:Navigate to Organization module
HomePage hp=new HomePage(driver);
hp.getOrglink().click();
		
	//Step 3:Click on create organization button
//OrganizationPage cnp=new OrganizationPage(driver);
OrganizationPage cnp=new OrganizationPage(driver);
cnp.getCreateNewOrgBtn().click();


//Step 4:Enter all the details and create new organization
CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
cnop.createOrg(orgName);

//Verify header msg expected result
OrganizationInfoPage oip=new OrganizationInfoPage(driver);


String actOrgname=oip.getHeaderMsg().getText();

if(actOrgname.contains(orgName))
{
	System.out.println(orgName + "name is verified==PASS");
}
else
{
	System.out.println(orgName + "name is not verified==Fail");
}

//Step 5 :Logout
hp.logout();
		}
}
			
			
		
		


