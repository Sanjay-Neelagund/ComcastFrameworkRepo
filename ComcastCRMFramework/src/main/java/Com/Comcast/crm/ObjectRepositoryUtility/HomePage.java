package Com.Comcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Comcast.generic.webdriverutility.WebdriverUtility;
/**
 * 
 * @author Sanjay
 * Contains Home page elements and business lib
 */
public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(linkText = "Organizations")
	private WebElement OrganizationsLink;
	@FindBy (linkText = "Contacts")
	private WebElement ContactsLink;
	@FindBy (linkText = "More")
	private WebElement Morelink;
	@FindBy(linkText = "Campaigns")
	private WebElement Campaignslink;
	@FindBy(linkText = "Products")
	private WebElement productLink;
	
	public WebElement getProductLink() {
		return productLink;
	}
	public WebElement getMorelink() {
		return Morelink;
	}
	public WebElement getCampaignslink() {
		return Campaignslink;
	}
	public WebElement getOrganizationsLink() {
		return OrganizationsLink;
	}
	public WebElement getContactsLink() {
		return ContactsLink;
	}
	/*
	 * This method is to used to navigate to Campaigns page from home page
	 */
	public void NaviagteToCampaignsPage() {
		WebdriverUtility wlib=new WebdriverUtility();
		wlib.mouseMoveOnElement(driver, Morelink);
		Campaignslink.click();
	}
}
