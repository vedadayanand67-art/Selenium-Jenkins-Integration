package integrationpom;
import org.testng.Assert;
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
import com.sidechef.genericutility.webdriverutility.JavaUtility;
import com.sidechef.genericutility.webdriverutility.WebDriverUtility;
import com.sidechef.listener.ListenerImplementation;
import com.sidechef.objectrepositoryutility.FirstPage;
import com.sidechef.objectrepositoryutility.IngredientSelect;
@Listeners(ListenerImplementation.class)
public class Ingredient extends Baseclass
{
    @Test
    public void ingredientTest() throws IOException
    {
    	  signUpUser();
        IngredientSelect is = new IngredientSelect(driver);
        is.addApple();
        Assert.assertTrue(is.verifyPantryItem(), "Apple not added to Pantry");
        System.out.println("PASS: Apple added to Pantry");
    }
}


	
