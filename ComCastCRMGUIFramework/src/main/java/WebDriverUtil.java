import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class WebDriverUtil {
	WebDriver driver;
public void switchToTabOnURL(WebDriver driver,String partialURL)
{
	Set<String> set=driver.getWindowHandles();
	Iterator<String> it=set.iterator();
	while(it.hasNext())
	{
		String windowID=it.next();
		driver.switchTo().window(windowID);
		String actUrl=driver.getCurrentUrl();
		if(actUrl.contains(partialURL))
		{
			break;
		}
	}
}
}
