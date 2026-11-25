package com.sidechef.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sidechef.genericutility.webdriverutility.WebDriverUtility;

public class ShoppingList extends WebDriverUtility{
	 WebDriver driver;

	    public ShoppingList(WebDriver driver)
	    {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    @FindBy(xpath="//button[text()='Accept all']")
	    private WebElement acceptAll;

	    @FindBy(id="nav-recipe")
	    private WebElement recipeOptn;

	    @FindBy(linkText="Comfort Food")
	    private WebElement comfortFoodOptn;

	    @FindBy(xpath="//div[text()='Kid-Friendly']")
	    private WebElement kidFriendly;


	    public void recipe()
	    {
	        mousemoveOnElement(driver, recipeOptn);
	    }





public void comfortFood()
{
    mousemoveOnElement(driver, recipeOptn);

    mousemoveOnElement(driver, comfortFoodOptn);

    waitAndClick(driver, By.linkText("Comfort Food"));

    comfortFoodOptn.click();

    System.out.println("Comfort Food clicked");

    waitForPageToLoad(driver);

    JavascriptExecutor js = (JavascriptExecutor) driver;

    js.executeScript(
        "arguments[0].scrollIntoView({block:'center'});", kidFriendly);

    System.out.println("Scrolled to Kid-Friendly");

    waitAndClick(driver, By.xpath("//div[text()='Kid-Friendly']"));

    System.out.println("Kid-Friendly found");

    kidFriendly.click();
}

}



    
    
    
    

