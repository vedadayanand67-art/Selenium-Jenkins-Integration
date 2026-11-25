package com.sidechef.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sidechef.genericutility.webdriverutility.WebDriverUtility;

public class CPRatings extends WebDriverUtility{

	 WebDriver driver;
	 public CPRatings(WebDriver driver)
	 {
		 this.driver = driver;
	        PageFactory.initElements(driver, this);
	 }
	 
	 @FindBy(xpath="//h2[@class='css-cjdh47' and normalize-space()='4.3']")
	 private WebElement ratings;
	 
	 @FindBy(xpath="")
	 private WebElement fourstar;
	 
	 public void ratings(WebDriverUtility wlib)
	 {
	     wlib.waitAndClick(driver, By.xpath("//h2[@class='css-cjdh47' and normalize-space()='4.3']"));
	     ratings.click();

	     wlib.scrollToElement(driver, fourstar);

	     wlib.waitAndClick(driver, By.xpath(""));
	     wlib.doubleClick(driver, fourstar);
	 }
	 
	 
	 
}
