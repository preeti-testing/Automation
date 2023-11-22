package AdJava;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice {
	@Test
	public void practice()
	{
		System.out.println("step 1");
		System.out.println("step2");
		assertEquals(1, 1);
		System.out.println("step3");
	}

	@Test
	public void practiceSoftAssert()
	{
		SoftAssert sa=new SoftAssert();
		System.out.println("step 1");
		System.out.println("step2");
		sa.assertEquals("soft", "s");
		System.out.println("step3");
		sa.assertEquals(false, true);
		sa.assertAll();//to log failure
		
		
	}
	
}
