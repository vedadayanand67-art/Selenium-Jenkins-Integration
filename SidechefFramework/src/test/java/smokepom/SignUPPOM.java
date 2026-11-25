package smokepom;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.sidecfhef.genericutility.fileutility.ExcelUtility;
import com.sidecfhef.genericutility.fileutility.FileUtility;
import com.sidechef.baseclassutility.Baseclass;
import com.sidechef.genericutility.webdriverutility.JavaUtility;
import com.sidechef.genericutility.webdriverutility.WebDriverUtility;
import com.sidechef.listener.ListenerImplementation;
import com.sidechef.objectrepositoryutility.FirstPage;


@Listeners(ListenerImplementation.class)
public class SignUPPOM extends  Baseclass
{
    @Test(groups = "smoke")
    public void signUpTest() throws IOException
    {
        signUpUser();
    }
    }

	