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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sidecfhef.genericutility.fileutility.ExcelUtility;
import com.sidecfhef.genericutility.fileutility.FileUtility;
import com.sidechef.genericutility.webdriverutility.JavaUtility;
import com.sidechef.genericutility.webdriverutility.WebDriverUtility;

public class ChickenPaprikashRatings {

	public static void main(String[] args) throws IOException, InterruptedException {
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
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(
			    By.xpath("//button[normalize-space()='START ONBOARDING']"))).click();
	
		driver.findElement(By.xpath("//div[text()='Vegan']")).click();
		driver.findElement(By.xpath("//button[text()='NEXT']")).click();
		Thread.sleep(2000);
		
		
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement ele1 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[normalize-space()='Eat Healthy']")));
		ele1.click();
		driver.findElement(By.xpath("//button[text()='NEXT']")).click();
		driver.findElement(By.xpath("//button[text()='GET STARTED']")).click();
		Thread.sleep(2000);
		WebElement recipes=driver.findElement(By.id("nav-recipe"));
		Actions act=new Actions(driver);
		act.moveToElement(recipes).perform();
		driver.findElement(By.linkText("Comfort Food")).click();
		Thread.sleep(2000);
		WebElement chicken = wait.until(
			    ExpectedConditions.elementToBeClickable(
			        By.xpath("//*[normalize-space()='Chicken Paprikash']")
			    )
			);

		act.scrollToElement(chicken).perform();

		wait.until(ExpectedConditions.elementToBeClickable(chicken)).click();

		
		
	}
	

}

