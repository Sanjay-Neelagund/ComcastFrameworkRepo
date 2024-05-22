package Com.Comcast.crm.baseutility;

import org.junit.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClassPractice {
	
	@BeforeSuite
	public void configBS() {
		System.out.println("--> Connect to DB,Report Config <--");
	}
	@BeforeClass
	public void configBC() {
		System.out.println("--> Launch Browser <--");
	}
	@BeforeMethod
	public void configBM() {
		System.out.println("--> Login to app <--");
	}
	@AfterMethod
	public void configAM() {
		System.out.println("--> Logout to app <--");
	}
	
	@AfterClass
	public void configAC() {
		System.out.println("--> Close Browser <--");
	}
	@AfterSuite
	public void configAS() {
		System.out.println("--> Close DB,Report Backup <--");
	}

}
