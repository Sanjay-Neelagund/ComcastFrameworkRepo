package Com.Comcast.crm.listenerutility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Com.Comcast.crm.baseutility.BaseClass;
import Com.Comcast.generic.webdriverutility.UtilityClassObject;

public class ListenerImplementclass implements ITestListener,ISuiteListener {
public	ExtentSparkReporter spark;
public	ExtentReports report;
public  ExtentTest test;
	

	public void onStart(ISuite suite) {
		String timeStamp=new Date().toString().replace(" ", "_").replace(":", "_"); 
		spark=new ExtentSparkReporter("./AdvanceReport/report"+timeStamp+".html");
		spark.config().setDocumentTitle("Set name in congigurtaion");
		spark.config().setReportName("CRM");
		spark.config().setTheme(Theme.DARK);
		
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Womdows-11");
		report.setSystemInfo("Browser", "chrome");
		
	}

	public void onFinish(ISuite suite) {
		report.flush();
	}

	public void onTestStart(ITestResult result) {
		String testName=result.getMethod().getMethodName();
		String timeStamp=new Date().toString().replace(" ", "_").replace(":", "_");
		test=report.createTest(testName);
		UtilityClassObject.setTest(test);
	    UtilityClassObject.getTest().log(Status.INFO, testName+"==Started==");


	}

	public void onTestSuccess(ITestResult result) {
		UtilityClassObject.getTest().log(Status.PASS, result.getMethod().getMethodName()+"==Passed==");
	}
	

	public void onTestFailure(ITestResult result) {
		
	
		TakesScreenshot edriver = (TakesScreenshot)UtilityClassObject.getDriver();
		UtilityClassObject.getTest().log(Status.FAIL, result.getMethod().getMethodName()+"==Failed==");
		String scrfile=edriver.getScreenshotAs(OutputType.BASE64);
		
		String testName=result.getMethod().getMethodName();
		String timestamp=new Date().toString().replace(" ", "_").replace(":", "_");
		UtilityClassObject.getTest().addScreenCaptureFromBase64String(scrfile,testName+timestamp);
		 test.addScreenCaptureFromBase64String(scrfile,testName+timestamp);
		 test.log(Status.FAIL, result.getThrowable());
	}

	public void onTestSkipped(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		UtilityClassObject.getTest().log(Status.SKIP, methodName+"==Skipped");

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		
		
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}




}
