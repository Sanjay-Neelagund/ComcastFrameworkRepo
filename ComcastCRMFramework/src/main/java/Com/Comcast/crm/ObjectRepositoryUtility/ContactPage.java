package Com.Comcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	WebDriver driver;
	public ContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//img[contains(@alt,'Create Contact')]")
	private WebElement CreateNewContactBtn;
	@FindBy(id = "dtlview_Last Name")
	private WebElement lastnameHeader;
	@FindBy(name = "lastname")
	private WebElement lastNameEdt;
	@FindBy(xpath="//input[@TITLE=\"Save [Alt+S]\"]")
	private WebElement Save;
	
	public WebElement getSave() {
		return Save;
	}
	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}
	public WebElement getlastnameHeader() {
		return lastnameHeader;
	}
	public WebElement getCreateNewContactBtn() {
		return CreateNewContactBtn;
	}
	
	

}
