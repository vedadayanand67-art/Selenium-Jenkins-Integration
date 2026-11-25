package practice.png;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.sidechef.baseclassutility.Baseclass;

public class SampleReportTestFirst {
	public ExtentReports report;
	@BeforeSuite
	public void configBS()
	{
		//Spark report config
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("Recipe Results");
		spark.config().setReportName("Sidechef report");
		spark.config().setTheme(Theme.DARK);
		
		//add env information and create test
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-11");
		report.setSystemInfo("BROWSER", "CHROME-100");
	}
	
	@AfterSuite
	public void configAS()
	{
		report.flush();
	}
	
@Test
public void Recipe()
{
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.sidechef.com");
	
	   TakesScreenshot eDriver = (TakesScreenshot)driver;
       String filePath = eDriver.getScreenshotAs(OutputType.BASE64);
       
      
	
	
	ExtentTest test=report.createTest("Recipe");
	
	test.log(Status.INFO,"Login to app");
test.log(Status.INFO,"Navigate to recipe");
	test.log(Status.INFO,"Click on comfort food");
	if("HFC".equals("HDFC"))
	{
		test.log(Status.PASS,"Recipe result is displayed");
	}else {
		test.addScreenCaptureFromBase64String(filePath,"ErrorFile");
	}
	driver.close();
	
}

@Test
public void Search()
{
	//Spark report config
	
	ExtentTest test=report.createTest("Recipe");
	
	test.log(Status.INFO,"Login to app");
test.log(Status.INFO,"Navigate to recipe");
	test.log(Status.INFO,"Click on comfort food");
	if("HDFC".equals("HDFC"))
	{
		test.log(Status.PASS,"Recipe result is displayed");
	}else {
		test.log(Status.FAIL,"Recipe result is not displayed");
	}
}
	
@Test
	public void Signin()
	{
		//Spark report config
		
		ExtentTest test=report.createTest("Recipe");
		
		test.log(Status.INFO,"Login to app");
	test.log(Status.INFO,"Navigate to recipe");
		test.log(Status.INFO,"Click on comfort food");
		if("HDFC".equals("HDFC"))
		{
			test.log(Status.PASS,"Recipe result is displayed");
		}else {
			test.log(Status.FAIL,"Recipe result is not displayed");
		}
		
		

}
}
