package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;

public class CreateOrganizationTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//read common data from JSON file
	FileInputStream fis=new FileInputStream("./configAppData/commondata.properties");
	Properties pObj=new Properties();
	pObj.load(fis);
	String BROWSER=pObj.getProperty("browser");
	String URL=pObj.getProperty("url");
	String USERNAME=pObj.getProperty("username");
	String PASSWORD=pObj.getProperty("password");
	
	//Generate the random number
	Random random=new Random();
	int randomInt=random.nextInt(10000);
	
		//read testscript data from excel file
		FileInputStream fis1=new FileInputStream("./testData/Testscript.xlsx");
Workbook wb=WorkbookFactory.create(fis1);
	Sheet sh=wb.getSheet("org");
	Row row=sh.getRow(1);
	String orgName=row.getCell(2).toString() +randomInt;
	wb.close();
	
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
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();
	
	//Step 2:Navigate to organization module
	driver.findElement(By.linkText("Organizations")).click();
	
	//Step 3:Click on create organization button
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	
	//Step 4:Enter all details and create new organization
	driver.findElement(By.name("accountname")).sendKeys(orgName);
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	//Step 5:Verify header msg expected result
	String headerInfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if(headerInfo.contains(orgName))
	{
		System.out.println(orgName + "is created==PASS");
	}
	else
	{
		System.out.println(orgName + "is not created==FAIL");
	}
	
	//Verify header orgName info expected result
	String actOrgName=driver.findElement(By.id("dtlview_Organization Name")).getText();
	if(actOrgName.equals(orgName))
	{
		System.out.println(orgName + "is created==PASS");
	}
	else
	{
		System.out.println(orgName + "is not created==FAIL");
	}
	//Step 5:Log out
	driver.quit();
	}
		
		
	}


