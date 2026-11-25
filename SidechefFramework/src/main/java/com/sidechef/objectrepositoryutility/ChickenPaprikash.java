package com.sidechef.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.sidechef.genericutility.webdriverutility.WebDriverUtility;
import org.openqa.selenium.interactions.Actions;

public class ChickenPaprikash extends WebDriverUtility{
	Actions act;
	 WebDriver driver;
	 public ChickenPaprikash(WebDriver driver)
	 {
		 this.driver = driver;
	        PageFactory.initElements(driver, this);
	        act = new Actions(driver);
	 }
	 @FindBy(xpath = "//*[normalize-space()='Chicken Paprikash']")
	    private WebElement chicken;
	 
	 @FindBy(xpath = "//h1[text()='Chicken Paprikash']")
	 private WebElement chickenTitle;

	 public boolean verifyChickenPage() {
	     return chickenTitle.isDisplayed();
	 }

	 public void openChicken() {
		 waitForElementPresent(driver,
			        By.xpath("//*[normalize-space()='Chicken Paprikash']"));

			    act.scrollToElement(chicken).perform();

			    waitAndClick(driver,
			        By.xpath("//*[normalize-space()='Chicken Paprikash']"));

		    		}
	}