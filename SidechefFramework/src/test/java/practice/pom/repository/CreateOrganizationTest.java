package practice.pom.repository;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.sidecfhef.genericutility.fileutility.ExcelUtility;
import com.sidecfhef.genericutility.fileutility.FileUtility;
import com.sidechef.genericutility.webdriverutility.JavaUtility;



public class CreateOrganizationTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
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
			
			PageFactory.initElements(driver,LoginPage.class);
			
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

