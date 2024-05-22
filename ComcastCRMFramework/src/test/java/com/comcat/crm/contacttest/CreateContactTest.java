package com.comcat.crm.contacttest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import Com.Comcast.crm.ObjectRepositoryUtility.ContactInfoPage;
import Com.Comcast.crm.ObjectRepositoryUtility.ContactPage;
import Com.Comcast.crm.ObjectRepositoryUtility.CreateNewOrganizationPage;
import Com.Comcast.crm.ObjectRepositoryUtility.HomePage;
import Com.Comcast.crm.ObjectRepositoryUtility.OrganizationInfoPage;
import Com.Comcast.crm.ObjectRepositoryUtility.OrganizationPage;
import Com.Comcast.crm.baseutility.BaseClass;
import Com.Comcast.crm.listenerutility.ListenerImplementclass;
import Com.Comcast.generic.fileutility.ExcelUtility;
import Com.Comcast.generic.webdriverutility.JavaScriptUtility;
import Com.Comcast.generic.webdriverutility.UtilityClassObject;


public class CreateContactTest extends BaseClass{
	@Test(groups = "SmokeTesting")
	public void createContact() throws Throwable {
		int num=jlib.getRandomNumber();
		String lastName = elib.getDataFromExcel("Contact", 1, 2)+num;
		HomePage hp=new HomePage(driver);
		UtilityClassObject.getTest().log(Status.INFO, "Navigated to HomePage");

		hp.getContactsLink().click();


		ContactPage cc=new ContactPage(driver);
		cc.getCreateNewContactBtn().click();
		cc.getLastNameEdt().sendKeys(lastName);
		cc.getSave().click();
		String last=cc.getlastnameHeader().getText();
		UtilityClassObject.getTest().log(Status.INFO, "Navigated to Contact infopage");

		Assert.assertEquals(lastName,last); 
		UtilityClassObject.getTest().log(Status.PASS, "Create contact passed");

	}
	@Test(groups = "RegressionSuite")
	public void createContactWithData() throws Throwable {
		JavaScriptUtility js=new  JavaScriptUtility();
		int num=jlib.getRandomNumber();
		String lastName = elib.getDataFromExcel("Contact", 1, 2)+num;
		HomePage hp=new HomePage(driver);
		UtilityClassObject.getTest().log(Status.INFO, "Navigated to HomePage");
		hp.getContactsLink().click();
		ContactPage cc=new ContactPage(driver);
		cc.getCreateNewContactBtn().click();
		cc.getLastNameEdt().sendKeys(lastName);
		String startDate =jlib.getSystemDateYYYYMMDD();
		String endDate =jlib.getRequiredDate();
		System.out.println(startDate);
		ContactInfoPage cip=new ContactInfoPage(driver);
		wlib.waitForElememntPresent(driver, cip.getSupportEndDate());
		js.scrolluntillelementisvisible(driver, cip.getSupportEndDate());
		cip.getSupportStartDate().clear();
		cip.getSupportStartDate().sendKeys(startDate);
		cip.getSupportEndDate().clear();
		cip.getSupportEndDate().sendKeys(endDate);

		cc.getSave().click();

		String last=cc.getlastnameHeader().getText();
	
		wlib.waitForElememntPresent(driver, cip.getSupportEndDatemsg());
		js.scrolluntillelementisvisible(driver, cip.getSupportEndDatemsg());
		String stDate= cip.getSupportStartDatemsg().getText();
		String lsDate=cip.getSupportEndDatemsg().getText();

		Assert.assertEquals(stDate, startDate);
		//System.out.println(startDate + " Is created");
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(lsDate,endDate);
		//	System.out.println(endDate+" is Created");
		sa.assertAll();
		UtilityClassObject.getTest().log(Status.PASS, "Passed");

	}

	@Test
	public void createContactWithOrg() throws Throwable {
		ExcelUtility elib=new ExcelUtility();
		int num=jlib.getRandomNumber();
		String orgName=elib.getDataFromExcel("Org", 1, 2)+num;
		String lastName=elib.getDataFromExcel("Contact", 1, 2);
		HomePage hp=new HomePage(driver);
		UtilityClassObject.getTest().log(Status.INFO, "Navigated to HomePage");
		hp.getOrganizationsLink().click();
		OrganizationPage op=new OrganizationPage(driver);
		op.getCreateNewOrgBtn().click();
		CreateNewOrganizationPage cnp=new CreateNewOrganizationPage(driver);
		cnp.createOrg(orgName);
		String headerName=op.getHeadername().getText();
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String actualOrgName=op.getHeadername().getText();
		boolean status= actualOrgName.contains(orgName);
		Assert.assertEquals(status, true);
		
		hp.getContactsLink().click();
		ContactPage cp=new ContactPage(driver);
		cp.getCreateNewContactBtn().click();
		cp.getLastNameEdt().sendKeys(lastName);
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

		SoftAssert saAssert=new SoftAssert();
		saAssert.assertEquals(lastName, "fgh");
		saAssert.assertAll();
		
	}

}
