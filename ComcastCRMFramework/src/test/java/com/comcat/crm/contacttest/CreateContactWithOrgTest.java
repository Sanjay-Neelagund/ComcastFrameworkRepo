package com.comcat.crm.contacttest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Com.Comcast.crm.ObjectRepositoryUtility.ContactInfoPage;
import Com.Comcast.crm.ObjectRepositoryUtility.CreateNewOrganizationPage;
import Com.Comcast.crm.ObjectRepositoryUtility.HomePage;
import Com.Comcast.crm.ObjectRepositoryUtility.OrganizationInfoPage;
import Com.Comcast.crm.ObjectRepositoryUtility.OrganizationPage;
import Com.Comcast.crm.ObjectRepositoryUtility.ProfilePage;
import Com.Comcast.generic.fileutility.ExcelUtility;
import Com.Comcast.generic.fileutility.FileUtility;
import Com.Comcast.generic.webdriverutility.JavaUtility;
import Com.Comcast.generic.webdriverutility.WebdriverUtility;

public class CreateContactWithOrgTest {
public static void main(String[] args) throws Throwable {
	
    WebdriverUtility wlib=new WebdriverUtility();
    FileUtility flib=new FileUtility();
	JavaUtility jlib=new JavaUtility();
	ExcelUtility elib=new ExcelUtility();
	
	String browser = flib.getDataFromPropertyFile("Browser");
	String url = flib.getDataFromPropertyFile("URL");
	String userName = flib.getDataFromPropertyFile("UserName");
	String password = flib.getDataFromPropertyFile("Password");
	int num=jlib.getRandomNumber();
	
	
	String lastName = elib.getDataFromExcel("Contact", 1, 2)+num;
	
	String orgName = elib.getDataFromExcel("Org", 1, 2)+num;
	
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
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	driver.findElement(By.name("user_name")).sendKeys(userName);
	driver.findElement(By.name("user_password")).sendKeys(password);
	driver.findElement(By.id("submitButton")).click();
	HomePage hp=new HomePage(driver);
	hp.getOrganizationsLink().click();
	OrganizationPage op=new OrganizationPage(driver);
	op.getCreateNewOrgBtn().click();
	CreateNewOrganizationPage cnp=new CreateNewOrganizationPage(driver);
	cnp.createOrg(orgName);
	String headerName=op.getHeadername().getText();
	OrganizationInfoPage oip=new OrganizationInfoPage(driver);
	String actualOrgName=op.getHeadername().getText();
	
	if (actualOrgName.contains(orgName)) {
		System.out.println(orgName+"is created");
		
	}
	else {
		System.out.println(orgName+"is not created");
	}
	WebElement org = driver.findElement(By.linkText("Contacts"));
	org.isDisplayed();
	org.click();
	
	WebElement createContact = driver.findElement(By.xpath("//img[contains(@alt,\"Create Contact\")]"));
	createContact.click();
     driver.findElement(By.name("lastname")).sendKeys(lastName);
    cnp.getOrgBtn().click();
    wlib.switchToTabOnPartialURL(driver, "module=Accounts&action");
    cnp.getSearchOrgEdt().sendKeys(orgName);
    cnp.getSearchNowBtn().click();
    String data="//a[text()='"+orgName+"']";
    driver.findElement(By.xpath(data)).click();
    wlib.switchToTabOnPartialURL(driver, "module=Contacts&action");
	cnp.getSave().click();
	ContactInfoPage cip=new ContactInfoPage(driver);
	
	
	String last= cip.getLastNamehead().getText();

	
	if (last.equals(lastName)) {
		System.out.println(lastName+"is created");
		
	}
	else {
		System.out.println(lastName+"is not created");
	}
	ProfilePage pp=new ProfilePage(driver);
	pp.signoutFromApp();
}	
}
