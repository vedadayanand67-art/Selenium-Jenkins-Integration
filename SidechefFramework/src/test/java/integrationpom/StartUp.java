package integrationpom;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sidecfhef.genericutility.fileutility.ExcelUtility;
import com.sidecfhef.genericutility.fileutility.FileUtility;
import com.sidechef.baseclassutility.Baseclass;
import com.sidechef.genericutility.webdriverutility.JavaUtility;
import com.sidechef.genericutility.webdriverutility.WebDriverUtility;
import com.sidechef.listener.ListenerImplementation;
import com.sidechef.objectrepositoryutility.CPRatings;
import com.sidechef.objectrepositoryutility.FirstPage;
import com.sidechef.objectrepositoryutility.RecipePage;
import com.sidechef.objectrepositoryutility.SignInPage;
import com.sidechef.objectrepositoryutility.StartUpInstructions;
@Listeners(ListenerImplementation.class)
public class StartUp extends Baseclass {

	@Test
public void StartupInstruction() throws IOException
{
	  signUpUser();
	  // Complete startup instructions
      StartUpInstructions sui = new StartUpInstructions(driver);
      sui.instructions(wLib);

      // Click Quick and Easy Recipe
      RecipePage rp = new RecipePage(driver);
      rp.clickQuickEasyRecipe(wLib);
      
      Assert.assertTrue(rp.verifyViralRecipes(),
    	        "Viral Recipes section not displayed");

    	System.out.println("Viral Recipes section displayed successfully");

	}

}
