import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
@DataProvider
public Object[][] getData(){
	Object[][] data= {
			{"test1@gmail.com"  ,    "pass1" },
			{ "test2@gmail.com",  "pass2"    }
	};
	return data;
}
	@Test(dataProvider="getData")
	public void loginTest(String email,String password)
	{
		System.out.println(email+" "+password);
	}
}

