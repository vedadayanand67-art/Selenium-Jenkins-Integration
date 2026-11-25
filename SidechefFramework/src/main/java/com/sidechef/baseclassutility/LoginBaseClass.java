package com.sidechef.baseclassutility;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import com.sidechef.objectrepositoryutility.SignInPage;

public class LoginBaseClass extends Baseclass{
    
	 @BeforeMethod(alwaysRun = true)
	    public void login() throws EncryptedDocumentException, IOException
	    {
	        System.out.println("Login");

	        String EMAIL = eLib.getDataFromExcel("Sheet1", 2, 3);

	        String PASSWORD = eLib.getDataFromExcel("Sheet1", 2, 4);

	        SignInPage sp = new SignInPage(driver);

	        sp.signIn(EMAIL, PASSWORD);
	    }
}
