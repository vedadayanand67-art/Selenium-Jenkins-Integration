package system;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sidecfhef.genericutility.fileutility.ExcelUtility;
import com.sidecfhef.genericutility.fileutility.FileUtility;
import com.sidechef.genericutility.webdriverutility.JavaUtility;
import com.sidechef.genericutility.webdriverutility.WebDriverUtility;

public class Demo2 {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		FileUtility fLib=new FileUtility();
		JavaUtility jLib=new JavaUtility();
		ExcelUtility elib=new ExcelUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		
			String browser=fLib.getDataFromPropertiesFile("browser");
			String URL=fLib.getDataFromPropertiesFile("url");	
			
				//read testscript data from excel file
			String EMAIL = elib.getDataFromExcel("Sheet1", 1, 3);		
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
		//Sign in feature
		driver.findElement(By.xpath("//button[text()='Accept all']")).click();
		driver.findElement(By.linkText("SIGN IN")).click();
		try {
		    new WebDriverWait(driver, Duration.ofSeconds(5))
		        .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Accept all']"))).click();
		} catch (TimeoutException e) {
		    System.out.println("Button not present. Continue");
		}
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(EMAIL);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//div[text()='SIGN IN']")).click();

driver.findElement(By.xpath("//input[@placeholder='What are you craving today?']")).sendKeys("Vegan caesar salad");
driver.findElement(By.xpath("//button[text()='Search']")).click();
Thread.sleep(1000);
driver.findElement(By.xpath("//div[@data-testid='save recipe']")).click();
WebElement signout = driver.findElement(
	    By.xpath("//img[contains(@alt,'user avatar')]")
	);

Actions act=new Actions(driver);
	act.moveToElement(signout).click().perform();

	driver.findElement(
	    By.xpath("//a[contains(normalize-space(.),'Sign Out')]")
	).click();
	driver.quit();


		}


	}


