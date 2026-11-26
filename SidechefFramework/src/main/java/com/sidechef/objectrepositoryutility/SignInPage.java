package com.sidechef.objectrepositoryutility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sidechef.genericutility.webdriverutility.WebDriverUtility;

public class SignInPage extends WebDriverUtility{
	WebDriverWait wait;
	WebDriver driver;
   

    public SignInPage(WebDriver driver) {
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

    public void acceptCookies() {

        try {
            WebElement cookie = new WebDriverWait(driver, Duration.ofSeconds(3))
                    .until(ExpectedConditions.presenceOfElementLocated(
                            By.xpath("//button[text()='Accept all']")));

            wait.until(ExpectedConditions.elementToBeClickable(cookie)).click();

        } catch (TimeoutException e) {
            System.out.println("Cookie popup not displayed");
        }
    }

    public void firstSignIn() {
        wait.until(ExpectedConditions.elementToBeClickable(signInBtn)).click();
    }

    public void email(String email) {
        wait.until(ExpectedConditions.visibilityOf(emailBtn)).sendKeys(email);
    }

    public void password(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordBtn)).sendKeys(password);
    }

    public void signInClickBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(signInClickBtn)).click();
    }

    public boolean verifySignIn() {
        wait.until(ExpectedConditions.visibilityOf(successMsg));
        return successMsg.isDisplayed();
    }

    public void signIn(String email, String password) {

        acceptCookies();

        firstSignIn();

        email(email);

        password(password);

        signInClickBtn();
    }
}