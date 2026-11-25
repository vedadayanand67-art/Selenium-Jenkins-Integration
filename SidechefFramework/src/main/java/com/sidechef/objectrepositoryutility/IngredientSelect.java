package com.sidechef.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sidechef.genericutility.webdriverutility.WebDriverUtility;

public class IngredientSelect extends WebDriverUtility  {
	 WebDriver driver;
	 public IngredientSelect(WebDriver driver)
	 {
		 this.driver = driver;
	        PageFactory.initElements(driver, this);
	 }
	 
	 @FindBy(id="my-pantry")
	 private WebElement pantry;

	 @FindBy(xpath="//button[text()='Add Ingredients']")
	 private WebElement addIngredient;
	 
	 @FindBy(xpath="//input[@type='search']")
	 private WebElement search;	 

	 @FindBy(xpath = "//div[text()='Apple']/ancestor::div[@class='TranslateCard__TranslateCardDiv-sc-58eedab1-1 IngredientCard__Container-sc-51623ff4-0 kANtTv cwgEyI ingredients-card']//*[local-name()='circle' and @stroke='var(--primary-icon-color)']")
	 private WebElement apple;	

@FindBy(xpath="//div[text()='CONFIRM SELECTION']")
private WebElement confirmselection;

public void clickMyPantry()
{
    pantry.click();
}

public void clickAddIngredient()
{
    addIngredient.click();
}

public void searchIngredient(String ingredient)
{
    search.sendKeys(ingredient);
}

public void clickApple()
{
    apple.click();
}

public boolean verifyPantryItem()
{
    return driver.findElement(By.xpath("//div[@class='ant-list-item PantryListView__AnimatedListItem-sc-2a5a610e-0 kZymRe']")).isDisplayed();
}
public void clickConfirmSelection()
{
    confirmselection.click();
}
public void addApple()
{
    pantry.click();
    addIngredient.click();
    search.sendKeys("Apple");
    apple.click();
    confirmselection.click();
}

}


