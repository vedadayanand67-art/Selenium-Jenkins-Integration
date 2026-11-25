package practice.testng;

import org.testng.annotations.Test;

public class CreateOrderTest {
@Test(invocationCount=10)
public void createOrderTest()
{
	System.out.println("Execute createOrderTest");
	String str=null;
	System.out.println(str.equals("123"));
}

@Test(dependsOnMethods="createOrderTest")

public void billingOrderTest()
{
	System.out.println("Execute billingOrderTest");
}
}

