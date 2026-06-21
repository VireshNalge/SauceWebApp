package listenerUtility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import baseTest.BaseClass;

public class ListenerImplementation implements ITestListener, ISuiteListener   {
	public ExtentSparkReporter spark;
	public ExtentReports report;
	public ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		Date d = new Date();
		String newDate = d.toString().replace(" ", "_").replace(":", "_");
		
		 spark=new ExtentSparkReporter("./AdvanceReport/report_"+newDate+".html");
		spark.config().setDocumentTitle("SauceDemo");
		spark.config().setReportName("SemoResult");
		spark.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows11");
		Reporter.log("report config",true);
		
	}

	@Override
	public void onFinish(ISuite suite) {
		report.flush();
		Reporter.log("report backup",true);
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		 String testName =result.getMethod().getMethodName();
		 test = report.createTest(testName);
		 test.log(Status.INFO, "==="+testName+"Excecution STARTED===");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName =result.getMethod().getMethodName();
		 test.log(Status.PASS, "==="+testName+"Excecution SUCCESS===");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName =result.getMethod().getMethodName();
		Date d = new Date();
		String newDate = d.toString().replace(" ", "_").replace(":", "_");
		
		TakesScreenshot ts = (TakesScreenshot) BaseClass.sdriver;
		String temp = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(temp);
		
	/*	File perm = new File("./Screenshots/takesSS_"+newDate+".png");
		try {
			FileHandler.copy(temp, perm);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		 test.log(Status.FAIL, "==="+testName+"Excecution FAILURE===");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testName =result.getMethod().getMethodName();
		test.log(Status.SKIP, "==="+testName+"Excecution SKIPPED===");
		
	}
	
	

}
