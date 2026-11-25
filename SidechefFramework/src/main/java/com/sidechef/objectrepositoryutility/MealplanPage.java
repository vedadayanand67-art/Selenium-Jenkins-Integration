package com.sidechef.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sidechef.genericutility.webdriverutility.WebDriverUtility;

public class MealplanPage extends WebDriverUtility {
WebDriver driver;
public MealplanPage(WebDriver driver)
{
	 this.driver = driver;
       PageFactory.initElements(driver, this);
}
@FindBy(id="nav-meal-plans")
private WebElement mealPlanBtn;

@FindBy(xpath="//*[normalize-space()='Personalize Your Plan']")
private WebElement personalizeYourPlan;

@FindBy(xpath="//button[normalize-space()='ADD ALL TO CART']")
private WebElement cartBtn;

@FindBy(xpath="//img[contains(@alt,'user avatar')]")
private WebElement signout;

@FindBy(xpath="//a[contains(normalize-space(.),'Sign Out')]")
private WebElement signOutLink;

public void mealPlan(WebDriverUtility wlib)
{
    wlib.mousemoveOnElement(driver, mealPlanBtn);
}

public void personalizeYourPlan()
{
    personalizeYourPlan.click();
}

public void addTOCART(WebDriverUtility wlib)
{
    wlib.waitAndClick(driver, By.xpath("//button[normalize-space()='ADD ALL TO CART']"));
    cartBtn.click();
}

public void signout()
{
    signout.click();
}

public void signOutLink()
{
    signOutLink.click();
}

public void mealPlans(WebDriverUtility wlib)
{
    wlib.mousemoveOnElement(driver, mealPlanBtn);

    wlib.waitAndClick(driver, By.xpath("//*[normalize-space()='Personalize Your Plan']"));

    personalizeYourPlan.click();

    addTOCART(wlib);
    
    signout();
    
    signOutLink();
}
}
