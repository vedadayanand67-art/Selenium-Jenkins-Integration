package com.sidechef.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sidechef.genericutility.webdriverutility.WebDriverUtility;

public class SignInPage extends WebDriverUtility{

    WebDriver driver;
    
    public SignInPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//button[text()='Accept all']")
    private WebElement acceptAllBtn;
    
    @FindBy(linkText="SIGN IN")
    private WebElement signInBtn;
    
    @FindBy(xpath="//input[@placeholder='Email']")
    private WebElement emailBtn;
    
    @FindBy(xpath="//input[@placeholder='Password']")
    private WebElement passwordBtn;
    
    @FindBy(xpath="//div[text()='SIGN IN']")
    private WebElement signInClickBtn;
    
    @FindBy(xpath="//input[@placeholder='What are you craving today?']")
    private WebElement successMsg;
 
    public void acceptCookies()
    {
        if(!driver.findElements(By.xpath("//button[text()='Accept all']")).isEmpty())
        {
            acceptAllBtn.click();
        }
    }
    
    public void firstSignIn()
    {
        signInBtn.click();
    }
    
    public void email(String email)
    {
    	 emailBtn.sendKeys(email);
    }
    
    public void password(String password)
    {
        passwordBtn.sendKeys(password);
    } 
    
    public void signInClickBtn()
    {
    	signInClickBtn.click();
    }
    
    public boolean verifySignIn()
    {
        waitForElementPresent(driver,
            By.xpath("//input[@placeholder='What are you craving today?']"));

        return successMsg.isDisplayed();
    }
    
    public void signIn(String email, String password)
    {
    	acceptCookies();        
    	firstSignIn();
    	acceptCookies();
        email(email);
        password(password);
        signInClickBtn();
    }
}
