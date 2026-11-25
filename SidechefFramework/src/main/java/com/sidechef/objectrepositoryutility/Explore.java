package com.sidechef.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sidechef.genericutility.webdriverutility.WebDriverUtility;
import org.openqa.selenium.interactions.Actions;

public class Explore extends WebDriverUtility {
	WebDriver driver;
	 public Explore(WebDriver driver)
	 {
		 this.driver = driver;
	        PageFactory.initElements(driver, this);
	 }
	@FindBy(id="nav-explore")
	private WebElement explore;
	
	@FindBy(xpath="//div[text()='Your First Week Is on Us!']")
	private WebElement successMsg;

		@FindBy(xpath="//a[normalize-space()='Cooking Classes']")
	private WebElement cookingClasses;

	@FindBy(linkText="START COOKING")
	private WebElement startCooking;
	
	
	public void explore(WebDriverUtility wlib)
	{
	    wlib.waitForElementPresent(driver, By.id("nav-explore"));
	    wlib.mousemoveOnElement(driver, explore);
	}
	
	
	
	public boolean verifySuccessMsg()
	{
	    return successMsg.isDisplayed();
	}

	public void cookingClasses(WebDriverUtility wlib)
	{
	    wlib.waitAndClick(driver, By.linkText("Cooking Classes"));
	    cookingClasses.click();
	}
	
	public void exploreCookingClasses(WebDriverUtility wlib)
	{
	    wlib.mousemoveOnElement(driver, explore);

	    wlib.waitAndClick(driver,
	            By.xpath("//a[normalize-space()='Cooking Classes']"));

	    wlib.waitAndClick(driver,
	            By.linkText("START COOKING"));
	}

	public void startCooking(WebDriverUtility wlib)
	{
	    wlib.waitAndClick(driver, By.linkText("START COOKING"));
	    startCooking.click();
	}
	
	

	
	
	
	
}
