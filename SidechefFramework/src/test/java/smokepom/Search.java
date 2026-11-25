package smokepom;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.sidecfhef.genericutility.fileutility.ExcelUtility;
import com.sidecfhef.genericutility.fileutility.FileUtility;
import com.sidechef.baseclassutility.Baseclass;
import com.sidechef.baseclassutility.LoginBaseClass;
import com.sidechef.genericutility.webdriverutility.JavaUtility;
import com.sidechef.genericutility.webdriverutility.UtilityClassObject;
import com.sidechef.genericutility.webdriverutility.WebDriverUtility;
import com.sidechef.listener.ListenerImplementation;
import com.sidechef.objectrepositoryutility.SearchPage;
import com.sidechef.objectrepositoryutility.SignInPage;
@Listeners(ListenerImplementation.class)

public class Search extends LoginBaseClass
{
    
    @Test(groups="ST")
    public void searchTest()
    {	
    	    SearchPage srp = new SearchPage(driver);

    	    srp.Search();

    	    Assert.assertTrue(srp.verifySearchResult(), "Searchtest failed");

    	    System.out.println("Search result displayed");
    	
    	  
    }
}


