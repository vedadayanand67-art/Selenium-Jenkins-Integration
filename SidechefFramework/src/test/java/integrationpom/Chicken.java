package integrationpom;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.sidechef.baseclassutility.LoginBaseClass;
import com.sidechef.objectrepositoryutility.ChickenPaprikash;
import com.sidechef.objectrepositoryutility.RecipePage;
import org.testng.Assert;

public class Chicken {
	public class ChickenPaprikashRatings extends LoginBaseClass {

	    @Test
	    public void chickenPaprikashRatings() {

	        RecipePage rp = new RecipePage(driver);
	        rp.comfortfood();        
	        

	        ChickenPaprikash cp = new ChickenPaprikash(driver);
	        cp.openChicken();


Assert.assertTrue(cp.verifyChickenPage(),
        "Chicken Paprikash page is not opened");
	    }
	}
}
