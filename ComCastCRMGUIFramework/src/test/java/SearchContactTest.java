import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class SearchContactTest extends BaseClass{
/**
 * Scenario:login()==>navigateContact==>createcontact()==verify
 * 
 */
	


/**
 * test class for contact module
 * @author vedas
 */


	
	@Test
	public void searchcontactTest()
	{
		/*Step 1:login to app   */
	LoginPage lp=new LoginPage(driver);
	lp.loginToapp("url", "username", "password");
	}

}
