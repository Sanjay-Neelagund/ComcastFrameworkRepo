package Com.Comcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Comcast.generic.webdriverutility.WebdriverUtility;

public class ProfilePage	 {
	WebDriver driver;
	public ProfilePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "(//td[@class='small']//img)[1]")
	private WebElement profileIcon;
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signoutlink;
	public WebElement getProfileIcon() {
		return profileIcon;
	}
	public WebElement getSignoutlink() {
		return signoutlink;
	}
	public void signoutFromApp() {
		WebdriverUtility wlib=new WebdriverUtility();
		wlib.mouseMoveOnElement(driver, profileIcon);
		signoutlink.click();
	}

}
