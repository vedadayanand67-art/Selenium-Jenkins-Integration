import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class Switch extends WebDriverUtility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverUtil wLib=new WebDriverUtil();
WebDriver driver=new ChromeDriver();
driver.get("https://www.sidechef.com");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.switchTo().newWindow(WindowType.TAB);
driver.get("https://www.google.com");
wLib.switchToTabOnURL(driver, "sidechef");

	}

}
