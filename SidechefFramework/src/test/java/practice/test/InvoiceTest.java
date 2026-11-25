package practice.test;

import org.testng.annotations.Test;
import org.testng.Assert;
public class InvoiceTest {
@Test(retryAnalyzer=com.sidechef.listener.RetryListenerImp.class)
public void activateSim()
{
	System.out.println("execute createInvoiceTest");
	Assert.assertEquals("","Login");
	System.out.println("step-1");
	System.out.println("step-2");
	System.out.println("step-3");
	System.out.println("step-4");
}

}
