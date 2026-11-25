package com.sidechef.baseclassutility;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.sidecfhef.genericutility.fileutility.ExcelUtility;
import com.sidecfhef.genericutility.fileutility.FileUtility;
import com.sidechef.genericutility.webdriverutility.JavaUtility;
import com.sidechef.genericutility.webdriverutility.UtilityClassObject;
import com.sidechef.genericutility.webdriverutility.WebDriverUtility;
import com.sidechef.objectrepositoryutility.FirstPage;

public class Baseclass {

	public FileUtility fLib = new FileUtility();
    public ExcelUtility eLib = new ExcelUtility();
    public JavaUtility jLib = new JavaUtility();
    public WebDriverUtility wLib = new WebDriverUtility();
    public WebDriver driver= null;
    public static WebDriver sdriver=null;

    @Parameters("BROWSER")
    @BeforeClass(groups= {"ST","RT"})
    public void configBC(@Optional("chrome") String browser) throws IOException
    {
    	{
    	    System.out.println("Launch the browser");

        String BROWSER = browser;
        		fLib.getDataFromPropertiesFile("browser");

        if(BROWSER.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver(); }
        else if(BROWSER.equalsIgnoreCase("firefox"))
        {
            driver = new FirefoxDriver();
        }
        else if(BROWSER.equalsIgnoreCase("edge"))
        {
            driver = new EdgeDriver();
        }
        else
        {
            driver = new ChromeDriver();
        }
        sdriver=driver;
      UtilityClassObject.setDriver(driver);

      wLib.maximize(driver);
       // System.out.println("Browser launched: " + driver);//
        
    }
    }

    @BeforeMethod(groups= {"ST","RT"})
    public void configBM() throws IOException
    {
        String URL = fLib.getDataFromPropertiesFile("url");

        driver.get(URL);
        wLib.waitForPageToLoad(driver);  
    }
    
    public void signUpUser() throws IOException
    {
        String USERNAME = eLib.getDataFromExcel("Sheet1", 1, 2);

        String EMAIL = eLib.getDataFromExcel("Sheet1", 1, 3)
                .replace("@", jLib.getRandomNumber() + "@");

        String PASSWORD = eLib.getDataFromExcel("Sheet1", 1, 4);

        FirstPage fp = new FirstPage(driver);

        fp.signUp(USERNAME, EMAIL, PASSWORD);

        Assert.assertTrue(fp.verifySignUp(), "Signup Failed");

        System.out.println("Signup Successful");
    }


    @AfterMethod(groups= {"ST","RT"})
    public void configAM()
    {
        System.out.println("Logout");

        String avatar = "//img[contains(@alt,'user avatar')]";
        String signOut = "//a[contains(normalize-space(.),'Sign Out')]";

        if(!driver.findElements(By.xpath(avatar)).isEmpty())
        {
            WebElement signout = driver.findElement(By.xpath(avatar));

            Actions act = new Actions(driver);
            act.moveToElement(signout).click().perform();

            wLib.waitAndClick(driver, By.xpath(signOut));

                    }
    }


    @AfterClass(groups = {"ST", "RT"})
    public void configAC()
    {
        System.out.println("Close the browser");

        if(driver != null)
        {
            driver.quit();
        }
    }

    

    }
