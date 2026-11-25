package com.sidechef.genericutility.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	public void waitForPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	}
	public void maximize(WebDriver driver)
	{
		driver.manage().window().maximize();
	}

	/*public void waitFoRElementPresent(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}*/

	public void waitForElementPresent(WebDriver driver, By locator)
	{
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	public void switchToTabOnURL(WebDriver driver,String partialURL)
	{
		Set<String> set=	driver.getWindowHandles();
		Iterator<String> it=set.iterator();
		while(it.hasNext())
		{
			String windowID=it.next();
			driver.switchTo().window(windowID);
			String actUrl=driver.getCurrentUrl();
			if(actUrl.contains(partialURL))
			{
				break;
			}
		}
	}
	public void switchToTabOnTitle(WebDriver driver,String partialTitle)
	{
		Set<String> set=	driver.getWindowHandles();
		Iterator<String> it=set.iterator();
		while(it.hasNext())
		{
			String windowID=it.next();
			driver.switchTo().window(windowID);
			String actUrl=driver.getTitle();
			if(actUrl.contains(partialTitle))
			{
				break;
			}
		}
		
	}
	public void switchtoFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	public void switchToFrame(WebDriver driver,String nameID)
	{
		driver.switchTo().frame(nameID);
	}

	public void switchToFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}

	public void switchToAlertAndAccept(WebDriver driver)
		{
			driver.switchTo().alert().accept();
		}
		
	public void switchToAlertAndCancel(WebDriver driver)
		{
			driver.switchTo().alert().dismiss();
		}
	public void scrollByAmount(WebDriver driver, int x, int y)
	{
	    Actions act = new Actions(driver);
	    act.scrollByAmount(x, y).perform();
	}

	public void select(WebElement element,String text)
		{
			Select sel=new Select(element);
			sel.selectByVisibleText(text);
		}

	public void select(WebElement element,int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
		
	public void mousemoveOnElement(WebDriver driver, WebElement element) 
		{
			Actions act=new Actions(driver);
		act.moveToElement(element)	.perform();
		}
		
		
	public void doubleClick(WebDriver driver, WebElement element) 
	{
		Actions act=new Actions(driver);
	act.doubleClick(element).perform();
	}
	
	
	
	public void waitAndClick(WebDriver driver, By locator)
	{
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}
	
	public void scrollToElement(WebDriver driver, WebElement element)
	{
	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    js.executeScript("arguments[0].scrollIntoView({block:'center'});", element);
	}
	
	public void javaScriptClick(WebDriver driver, WebElement element)
	{
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click();", element);
	}
	
	}


