package com.comcast.crm.organizationtest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Com.Comcast.crm.ObjectRepositoryUtility.CreateNewOrganizationPage;
import Com.Comcast.crm.ObjectRepositoryUtility.HomePage;
import Com.Comcast.crm.ObjectRepositoryUtility.OrganizationInfoPage;
import Com.Comcast.crm.ObjectRepositoryUtility.OrganizationPage;
import Com.Comcast.crm.baseutility.BaseClass;
import Com.Comcast.generic.webdriverutility.UtilityClassObject;
//@Listeners(Com.Comcast.crm.listenerutility.ListenerImplementclass.class)
/**
 * Test class for Organization Module
 * @author Sanjay
 *
 */
public class CreateOrganizationTest extends BaseClass{

	@Test(groups = "SmokeTesting")

	public void createOrg() throws Throwable {
		int num = jlib.getRandomNumber();
		String orgName = elib.getDataFromExcel("Org", 1, 2) + num;
		HomePage hp = new HomePage(driver);
		UtilityClassObject.getTest().log(Status.INFO, "Navigated to HomePage");
		hp.getOrganizationsLink().click();
		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateNewOrgBtn().click();
	
		CreateNewOrganizationPage cp = new CreateNewOrganizationPage(driver);
		cp.createOrg(orgName);
		UtilityClassObject.getTest().log(Status.INFO, "Navigated to Organization infopage");
		String header = op.getHeadername().getText();
		boolean status= header.contains(orgName);
		Assert.assertEquals(status, true);
		UtilityClassObject.getTest().log(Status.PASS, "Passed");
		
		
	}
	@Test(groups = "RegressionSuite")
	public void createOrgWithIndustry() throws Throwable {
		int num = jlib.getRandomNumber();
		String orgName = elib.getDataFromExcel("Org", 4, 2) + num;
		String industry = elib.getDataFromExcel("Org", 4, 3);
		String type = elib.getDataFromExcel("Org", 4, 4);
		UtilityClassObject.getTest().log(Status.INFO, "Navigated to HomePage");
		HomePage hp = new HomePage(driver);
		hp.getOrganizationsLink().click();
		OrganizationPage op = new OrganizationPage(driver);
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		op.getCreateNewOrgBtn().click();
		CreateNewOrganizationPage cp = new CreateNewOrganizationPage(driver);
		cp.createOrg(orgName, industry, type);
		UtilityClassObject.getTest().log(Status.INFO, "Navigated to Organization infopage with industry");
		String header = oip.getIndustrymsg().getText();
		
		Assert.assertEquals(header, industry);
		UtilityClassObject.getTest().log(Status.PASS, "Create organization with industry was created");
		String header1 = oip.getTypemsg().getText();
		Assert.assertEquals(header1, type);
		UtilityClassObject.getTest().log(Status.PASS, "Create organization with type was created");
	}
	@Test(groups = "RegressionSuite")
	public void createOrganizationWithphonenumbertest() throws Throwable {
		int num = jlib.getRandomNumber();
		String orgName = elib.getDataFromExcel("Org", 7, 2) + num;
		String phone = elib.getDataFromExcel("Org", 7, 3);
		
		HomePage hp = new HomePage(driver);
		hp.getOrganizationsLink().click();
		UtilityClassObject.getTest().log(Status.PASS, "Navigated to Homepage");
		OrganizationPage op = new OrganizationPage(driver);
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		op.getCreateNewOrgBtn().click();
		CreateNewOrganizationPage cp = new CreateNewOrganizationPage(driver);
		cp.createOrg(orgName,phone);
		String header = oip.getPhonemsg().getText();
		Assert.assertEquals(header, orgName);
		UtilityClassObject.getTest().log(Status.PASS, "Create organization with phone was created");	}
}
