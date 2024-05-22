package Com.Comcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	WebDriver driver;
	public ContactInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
@FindBy(id = "dtlview_Last Name")
WebElement lastNamehead;
	public WebElement getLastNamehead() {
	return lastNamehead;
}


public void setLastNamehead(WebElement lastNamehead) {
	this.lastNamehead = lastNamehead;
}
	@FindBy(id ="dtlview_Support Start Date")
	WebElement supportStartDatemsg;
	
	
	@FindBy(name ="support_start_date")
	WebElement supportStartDate;
	
	public WebElement getSupportStartDate() {
		return supportStartDate;
	}
	@FindBy(name ="support_end_date")
	WebElement supportEndDate;

	public WebElement getSupportStartDatemsg() {
		return supportStartDatemsg;
	}


	public WebElement getSupportEndDatemsg() {
		return supportEndDatemsg;
	}


	public WebElement getSupportEndDate() {
		return supportEndDate;
	}


	@FindBy(id ="dtlview_Support End Date")
	WebElement supportEndDatemsg;


}
