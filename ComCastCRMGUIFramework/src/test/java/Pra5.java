import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Pra5 {
	   @Test
	    public void shadowDOMTest() {

	        WebDriver driver = new ChromeDriver();

	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	        driver.get("https://demoapps.qspiders.com/ui/shadow?sublist=0");

	        // Your existing shadow DOM code goes here
	        driver.findElement(By.xpath("//button[text()='Login']")).click();

	        String actualTitle = driver.getTitle();

	        Assert.assertEquals(actualTitle, "Expected Title", "Login test failed");

	        driver.quit();
}
	   
	   
}
