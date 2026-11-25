package smokepom;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.sidecfhef.genericutility.fileutility.ExcelUtility;
import com.sidecfhef.genericutility.fileutility.FileUtility;
import com.sidechef.baseclassutility.LoginBaseClass;
import com.sidechef.genericutility.webdriverutility.JavaUtility;
import com.sidechef.genericutility.webdriverutility.WebDriverUtility;
import com.sidechef.listener.ListenerImplementation;
import com.sidechef.objectrepositoryutility.RecipePage;
import com.sidechef.objectrepositoryutility.SignInPage;
@Listeners(ListenerImplementation.class)
public class Recipe extends LoginBaseClass {

	


@Test
    public void recipeTest()
    {
    	 RecipePage rp = new RecipePage(driver);

    	    rp.getRecipe(wLib);

    	    Assert.assertTrue(rp.verifRecipeResult(), "Recipe search failed");

    	    System.out.println("Recipe search passed");
    }
}

