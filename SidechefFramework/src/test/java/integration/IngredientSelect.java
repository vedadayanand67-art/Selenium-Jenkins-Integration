package integration;

import java.io.IOException;
import java.time.Duration;

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

public class IngredientSelect {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
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
		//Sign in feature
		driver.findElement(By.xpath("//button[text()='Accept all']")).click();
		driver.findElement(By.linkText("SIGN IN")).click();
		try {
		    new WebDriverWait(driver, Duration.ofSeconds(5))
		        .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Accept all']"))).click();
		} catch (TimeoutException e) {
		    System.out.println("Button not present. Continue");
		}
driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("vedasd67@gmail.com");
driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Saanvi@14");
driver.findElement(By.xpath("//div[text()='SIGN IN']")).click();
driver.findElement(By.id("my-pantry")).click();
driver.findElement(By.xpath("//button[text()='Add Ingredients']")).click();
WebElement search=driver.findElement(By.xpath("//input[@type='search']"));
search.sendKeys("apple");
driver.findElement(By.xpath("//div[text()='Apple']/ancestor::div[@class='TranslateCard__TranslateCardDiv-sc-58eedab1-1 IngredientCard__Container-sc-51623ff4-0 kANtTv cwgEyI ingredients-card']//*[local-name()='circle' and @stroke='var(--primary-icon-color)']")).click();
driver.findElement(By.xpath("//div[text()='CONFIRM SELECTION']")).click();
driver.quit();

	}

}
