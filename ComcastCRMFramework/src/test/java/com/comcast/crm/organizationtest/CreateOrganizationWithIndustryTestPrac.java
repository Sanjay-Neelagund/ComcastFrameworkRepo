package com.comcast.crm.organizationtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Com.Comcast.crm.ObjectRepositoryUtility.CreateNewOrganizationPage;
import Com.Comcast.crm.ObjectRepositoryUtility.HomePage;
import Com.Comcast.crm.ObjectRepositoryUtility.LoginPage;
import Com.Comcast.crm.ObjectRepositoryUtility.OrganizationInfoPage;
import Com.Comcast.crm.ObjectRepositoryUtility.OrganizationPage;
import Com.Comcast.crm.ObjectRepositoryUtility.ProfilePage;
import Com.Comcast.generic.fileutility.ExcelUtility;
import Com.Comcast.generic.fileutility.FileUtility;
import Com.Comcast.generic.webdriverutility.JavaUtility;
import Com.Comcast.generic.webdriverutility.WebdriverUtility;

public class CreateOrganizationWithIndustryTestPrac {
	public static void main(String[] args) throws Throwable {
		FileUtility flib=new FileUtility();
		JavaUtility jlib=new JavaUtility();
		ExcelUtility elib=new ExcelUtility();
		WebdriverUtility wlib=new WebdriverUtility();
		String browser = flib.getDataFromPropertyFile("Browser");
		String url = flib.getDataFromPropertyFile("URL");
		String userName = flib.getDataFromPropertyFile("UserName");
		String password = flib.getDataFromPropertyFile("Password");
		int num=jlib.getRandomNumber();
		String orgName = elib.getDataFromExcel("Org", 4, 2)+num;
		String industry = elib.getDataFromExcel("Org", 4, 3);
		String type = elib.getDataFromExcel("Org", 4, 4);
		WebDriver driver=null;
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
		driver.get(url);
		wlib.maximize(driver);
		wlib.waitForPageLoad(driver, 20);
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(userName, password);
		HomePage hp=new HomePage(driver);
		hp.getOrganizationsLink().click();
		OrganizationPage op=new OrganizationPage(driver);
		op.getCreateNewOrgBtn();
		CreateNewOrganizationPage cnp=new CreateNewOrganizationPage(driver);
		cnp.createOrg(orgName, industry,type);
		String headerName=op.getHeadername().getText();
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String indus=oip.getIndustrymsg().getText();
		String actype=oip.getTypemsg().getText();

		if (indus.contains(industry)) {
			System.out.println(industry+"is created");
			
		}
		else {
			System.out.println(industry+"is not created");
		}
		if(actype.equals(type)) {
			System.out.println(type+"is created");

		}
		else {
			System.out.println(type+"is not created");

		}
		ProfilePage pp=new  ProfilePage(driver);
		pp.signoutFromApp();
		driver.quit();

	}

}
