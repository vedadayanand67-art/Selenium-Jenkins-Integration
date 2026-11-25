package practice.testng;

import org.testng.annotations.Test;

class CreateContactTest1 {

	
	@Test(groups="smokeTest")
	public void createContact()
	{
		System.out.println("Execute create contact--->HDFC");
	}
	

@Test(dependsOnMethods="createContact")
	public void modifyContact()
	{
		System.out.println("Create contact ICIC");
		System.out.println("Execute modify contact-->HDFC=>ICICI");
	}
	

	@Test(dependsOnMethods="modifyContact")
	public void deleteContact()
	{
		System.out.println("Create UPI contact");
		System.out.println("Execute delete contact-->ICICI");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
