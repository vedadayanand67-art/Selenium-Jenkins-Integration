import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Pra2 {

	public static void main(String[] args) {
	
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/ui/shadow/closed?sublist=1");
		WebElement host = driver.findElement(By.xpath("//div[@class='my-3']"));

		
		Actions act = new Actions(driver);

	

		act.click(host)
		   .sendKeys("admin")
		   .perform();
		
		act.sendKeys(Keys.TAB)
		  		   .sendKeys("admin")
		   .perform();

		act.sendKeys(Keys.TAB)
		   .sendKeys(Keys.ENTER)
		   .perform();
	}

}
