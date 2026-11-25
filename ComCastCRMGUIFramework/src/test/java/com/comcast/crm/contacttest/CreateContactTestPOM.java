package com.comcast.crm.contacttest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.HomePage;

public class CreateContactTestPOM extends BaseClass {
	
	@Test
	public void createContactTest() throws EncryptedDocumentException, IOException
	{
		String lastName=eLib.getDataFromExcel("contact", 1, 2) +jLib.getRandomNumber();
	}
	
	//Step 2:Navigate to contact module
HomePage hp=new HomePage(driver);

	
	

}
