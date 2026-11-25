package practice.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContact_DataProvider {

	@Test(dataProvider="getData" )
	public void CreateTest(String firstName,String lastName){
		System.out.println("FirstName :"  +firstName +", Lastname :" +lastName);
	}
	
	@DataProvider
	public Object[][] getData(){
		Object[][] objArr=new Object[3][2];
		objArr[0][0]="Veda";
		objArr[0][1]="SD";
		
		objArr[1][0]="SAM";
		objArr[1][1]="SH";
		
		objArr[2][0]="John";
		objArr[2][1]="Smith";
		
		return objArr;
		
	}

{
		
}
}
