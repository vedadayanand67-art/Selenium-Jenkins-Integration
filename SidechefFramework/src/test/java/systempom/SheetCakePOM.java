package systempom;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.sidecfhef.genericutility.fileutility.ExcelUtility;
import com.sidecfhef.genericutility.fileutility.FileUtility;
import com.sidechef.baseclassutility.LoginBaseClass;
import com.sidechef.genericutility.webdriverutility.JavaUtility;
import com.sidechef.genericutility.webdriverutility.WebDriverUtility;
import com.sidechef.objectrepositoryutility.CPRatings;
import com.sidechef.objectrepositoryutility.Explore;
import com.sidechef.objectrepositoryutility.MealplanPage;
import com.sidechef.objectrepositoryutility.RecipePage;
import com.sidechef.objectrepositoryutility.SheetCake;

import com.sidechef.objectrepositoryutility.SignInPage;
import com.sidechef.objectrepositoryutility.Thanksgiving;

public class SheetCakePOM extends LoginBaseClass {
	@Test
	 public void sheetCakeTest()
	 {
	  SheetCake shc = new SheetCake(driver);
    shc.lunchRecipe(wLib);

  Thanksgiving th = new Thanksgiving(driver);
   th.thanksgiving(wLib);



}
}