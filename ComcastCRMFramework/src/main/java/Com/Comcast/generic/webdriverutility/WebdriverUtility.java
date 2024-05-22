package Com.Comcast.generic.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtility {
	
	public void waitForPageLoad(WebDriver driver, int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}
	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}
	public void waitForElememntPresent(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	public void switchToTabOnPartialURL(WebDriver driver,String partialUrRL) {
		Set<String> set=driver.getWindowHandles();
		Iterator<String> it= set.iterator();
		while (it.hasNext()) {
			String window=it.next();
			driver.switchTo().window(window);
			
			String actualUrl=driver.getCurrentUrl();
			if(actualUrl.equals(partialUrRL)) {
				break;
			}	
		}
	}
	public Actions handleActions(WebDriver driver) {
	Actions ac=new Actions(driver);
	return ac;
	}
	public Select handleSelect(WebElement element) {
		Select sec=new Select(element);
		return sec;
		}
	
	public void switchToTabOnPartialTitle(WebDriver driver,String partialTitle) {
		Set<String> set=driver.getWindowHandles();
		Iterator<String> it= set.iterator();
		while (it.hasNext()) {
			String window=it.next();
			driver.switchTo().window(window);
			
			String actualUrl=driver.getCurrentUrl();
			if(actualUrl.equals(partialTitle)) {
				break;
			}	
		}
	}
	public void switchToFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	public void switchToFrame(WebDriver driver,String nameId) {
		driver.switchTo().frame(nameId);
	}
	public void switchToFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public void switchToAlertAndCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	public void select(WebElement element,String text) {
		handleSelect(element).selectByVisibleText(text);
	}
	public void select(WebElement element,int index) {
		handleSelect(element).selectByIndex(index);
	}
	public void selectByValue(WebElement element,String value) {
		handleSelect(element).selectByValue(value);
	}
	public void mouseMoveOnElement(WebDriver driver,WebElement element) {
		
		handleActions(driver).moveToElement(element).perform();
	}
	public void doubleClickOnElement(WebDriver driver,WebElement element) {
		
		handleActions(driver).doubleClick(element).perform();
	}
	public void dragAndDrop(WebDriver driver,WebElement ele1,WebElement ele2) {
		handleActions(driver).dragAndDrop(ele1, ele2).perform();
	}
	public void rightClickOnElement(WebDriver driver,WebElement element) {
		
		handleActions(driver).contextClick(element).perform();
	}
	
}
