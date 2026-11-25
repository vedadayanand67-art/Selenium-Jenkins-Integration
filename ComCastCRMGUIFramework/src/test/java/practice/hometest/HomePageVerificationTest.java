package practice.hometest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class HomePageVerificationTest {

	@Test
	public void HomepageTest()
	{
		String expectedPage="Search";
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.sidechef.com");
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
		String actTitle=driver.findElement(By.xpath("//input[@type='search']")).getText();
		if(actTitle.trim().equals(expectedPage))
		{
			System.out.println("Application launched successfully");
		}
		else
		{
			System.out.println("Test not verified");
		}
	driver.quit();
	}
	
	
	@Test
	public void verifyLogoHomePageTest()
	{
		
	}
}
