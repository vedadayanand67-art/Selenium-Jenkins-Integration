package com.sidechef.listener;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.apache.commons.io.FileUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.sidechef.baseclassutility.Baseclass;
import com.sidechef.genericutility.webdriverutility.UtilityClassObject;

public class ListenerImplementation implements ITestListener,ISuiteListener {
	  public ExtentSparkReporter spark;

    public static ExtentReports report;

    @Override
    public void onStart(ISuite suite) {

        System.out.println("Report configuration");

        String time = new Date().toString().replace(" ", "_").replace(":", "_");

        ExtentSparkReporter spark =
                new ExtentSparkReporter("./AdvanceReport/report_" + time + ".html");

        spark.config().setDocumentTitle("Recipe Results");
        spark.config().setReportName("Sidechef report");
        spark.config().setTheme(Theme.DARK);

        report = new ExtentReports();
        report.attachReporter(spark);

        report.setSystemInfo("OS", "Windows-11");
        report.setSystemInfo("BROWSER", "CHROME-156");
    }

    @Override
    public void onTestStart(ITestResult result) {

        System.out.println("=====>" + result.getMethod().getMethodName() + ">====START=======");

        UtilityClassObject.setTest(report.createTest(result.getMethod().getMethodName()));

        UtilityClassObject.getTest().log(Status.INFO,
                result.getMethod().getMethodName() + " ==> STARTED");
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        UtilityClassObject.getTest().log(Status.PASS,
                result.getMethod().getMethodName() + " ==> COMPLETED");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        String testName = result.getMethod().getMethodName();

        TakesScreenshot ts = (TakesScreenshot) UtilityClassObject.getDriver();

        String filePath = ts.getScreenshotAs(OutputType.BASE64);

        String time = new Date().toString().replace(" ", "_").replace(":", "_");

        UtilityClassObject.getTest().addScreenCaptureFromBase64String(
                filePath, testName + "_" + time);

        UtilityClassObject.getTest().log(Status.FAIL, testName + " ==> FAILED");
        UtilityClassObject.getTest().fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        System.out.println(result.getName() + " Test Skipped");

        UtilityClassObject.getTest().log(Status.SKIP, "Test Skipped");
    }

    @Override
    public void onFinish(ISuite suite) {

        System.out.println("Report backup");

        report.flush();
    }
}