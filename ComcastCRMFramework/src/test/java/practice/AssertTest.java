package practice;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertTest {
	@Test
	public void verifyAssert() {
		SoftAssert sa=new SoftAssert();
		System.out.println("Step-1");
		System.out.println("Step-2");
		Assert.assertEquals("Home Page", "Home");
		System.out.println("Step-3");
		sa.assertEquals("", null);
		System.out.println("Step-4");
		sa.assertAll();
		
	}
	@Test
	public void verifyAssert2() {
		SoftAssert sa=new SoftAssert();
		System.out.println("Step-1");
		System.out.println("Step-2");
		sa.assertEquals("Home Page", "Home");
		System.out.println("Step-3");
		sa.assertEquals("", null);
		System.out.println("Step-4");
		sa.assertAll();
		
	}

}
