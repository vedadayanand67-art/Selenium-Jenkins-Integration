package systempom;

import org.testng.annotations.Test;

import com.sidechef.baseclassutility.Baseclass;
import com.sidechef.baseclassutility.LoginBaseClass;
import com.sidechef.objectrepositoryutility.ShoppingList;

public class ShoppingListTest extends LoginBaseClass {

	   @Test
	    public void shoppingListTest() {

	        ShoppingList sl = new ShoppingList(driver);

	        sl.recipe();

	        sl.comfortFood();
	    }
	}
