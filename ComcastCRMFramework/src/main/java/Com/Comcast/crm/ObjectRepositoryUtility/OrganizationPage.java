package Com.Comcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	WebDriver driver;
	public OrganizationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//img[contains(@alt,'Create Organization')]")
	private WebElement CreateNewOrgBtn;
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headername;
	public WebElement getHeadername() {
		return headername;
	}
	public WebElement getCreateNewOrgBtn() {
		return CreateNewOrgBtn;
	}
	
}
