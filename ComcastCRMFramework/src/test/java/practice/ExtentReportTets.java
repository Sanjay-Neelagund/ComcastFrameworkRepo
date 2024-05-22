package practice;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportTets {
	@Test
	public void reportTest() {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		TakesScreenshot take=(TakesScreenshot) driver;
		//Spark report config
		String srcpath=take.getScreenshotAs(OutputType.BASE64);
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport");
		spark.config().setDocumentTitle("Set name in congigurtaion");
		spark.config().setReportName("CRM");
		spark.config().setTheme(Theme.DARK);
		
		//Add Env inform & create test
		ExtentReports report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Womdows-11");
		report.setSystemInfo("Browser", "chrome");
		ExtentTest test=report.createTest("Createcontact");
		
		
		test.log(Status.INFO,"==Start==");
		if("Home".equalsIgnoreCase("hom")) {
		test.log(Status.PASS, "==Pass==");
		}
		else {
			test.addScreenCaptureFromBase64String(srcpath);
		}
		report.flush();
		
		
		
	}

}
