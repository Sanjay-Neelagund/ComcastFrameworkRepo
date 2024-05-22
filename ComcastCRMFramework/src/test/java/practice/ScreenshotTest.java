package practice;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

public class ScreenshotTest {
	@Test
	public void takeScrrenshot() throws Throwable {
		WebDriver driver=new ChromeDriver();
		driver.get("http://filpkart.com");
		 
		EventFiringWebDriver edriver=new EventFiringWebDriver(driver);
		File scrfile=edriver.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(scrfile, new File("./Screenshot/test.png"));
		
	}

}
