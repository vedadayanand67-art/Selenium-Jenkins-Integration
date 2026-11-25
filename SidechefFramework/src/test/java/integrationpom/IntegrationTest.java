package integrationpom;

import java.io.IOException;

import org.testng.annotations.Test;

import com.sidechef.baseclassutility.Baseclass;
import com.sidechef.baseclassutility.LoginBaseClass;
import com.sidechef.objectrepositoryutility.IngredientSelect;
import com.sidechef.objectrepositoryutility.RecipePage;
import com.sidechef.objectrepositoryutility.StartUpInstructions;

public class IntegrationTest extends Baseclass{

	@Test(groups="RT")
public void StartupInstruction() throws IOException
{
	  signUpUser();
	  // Complete startup instructions
      StartUpInstructions sui = new StartUpInstructions(driver);
      sui.instructions(wLib);

      // Click Quick and Easy Recipe
      RecipePage rp = new RecipePage(driver);
      rp.clickQuickEasyRecipe(wLib);
}
	
	
	@Test(groups="ST")
	  public void ingredientTest() throws IOException
    {
    	  signUpUser();
        IngredientSelect is = new IngredientSelect(driver);
        is.addApple();
    }
	
}
