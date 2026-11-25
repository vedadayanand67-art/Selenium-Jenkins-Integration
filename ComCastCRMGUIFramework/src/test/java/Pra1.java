import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Pra1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.get("https://demoapps.qspiders.com/ui/shadow?sublist=0");;

//Locate shadow host
WebElement host = driver.findElement(By.xpath("//div[@class='my-3']"));

// Access open shadow root
SearchContext root1 = host.getShadowRoot();

// Locate username
WebElement username = root1.findElement(
        By.cssSelector("input[placeholder='Enter your username']"));

username.sendKeys("admin");

// Locate password using the same shadow root
WebElement host2=driver.findElement(By.xpath("//div[@class='my-3'][2]"));
SearchContext root2=host2.getShadowRoot();

WebElement password = root2.findElement(
        By.cssSelector("input[placeholder='Enter your password']"));

password.sendKeys("admin");

// Click Login
driver.findElement(By.xpath("//button[text()='Login']")).click();
driver.quit();

}
}