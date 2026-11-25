package practice.pom.repository;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationPage;




public class DeleteOrgTest {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
			//Create object
			
			String BROWSER=fLib.getDataFromPropertiesFile("browser");
			String URL=fLib.getDataFromPropertiesFile("url");
			String USERNAME=fLib.getDataFromPropertiesFile("username");
			String PASSWORD=fLib.getDataFromPropertiesFile("password");
			
				//read testscript data from excel file
				
			String orgName=eLib.getDataFromExcel("org", 10, 2) +jLib.getRandomNumber();

			
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
			//Step 1:login to app
			
			//Step 1:Login to app
			LoginPage lp=new LoginPage(driver);
			//lp.loginToapp(USERNAME, PASSWORD);
			
			//Step 2:navigate to organization module
			HomePage hp=new HomePage(driver);
			hp.getOrglink().click();
			
			//Step 3:Click on "create organization button"
			OrganizationPage cnp=new OrganizationPage(driver);
			cnp.getCreateNewOrgBtn().click();
			
			//Step 4:Enter all the details and create new organization
			CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
			cnop.createOrg(orgName);
			
			//Verify header msg expected result
			OrganizationInfoPage oip=new OrganizationInfoPage(driver);
			String actorgName=oip.getHeaderMsg().getText();
			if(actorgName.contains(orgName))
			{
				System.out.println(orgName+ "name is verified==PASS");
			}else
			{
				System.out.println(orgName+ "name is not verified==FAIL");
			}
	//go back to organization page
		
			hp.getOrglink().click();
			
			//search for organization
			cnp.getSearchEdt().sendKeys(orgName);
			wLib.select(cnp.getSearchDD(), "Organization Name");
			cnp.getSearchBtn().click();
			
			//in dynamic web table select and delete org
			driver.findElement(By.xpath("//a[text()='"+orgName+"']/../../td[8]/a[text()='del']")).click();
			
			//Step 5:Logout
			hp.logout();
			
			driver.quit();
			
		
	}
}

