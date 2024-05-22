package Com.Comcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Comcast.generic.webdriverutility.WebdriverUtility;

public class CreateNewOrganizationPage {
	WebDriver driver;
	WebdriverUtility wlib=new WebdriverUtility();
	public CreateNewOrganizationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//input[contains(@name,'accountname')]")
	private WebElement OrgNameEdt;
	@FindBy(xpath="//input[@TITLE=\"Save [Alt+S]\"]")
	private WebElement Save;
	@FindBy(name ="industry")
	private WebElement industryDd;
	@FindBy(id ="phone")
	private WebElement phoneNumEdt;
	
	public WebElement getPhoneNumEdt() {
		return phoneNumEdt;
	}
	@FindBy(name ="accounttype")
	WebElement typeDD;
	
	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}
	public WebElement getSave() {
		return Save;
	}
	
	@FindBy(xpath = "(//img[@src='themes/softed/images/select.gif' and @title='Select'])[1]")
	WebElement orgBtn;
	@FindBy(name = "search_text")
	WebElement searchOrgEdt;
	@FindBy(xpath = "//input[contains(@value,'Search Now')]")
	WebElement SearchNowBtn;
	public WebElement getOrgBtn() {
		return orgBtn;
	}
	public WebElement getSearchOrgEdt() {
		return searchOrgEdt;
	}
	public WebElement getSearchNowBtn() {
		return SearchNowBtn;
	}
	public void createOrg(String orgName) {
		getOrgNameEdt().sendKeys(orgName);
		getSave().click();
	}
	public void createOrg(String orgName,String industrytype,String type) {
		getOrgNameEdt().sendKeys(orgName);
		wlib.select(industryDd, industrytype);;
		wlib.select(typeDD, type);
		getSave().click();
	}
	public void createOrg(String orgName,String phone) {
		getOrgNameEdt().sendKeys(orgName);
		getPhoneNumEdt().sendKeys(phone);
		getSave().click();
	}
}
