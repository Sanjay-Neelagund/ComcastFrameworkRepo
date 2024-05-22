package Com.Comcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Comcast.generic.webdriverutility.WebdriverUtility;

public class LoginPage extends WebdriverUtility{
	WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver=driver;

		PageFactory.initElements(driver, this);
	}
	@FindBy(name="user_name")
	private WebElement userNameEdt;
	@FindBy(name="user_password")
	private WebElement userPasswordEdt;
	@FindBy(id="submitButton")
	private WebElement LoginBtn;
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}
	public WebElement getUserPasswordEdt() {
		return userPasswordEdt;
	}
	public WebElement getLoginBtn() {
		return LoginBtn;
	}
	public void loginToApp(String url ,String userName,String password) {
		userNameEdt.sendKeys(userName);
		userPasswordEdt.sendKeys(password);
		waitForElememntPresent(driver, LoginBtn);
		LoginBtn.click();
	}
	public void loginToApp(String userName,String password) {
		userNameEdt.sendKeys(userName);
		userPasswordEdt.sendKeys(password);
		waitForElememntPresent(driver, LoginBtn);
		LoginBtn.click();
	}


}
