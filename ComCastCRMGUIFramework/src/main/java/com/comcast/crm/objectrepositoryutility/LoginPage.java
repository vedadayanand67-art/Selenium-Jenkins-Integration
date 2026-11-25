package com.comcast.crm.objectrepositoryutility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
/**
 * *
 * @author vedas
 * 
 * Contains login page elements and business library like login()
 */
public class LoginPage  extends WebDriverUtility{//Rule-1 Create a separate java class
	                    //Rule-2 Object creation
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	
@FindBy(name="user_password")
private WebElement passwordEdt;
	
@FindBy(id="submitButton")
private WebElement loginBtn;//Rule-3 Object Initialization

//Rule 4 Object encapsulation
public WebElement getUsernameEdt() {
	return usernameEdt;
}

public WebElement getPasswordEdt() {
	return passwordEdt;
}

public WebElement getLoginBtn() {
	return loginBtn;

}
//Rule 5 provide action Business library 
/**
 * login to application based on username, password, business library
 * @param url
 * @param username
 * @param password
 */
public void loginToapp(String url,String username,String password)
{
	waitForPageToLoad(driver);
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));//
	driver.get(url);
	driver.manage().window().maximize();
	usernameEdt.sendKeys(username);
	passwordEdt.sendKeys(password);
	loginBtn.click();
	
}

}
