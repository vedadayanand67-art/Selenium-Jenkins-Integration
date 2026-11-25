package com.comcast.crm.contacttest;

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
/**
 * 
 * @author vedas
 */
public class CreateContactTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileInputStream fis=new FileInputStream("./configAppData/commondata.properties");
		Properties pObj=new Properties();
		pObj.load(fis);
		String BROWSER=pObj.getProperty("browser");
		String URL=pObj.getProperty("url");
		String USERNAME=pObj.getProperty("username");
		String PASSWORD=pObj.getProperty("password");
		
		//Generate the random number
		Random random=new Random();
		int randomInt=random.nextInt(1000);
		
			//read testscript data from excel file
			FileInputStream fis1=new FileInputStream("./testData/Testscript.xlsx");
	Workbook wb=WorkbookFactory.create(fis1);
		Sheet sh=wb.getSheet("contact");
		Row row=sh.getRow(4);
		String lastName=row.getCell(2).toString() +randomInt;
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
		driver.findElement(By.linkText("Contacts")).click();
		
		//Step 3:Click on create organization button
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		//Step 4:Enter all details and create new organization
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Step 5:Verify header msg expected result
		String actLastName=driver.findElement(By.id("dtlview_Last Name")).getText();
		if(actLastName.contains(lastName))
		{
			System.out.println(lastName + "is created==PASS");
		}
		else
		{
			System.out.println(lastName + "is not created==FAIL");
		}
		//Step 5:Log out
		driver.quit();
		

	}

}
