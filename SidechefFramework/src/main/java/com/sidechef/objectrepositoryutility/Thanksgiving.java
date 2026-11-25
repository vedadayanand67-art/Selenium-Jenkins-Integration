package com.sidechef.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.sidechef.genericutility.webdriverutility.WebDriverUtility;

public class Thanksgiving extends WebDriverUtility{
	
	 WebDriver driver;
	 public Thanksgiving(WebDriver driver)
	 {
		 this.driver = driver;
	        PageFactory.initElements(driver, this);
	 }
	 
	 @FindBy(xpath="//span[text()='4 ratings']")
	 private WebElement ratings;
	 
	@FindBy(linkText="Thanksgiving Menu")
	private WebElement thanksgiving;

	@FindBy(xpath = "//h3[normalize-space()='Roasted Turkey Roulade']/ancestor::div[contains(@class,'recipe-card') and contains(@class,'not-selected')]/descendant::div[@class='checkmark-grid']")
	private WebElement check;
	
	@FindBy(id="email")
	private WebElement email;
	
	@FindBy(id="send-menu-button")
	private WebElement sendmymenu;
	
	@FindBy(xpath="//input[@placeholder='Email']")
	private WebElement emailbtn;
	
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement submit;
	
	@FindBy(xpath = "//a[@data-vars-event-name='view_cart']")
	private WebElement viewCart;
	
	public void thanksgiving()
	{
		thanksgiving.click();
	}
	public void email()
	{
		email.sendKeys("vedasd67@gmail.com");
	}
	public void check()
	{
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  System.out.println(
			        js.executeScript("return arguments[0].outerHTML;", check)
			    );

			    System.out.println(
			        js.executeScript("return arguments[0].parentElement.outerHTML;", check)
			    );
	}
	
	  public void thanksgiving(WebDriverUtility wlib)
	    {
		  Explore exp = new Explore(driver);

		  exp.explore(wlib);

		  // Wait for Thanksgiving Menu
		  wlib.waitAndClick(driver, By.linkText("Thanksgiving Menu"));

		  // Move mouse to Thanksgiving Menu
		  wlib.mousemoveOnElement(driver, thanksgiving);

		  // Click
		  thanksgiving.click();

		  System.out.println("Thanksgiving Menu clicked");
		  System.out.println("Current URL: " + driver.getCurrentUrl());
	        // Wait for recipe page
	        wlib.waitForElementPresent(driver,
	                By.xpath("//h3[normalize-space()='Roasted Turkey Roulade']/ancestor::div[contains(@class,'recipe-card') and contains(@class,'not-selected')]/descendant::div[@class='checkmark-grid']"));
	        // Select unchecked recipe
	        wlib.scrollToElement(driver, check);
	        wlib.scrollByAmount(driver, 0, -300);
	        wlib.waitAndClick(driver,
	                By.xpath("//h3[normalize-space()='Roasted Turkey Roulade']/ancestor::div[contains(@class,'recipe-card') and contains(@class,'not-selected')]//div[@class='checkmark-grid']"));

	        check.click();

	       

	        // Click Send My Menu
	        wlib.waitAndClick(driver, By.id("send-menu-button"));

	        sendmymenu.click();
emailbtn.sendKeys("vedasd67@gmail.com");
submit.click();
viewCart.click();

	        
	    }
	  
	  public void verifyViewCart() {

	      // Execute your scenario steps

		  SoftAssert sa = new SoftAssert();

		  By cart = By.xpath("//a[@data-vars-event-name='view_cart']");

		  waitAndClick(driver, cart);

		  sa.assertTrue(viewCart.isDisplayed(), "View Cart button is not displayed");

		  waitAndClick(driver, cart);

		  sa.assertAll();

	  }
	}
	