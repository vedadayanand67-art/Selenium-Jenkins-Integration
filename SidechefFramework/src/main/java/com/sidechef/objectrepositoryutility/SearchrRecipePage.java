package com.sidechef.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sidechef.genericutility.webdriverutility.WebDriverUtility;

public class SearchrRecipePage {
	 WebDriver driver;

	 public SearchrRecipePage(WebDriver driver)
	 {
		 this.driver = driver;
	        PageFactory.initElements(driver, this);
	 }

	    @FindBy(xpath="//input[@placeholder='What are you craving today?']")
	    private WebElement searchEdt;

	    @FindBy(xpath="//button[text()='Search']")
	    private WebElement searchBtn;

	    @FindBy(xpath="//div[@data-testid='save recipe']")
	    private WebElement saveRecipe;


	    public void searchRecipe(WebDriverUtility wlib)
	    {
	        searchEdt.sendKeys("Vegan caesar salad");
	        searchBtn.click();

	        wlib.waitAndClick(driver,
	            By.xpath("//div[@data-testid='save recipe']"));

	        saveRecipe.click();
	    }


	    public void veganCaesarSalad(WebDriverUtility wlib)
	    {
	        searchRecipe(wlib);
	       
	    }
	}

