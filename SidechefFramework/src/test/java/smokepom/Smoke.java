package smokepom;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.sidechef.baseclassutility.LoginBaseClass;
import com.sidechef.listener.ListenerImplementation;
import com.sidechef.objectrepositoryutility.RecipePage;
import com.sidechef.objectrepositoryutility.SearchPage;
import com.sidechef.objectrepositoryutility.SignInPage;
@Listeners(com.sidechef.listener.ListenerImplementation.class)
public class Smoke extends LoginBaseClass {
	
	@Test(groups="ST")
	  public void signInTest()
    {
		
        SignInPage sp = new SignInPage(driver);

        Assert.assertTrue(sp.verifySignIn(), "Login Failed");

        System.out.println("Sign In test executed");
    }
	
	
    
	
	 @Test(groups="RT")
	 public void recipeTest()
	    {
	        RecipePage rp = new RecipePage(driver);

	        rp.getRecipe(wLib);
	    }
	
	@Test(groups="ST")
	public void searchTest()
    {	
    	    SearchPage srp = new SearchPage(driver);

    	    srp.Search();

    	    Assert.assertTrue(srp.verifySearchResult(), "Searchtest failed");

    	    System.out.println("Search result displayed");	  
    }

}
