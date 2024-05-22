package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Com.Comcast.generic.fileutility.ExcelUtility;
import Com.Comcast.generic.webdriverutility.WebdriverUtility;

public class sampleDPTest {

	@Test(dataProvider = "getProductDetails")
	public void getProductInfo(String brandName,String productName) throws Throwable
	{
		WebdriverUtility wlib=new WebdriverUtility();

		WebDriver driver=new ChromeDriver();
		wlib.waitForPageLoad(driver, 30);
		wlib.maximize(driver);
		driver.get("https://www.flipkart.com/");
		WebElement search= driver.findElement(By.className("Pke_EE"));
		wlib.waitForElememntPresent(driver, search);
		search.sendKeys(brandName,Keys.ENTER);
		Thread.sleep(2000);
		String x="//div[text()='"+productName+"']/../../div[2]/div[1]/div[1]/div[1]";
		WebElement pPrice = driver.findElement(By.xpath(x));
		wlib.waitForElememntPresent(driver, pPrice);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", pPrice);
		String price=pPrice.getText();
		System.out.println(price);
		driver.quit();
	}
	@DataProvider
	public Object[][] getProductDetails() throws Throwable{
		ExcelUtility elib=new ExcelUtility();
		int rowCount =elib.getRowCount("Products");
		Object[][] objArr=new Object[rowCount][2]; 

		 for (int i = 0; i < rowCount; i++) {
			 objArr[i][0]=elib.getDataFromExcel("Products",i+1, 0);
			 objArr[i][1]=elib.getDataFromExcel("Products",i+1, 1);
		}
		return objArr;
	}

}
