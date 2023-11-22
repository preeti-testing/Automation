package AdJava;

import org.testng.annotations.Test;

public class ReadDataFromcmdLine {
	@Test
	public void read()
	{
		 String un=System.getProperty("username");
		 String psw=System.getProperty("password");
		 System.out.println(un);
		 System.out.println(psw);
	}

}
