package smoke;

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
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import com.sidecfhef.genericutility.fileutility.*;
import com.sidechef.genericutility.webdriverutility.JavaUtility;
import com.sidechef.genericutility.webdriverutility.WebDriverUtility;

public class Signup {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//Create object
		FileUtility fLib=new FileUtility();
		JavaUtility jLib=new JavaUtility();
		ExcelUtility elib=new ExcelUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		
			String browser=fLib.getDataFromPropertiesFile("browser");
			String URL=fLib.getDataFromPropertiesFile("url");	
			
				//read testscript data from excel file
			String USERNAME = elib.getDataFromExcel("Sheet1", 1, 2);
			String EMAIL = elib.getDataFromExcel("Sheet1", 1, 3)
			        .replace("@", jLib.getRandomNumber() + "@");			
			String PASSWORD = elib.getDataFromExcel("Sheet1", 1, 4);

			System.out.println("Generated Email: " + EMAIL);
			
WebDriver driver=null;
if(browser.equalsIgnoreCase("chrome"))
{
	driver=new ChromeDriver();
}
else if(browser.equalsIgnoreCase("firefox"))
{
	driver=new FirefoxDriver();
	
}
else if(browser.equalsIgnoreCase("edge"))
{
	driver=new EdgeDriver();
}
	
	else
	{
		driver=new ChromeDriver();
	}


	wlib.maximize(driver);
	wlib.waitForPageToLoad(driver);
	driver.get(URL);
	//Sign up
			driver.findElement(By.xpath("//button[text()='Accept all']")).click();
			driver.findElement(By.linkText("SIGN UP")).click();
			try {
			    new WebDriverWait(driver, Duration.ofSeconds(5))
			        .until(ExpectedConditions.elementToBeClickable(
			            By.xpath("//button[text()='Accept all']")))
			        .click();
			} catch (TimeoutException e) {
			    System.out.println("Button not present. Continue.");
			}
			//Sign up feature
			driver.findElement(By.xpath("//div[@data-testid='email-signup']")).click();
			driver.findElement(By.xpath("//input[@placeholder='What should we call you?']"))
		      .sendKeys(USERNAME);
			driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(EMAIL);
			driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(PASSWORD);
			driver.findElement(By.xpath("//div[@data-testid='signup']")).click();
			// Verify signup success message
			String expectedText = "Welcome to SideChef!";

			String actualText = driver.findElement(
			    By.xpath("//*[contains(text(),'Welcome to SideChef!')]")
			).getText();

			if (actualText.equals(expectedText))
			{
			    System.out.println(actualText + " == PASS");
			}
			else
			{
			    System.out.println("Signup message mismatch == FAIL");
			}	
	driver.quit();
}
}