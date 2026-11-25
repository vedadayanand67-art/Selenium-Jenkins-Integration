package com.sidechef.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sidechef.genericutility.webdriverutility.WebDriverUtility;

public class SearchPage extends WebDriverUtility {
WebDriver driver=null;
public SearchPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

@FindBy(xpath="//input[@data-testid='search input']")
private WebElement searchInput;

@FindBy(xpath="//button[@data-testid='submit button']")
private WebElement searchBtn;

@FindBy(xpath="//*[normalize-space()='Vegan Caesar Salad']/ancestor::*[.//*[name()='svg' and contains(@class,'Bookmark__Icon-sc-ee4bb2d5-0')]][1]//*[name()='svg' and contains(@class,'Bookmark__Icon-sc-ee4bb2d5-0')]")
private WebElement bookmark;


public boolean verifySearchResult()
{
    waitForElementPresent(driver,
        By.xpath("//*[normalize-space()='Vegan Caesar Salad']/ancestor::*[.//*[name()='svg' and contains(@class,'Bookmark__Icon-sc-ee4bb2d5-0')]][1]//*[name()='svg' and contains(@class,'Bookmark__Icon-sc-ee4bb2d5-0')]"));

    return bookmark.isDisplayed();
}    

public void searchInput() {
	searchInput.sendKeys("Caesar salad");
}

public void searchBtn() {
	searchBtn.click();;
}

public void bookmark()
{
	bookmark.click();
}
public void Search()
{
	searchInput();
	searchBtn();
}

public void saveBookmark()
{
	searchInput();
	searchBtn();
	bookmark();
}
}
