package smoke;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sidecfhef.genericutility.fileutility.ExcelUtility;
import com.sidecfhef.genericutility.fileutility.FileUtility;
import com.sidechef.genericutility.webdriverutility.JavaUtility;
import com.sidechef.genericutility.webdriverutility.WebDriverUtility;

public class Signin {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Create object
				FileUtility fLib=new FileUtility();
				JavaUtility jLib=new JavaUtility();
				ExcelUtility elib=new ExcelUtility();
				WebDriverUtility wlib=new WebDriverUtility();
				
				//read data from properties file
					String browser=fLib.getDataFromPropertiesFile("browser");
					String URL=fLib.getDataFromPropertiesFile("url");	
					
						//read testscript data from excel file
					String EMAIL = elib.getDataFromExcel("Sheet1", 2, 3);			      		
					String PASSWORD = elib.getDataFromExcel("Sheet1", 2, 4);
WebDriver driver=null;
if(browser.equalsIgnoreCase("chrome"))
{
	driver=new ChromeDriver();
}
else if(browser.equalsIgnoreCase("firefox"))
{
	driver=new FirefoxDriver();
}
else if(browser.equals("edge"))
{
	driver=new EdgeDriver();
}
else
{
	driver=new ChromeDriver();
}
wlib.maximize(driver);
driver.get(URL);
wlib.waitForPageToLoad(driver);
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

//Verify home page is displayed after sign in
			WebElement home=driver.findElement(By.xpath("//input[@data-testid='search input']"));
if(home.isDisplayed())
{
	System.out.println("Sign in is successful");
}
else
{
	System.out.println("Sign in is not successful");
}
			
	driver.quit();

	}
	

}
