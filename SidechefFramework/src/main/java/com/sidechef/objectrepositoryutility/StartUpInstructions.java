package com.sidechef.objectrepositoryutility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sidechef.genericutility.webdriverutility.WebDriverUtility;

public class StartUpInstructions extends WebDriverUtility{
	 WebDriver driver;
	 public StartUpInstructions(WebDriver driver)
	 {
		 this.driver = driver;
	        PageFactory.initElements(driver, this);
	 }
	 
	 @FindBy(xpath="//button[normalize-space()='START ONBOARDING']")
	 private WebElement onboardBtn;
	 
	 @FindBy(xpath="//div[text()='Vegan']")
	 private WebElement veganBtn;
	 
	 @FindBy(xpath="//button[text()='NEXT']")
	 private WebElement nextBtn;
	 
	 @FindBy(xpath="//div[normalize-space()='Eat Healthy']")
	 private WebElement eatHealthyBtn;
	 
	 @FindBy(xpath="//button[text()='NEXT']")
	 private WebElement next1Btn;
	 
	 @FindBy(xpath="//button[text()='GET STARTED']")
	 private WebElement getStarted;
	 
	 public void OnboardBtn() {
		 onboardBtn.click();
	 }

	 public void VeganBtn() {
		 veganBtn.click();
	 }

	 public void NextBtn() {
		 nextBtn.click();
	 }
		 
	 public void eatHealthy() {
		 eatHealthyBtn.click();
	 }
	 
	 public void Next1Btn() {
		 next1Btn.click();
	 }
	 
		 public void startedBtn() {
			 getStarted.click();
		 }
		 
		
		 public void instructions(WebDriverUtility wlib)
		 {
		     wlib.waitAndClick(driver, By.xpath("//button[normalize-space()='START ONBOARDING']"));

		     wlib.waitAndClick(driver, By.xpath("//div[text()='Vegan']"));

		     wlib.waitAndClick(driver, By.xpath("//button[text()='NEXT']"));

		     wlib.waitForPageToLoad(driver);

		     wlib.waitAndClick(driver, By.xpath("//div[normalize-space()='Eat Healthy']"));

		     wlib.waitAndClick(driver, By.xpath("//button[text()='NEXT']"));

		     wlib.waitAndClick(driver, By.xpath("//button[text()='GET STARTED']"));
		     
		     
		 } 
			 
			 
		 }

	 
	 
	 
	 

	 
	 

