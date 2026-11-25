package com.sidechef.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sidechef.genericutility.webdriverutility.WebDriverUtility;



public class SheetCake extends WebDriverUtility {
	WebDriver driver;
	 public SheetCake(WebDriver driver)
	 {
		 this.driver = driver;
	        PageFactory.initElements(driver, this);
	 }
	@FindBy(id="nav-recipe")
	private WebElement recipe;

	@FindBy(xpath="//a[normalize-space()='Lunch']")
	private WebElement lunch;
	
	/*@FindBy(xpath="//h3[normalize-space()='White Texas Sheet Cake']")
	private WebElement WhiteTexas;*/
	
	@FindBy(xpath="//h3[normalize-space()='Greek Chickpea Salad']")
	private WebElement greekChickpeaSalad;
	
	@FindBy(xpath="//*[normalize-space()='VIEW RECIPE']")
	private WebElement viewRecipe;

	@FindBy(xpath="//div[text()='Save Recipe']")
	private WebElement saveRecipe;

	@FindBy(xpath="//img[contains(@alt,'user avatar')]")
	private WebElement signout;

	@FindBy(xpath="//a[contains(normalize-space(.),'Sign Out')]")
	private WebElement signOutLink;
	
	@FindBy(xpath="//input[@placeholder='Email']")
	private WebElement email;
	
	public void recipe(WebDriverUtility wlib)
	{
	    wlib.mousemoveOnElement(driver, recipe);
	}

	public void lunch()
	{
	    lunch.click();
	}

	public void greekchickpeasalad()
	{
	    WebElement cake = driver.findElement(
	        By.xpath("//h3[normalize-space()='Greek Chickpea Salad']"));

	    Actions act = new Actions(driver);
	    act.scrollToElement(cake).perform();
	    cake.click();

	    System.out.println("Current URL: " + driver.getCurrentUrl());
	    System.out.println("Page Title: " + driver.getTitle());
	}
	

	public void viewRecipe()
	{
	    System.out.println("Inside viewRecipe method");

	    boolean status = driver.findElements(
	        By.xpath("//*[normalize-space()='VIEW RECIPE']")
	    ).size() > 0;

	    System.out.println("View Recipe found: " + status);
	}


	public void signout()
	{
	    signout.click();
	}

	public void signOutLink()
	{
	    signOutLink.click();
	}
	
	public void lunchRecipe(WebDriverUtility wlib)
	{
	    recipe(wlib);
	    lunch();
	    greekchickpeasalad();
	    viewRecipe();
	    
	}
}
