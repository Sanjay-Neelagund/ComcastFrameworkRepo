package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class asserttesthome {
	@Test 
	public void homePagelogo() {
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		driver.manage().window().maximize();
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		boolean displayed= driver.findElement(By.xpath("//img[@title=\"vtiger-crm-logo.gif\"]")).isDisplayed();
		Assert.assertTrue(displayed);
		driver.quit();
	}
	@Test 
	public void homePage() {
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://localhost:8888");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		String elememtName= driver.findElement(By.className("hdrLink")).getText();
		SoftAssert sa=new SoftAssert();
		
		sa.assertEquals("home",elememtName);
		sa.assertAll();
		driver.quit();
	}

}
