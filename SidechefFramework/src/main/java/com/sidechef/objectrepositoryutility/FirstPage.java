package com.sidechef.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sidechef.genericutility.webdriverutility.JavaUtility;
import com.sidechef.genericutility.webdriverutility.WebDriverUtility;

public class FirstPage extends WebDriverUtility{
	
	    WebDriver driver;

	    public FirstPage(WebDriver driver)
	    {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    @FindBy(xpath="//button[text()='Accept all']")
	    private WebElement acceptAllBtn;

	    @FindBy(linkText="SIGN UP")
	    private WebElement signUp;
	    
	    @FindBy(xpath = "//*[contains(text(),'Welcome to SideChef!')]")
	    private WebElement success;

	   
	    @FindBy(xpath="//div[@data-testid='email-signup']")
	    private WebElement signupwithEmailBtn;

	    @FindBy(xpath="//input[@placeholder='What should we call you?']")
	    private WebElement userNameBtn;

	    @FindBy(xpath="//input[@placeholder='Email']")
	    private WebElement emailBtn;

	    @FindBy(xpath="//input[@placeholder='Password']")
	    private WebElement passwordBtn;

	    @FindBy(xpath="//div[@data-testid='signup']")
	    private WebElement signUpBtn;
	    
	    @FindBy(xpath="//*[normalize-space()='Welcome to SideChef!']")
	    private WebElement successMsg;


	    public void acceptCookies()
	    {
	        if(!driver.findElements(By.xpath("//button[text()='Accept all']")).isEmpty())
	        {
	            acceptAllBtn.click();
	        }
	    }

	    public void clickSignUp()
	    {
	        signUp.click();
	    }

	    public void clickSignupWithEmail()
	    {
	        signupwithEmailBtn.click();
	    }

	    public void enterUserName(String username)
	    {
	        userNameBtn.sendKeys(username);
	    }

	    public void enterEmail(String email)
	    {
	        emailBtn.sendKeys(email);
	    }

	    public void enterPassword(String password)
	    {
	        passwordBtn.sendKeys(password);
	    }

	    public void clickSignUpBtn()
	    {
	        signUpBtn.click();
	    }
	    
	    
	    public boolean verifySignUp()
	    {
	        return successMsg.isDisplayed();
	    }
	    
	    public void signUp(String username, String email, String password)
	    {
	        acceptCookies();
	        clickSignUp();
	        clickSignupWithEmail();
	        enterUserName(username);
	        enterEmail(email);
	        enterPassword(password);
	        clickSignUpBtn();
	    }
	    }
	

