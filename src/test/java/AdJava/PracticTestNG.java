package AdJava;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PracticTestNG {
	
	
	
	@Test
	public void create()
	{
		Assert.fail();
		System.out.println("hello");
	}
	
	@Test(dependsOnMethods = "create")
	public void showTest()
	{
		System.out.println("good morning");
	}
	
	@Test
	public void addTest()
	{
		System.out.println("bye");
	}

}
