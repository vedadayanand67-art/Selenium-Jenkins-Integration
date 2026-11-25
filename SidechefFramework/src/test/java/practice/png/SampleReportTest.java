package practice.png;

import java.io.File;
import java.io.IOException;

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

public class SampleReportTest {
	ExtentReports report;
	@BeforeSuite
	public void configBS()
	{
		//Spark report config
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("Search Test Results");
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
public void Bookmark()
{	
	ExtentTest test=report.createTest("Bookmark");
	test.log(Status.INFO, "Sign in to app");
	test.log(Status.INFO,"Enter recipe name");
	test.log(Status.INFO,"Click on search");
	test.log(Status.INFO,"Click on save bookmark");
	if("HFC".equals("HDFC"))
	{
		test.log(Status.PASS, "Search result found");
	}
	else {
		test.log(Status.FAIL,"Search result not found");
	}
	
	
}

@Test
public void Recipe() throws IOException
{	
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.sidechef.com");
	// Take screenshot
    TakesScreenshot eDriver = (TakesScreenshot) driver;

    String filePath = eDriver.getScreenshotAs(OutputType.BASE64);

	
	ExtentTest test=report.createTest("Bookmark");
	test.log(Status.INFO, "Sign in to app");
	test.log(Status.INFO,"Enter recipe name");
	test.log(Status.INFO,"Click on search");
	test.log(Status.INFO,"Click on save bookmark");
	if("HDC".equals("ABC"))
	{
		test.log(Status.PASS, "Search result found");
	}
	else {
		test.addScreenCaptureFromBase64String(filePath,"ErrorFile");
	}
	driver.close();
}

}
