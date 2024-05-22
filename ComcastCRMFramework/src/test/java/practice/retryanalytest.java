package practice;

import org.testng.annotations.Test;

import junit.framework.Assert;

public class retryanalytest {
	@Test(retryAnalyzer = Com.Comcast.crm.listenerutility.RetryListenerImp.class)
	public void incovetest() {
		System.out.println("Step 1");
		Assert.assertEquals("","");
		System.out.println("Step 2");
		System.out.println("Step 3");
		System.out.println("Step 4");
		
	}

}
