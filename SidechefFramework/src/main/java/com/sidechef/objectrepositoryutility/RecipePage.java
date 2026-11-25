package com.sidechef.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sidechef.genericutility.webdriverutility.WebDriverUtility;

public class RecipePage extends WebDriverUtility {
	 WebDriver driver;
	 public RecipePage(WebDriver driver)
	 {
		 this.driver = driver;
	        PageFactory.initElements(driver, this);
	 }
    @FindBy(id="nav-recipe")
    private WebElement recipe;
    
    @FindBy(linkText="Comfort Food")
    private WebElement comfortFood;
    
    @FindBy(xpath="//*[normalize-space()='Chicken Paprikash']")
    private WebElement chickenPaprikash;
    
    @FindBy(xpath="//a[normalize-space()='Quick & Easy']")
    private WebElement quickEasy;

    @FindBy(xpath="//h3[normalize-space()='Barbecue Chicken Quesadillas']")
    private WebElement quesadillas;
    
    @FindBy(xpath="//div[normalize-space()='VIEW RECIPE']")
    private WebElement viewRecipe;
    
    @FindBy(xpath="//span[text()='Comfort Food']")
    private WebElement recipeValidation;
    
    @FindBy(xpath="//h3[text()='Teriyaki Chicken']")
    private WebElement teriyakiChicken;
    
    @FindBy(xpath="//div[text()='Add 7 Ingredients']")
    private WebElement addIngredients;
    
    @FindBy(xpath="//h2[text()='Viral Recipes You’ll Want to Try ASAP']")
    private WebElement viralRecipes;
    
    public void comfortfood()
    {
        waitForElementPresent(driver, By.id("nav-recipe"));

        mousemoveOnElement(driver, recipe);

        waitAndClick(driver, By.linkText("Comfort Food"));
    }
    public boolean verifRecipeResult()
    {
        waitForElementPresent(driver,
            By.xpath("//h1[text()='Comfort Food Recipes']"));

        return recipeValidation.isDisplayed();
    }

    public boolean verifyViralRecipes()
    {
        return !driver.findElements(
            By.xpath("//h2[text()='Viral Recipes You’ll Want to Try ASAP']")
        ).isEmpty();
    }
    
    public void getRecipe(WebDriverUtility wlib)
    {
        wlib.mousemoveOnElement(driver, recipe);

        wlib.waitAndClick(driver, By.linkText("Comfort Food"));
    }
    
    public void clickQuickEasyRecipe(WebDriverUtility wlib)
    {
        wlib.mousemoveOnElement(driver, recipe);

        wlib.waitAndClick(driver,
                By.xpath("//a[normalize-space()='Quick & Easy']"));

     
        
    }
    
    public boolean verifyQuickEasyRecipe()
    {
        return driver.findElement(By.xpath("//h2[text()='//h2[text()='Viral Recipes You’ll Want to Try ASAP']")).isDisplayed();
    }
    
  
    public void clickChickenPaprikash(WebDriverUtility wlib)
    {
        wlib.waitAndClick(driver, By.xpath("//*[normalize-space()='Chicken Paprikash']"));

        wlib.scrollToElement(driver, chickenPaprikash);

        chickenPaprikash.click();
    }
    
   
    
   

}
    


