package smokepom;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.sidecfhef.genericutility.fileutility.ExcelUtility;
import com.sidecfhef.genericutility.fileutility.FileUtility;
import com.sidechef.baseclassutility.LoginBaseClass;
import com.sidechef.genericutility.webdriverutility.JavaUtility;
import com.sidechef.genericutility.webdriverutility.WebDriverUtility;
import com.sidechef.listener.ListenerImplementation;
import com.sidechef.objectrepositoryutility.FirstPage;
import com.sidechef.objectrepositoryutility.SignInPage;

@Listeners(ListenerImplementation.class)
public class SignInPOM extends LoginBaseClass {
	        @Test(groups="ST")
	        public void signInTest()
	        {
	            SignInPage sp = new SignInPage(driver);

	            Assert.assertTrue(sp.verifySignIn(), "Login failed");

	            System.out.println("Login Successful");
	        }
	    }
	    
	


	

