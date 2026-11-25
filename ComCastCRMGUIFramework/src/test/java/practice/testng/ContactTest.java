package practice.testng;

import org.testng.annotations.Test;

public class ContactTest {


	@Test(groups="regressionTest")
	 public void test() {
        System.out.println("Test is running");
    }
	
	@Test(groups="smokeTest")
	 public void test1() {
       System.out.println("Test is running");
      
   }
	
}
