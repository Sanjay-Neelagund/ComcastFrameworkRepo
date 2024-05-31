package Com.Comcast.crm.baseutility;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import Com.Comcast.crm.ObjectRepositoryUtility.LoginPage;
import Com.Comcast.crm.ObjectRepositoryUtility.ProfilePage;
import Com.Comcast.generic.databaseutility.DataBaseUtility;
import Com.Comcast.generic.fileutility.ExcelUtility;
import Com.Comcast.generic.fileutility.FileUtility;
import Com.Comcast.generic.webdriverutility.JavaUtility;
import Com.Comcast.generic.webdriverutility.UtilityClassObject;
import Com.Comcast.generic.webdriverutility.WebdriverUtility;

public class BaseClass{
	public DataBaseUtility dlib=new DataBaseUtility();
	public ExcelUtility elib=new ExcelUtility();
	public FileUtility flib=new FileUtility();
	public WebdriverUtility wlib=new WebdriverUtility();
	public JavaUtility jlib=new JavaUtility();
	public WebDriver driver=null;
	public static WebDriver sdriver=null;


	@BeforeSuite(groups = {"RegressionSuite","SmokeTesting"})
	public void configBS() throws Throwable {
		dlib.getDBConnection();
	}
	//@Parameters("Browser")
	@BeforeClass
	public void configBC() throws Throwable {
		//String browser = browser1;
		String browser= System.getProperty("Browser", flib.getDataFromPropertyFile("Browser"));
		String url=System.getProperty("URL",flib.getDataFromPropertyFile("URL"));
		System.out.println(browser);
		if (browser.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if (browser.equals("edge")) {
			driver=new EdgeDriver();
		}
		else if (browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		else  {
			driver=new ChromeDriver();
		}
		UtilityClassObject.setDriver(driver);
		driver.get(url);
		wlib.maximize(driver);
		wlib.waitForPageLoad(driver, 20);
		System.out.println("==Launch Browser==");

	}
	@BeforeMethod(groups = {"RegressionSuite","SmokeTesting"})
	public void configBM() throws Throwable {
		LoginPage lp=new LoginPage(driver);
		String un= System.getProperty("UserName",flib.getDataFromPropertyFile("UserName"));
		String psw=System.getProperty("Password",flib.getDataFromPropertyFile("Password"));
		
		lp.loginToApp(un,psw);

	}
	@AfterMethod(groups = {"RegressionSuite","SmokeTesting"})
	public void configAM() {
		ProfilePage pp=new ProfilePage(driver);
		pp.signoutFromApp();
	}

	@AfterClass(groups = {"RegressionSuite","SmokeTesting"})
	public void configAC() {
		driver.quit();
	}
	@AfterSuite(groups = {"RegressionSuite","SmokeTesting"})
	public void configAS() throws Throwable {
		dlib.closeDBConnection();
	}

}





