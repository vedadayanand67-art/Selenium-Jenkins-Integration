package systempom;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.sidecfhef.genericutility.fileutility.ExcelUtility;
import com.sidecfhef.genericutility.fileutility.FileUtility;
import com.sidechef.baseclassutility.Baseclass;
import com.sidechef.baseclassutility.LoginBaseClass;
import com.sidechef.genericutility.webdriverutility.JavaUtility;
import com.sidechef.genericutility.webdriverutility.WebDriverUtility;
import com.sidechef.listener.ListenerImplementation;
import com.sidechef.objectrepositoryutility.Explore;
import com.sidechef.objectrepositoryutility.SearchPage;
import com.sidechef.objectrepositoryutility.SignInPage;
import com.sidechef.objectrepositoryutility.StartUpInstructions;



@Listeners(ListenerImplementation.class)
public class SearchRecipe extends Baseclass{

	
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
	@Test
	  public void searchRecipeTest() throws EncryptedDocumentException, IOException
	    {
		signUpUser();
		 StartUpInstructions sui = new StartUpInstructions(driver);
	        sui.instructions(wLib);

	        SearchPage srcp = new SearchPage(driver);
	        srcp.saveBookmark();

	        Explore e = new Explore(driver);
	        e.exploreCookingClasses(wLib);
	        
	        
	    }
	}
	


