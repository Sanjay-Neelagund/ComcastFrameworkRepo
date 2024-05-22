package practice;

import org.junit.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ReporterTest {
	@Test
	public void invoiceTest() {
		Reporter.log("Step-1",true);
		Reporter.log("Step-2",true);
		Assert.assertTrue(false);
		Reporter.log("Step-3",true);
		Reporter.log("Step-1",true);
	}

}
