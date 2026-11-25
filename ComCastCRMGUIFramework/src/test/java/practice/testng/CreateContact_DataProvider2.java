package practice.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContact_DataProvider2 {

	@Test(dataProvider="getData" )
	public void CreateTest(String firstName,String lastName,long phoneNumber){
		System.out.println("FirstName: " + firstName
		        + ", Lastname: " + lastName
		        + ", PhoneNumber: " + phoneNumber);	}
	
	@DataProvider
	public Object[][] getData(){
		Object[][] objArr=new Object[3][3];
		objArr[0][0]="Veda";
		objArr[0][1]="SD";
		objArr[0][2]=973123246l;
		
		objArr[1][0]="SAM";
		objArr[1][1]="SH";
		objArr[1][2]=923439809l;
		
		objArr[2][0]="John";
		objArr[2][1]="Smith";
		objArr[2][2]=923439809l;
		
		return objArr;
		
	}

{
		
}
}
