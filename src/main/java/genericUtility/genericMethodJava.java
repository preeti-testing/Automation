package genericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class genericMethodJava {
	
	/**
	 * this method will return current system date
	 * @return
	 */
	public String getsystemdateinformate()
	{
		Date d=new Date();
		SimpleDateFormat df=new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		String currentdate = df.format(d);
		return currentdate;
		
	}
/**
 * this method will return random number for every run
 * @return value
 */
	public int getrandomnumber()
	{
		Random r=new Random();
		int value = r.nextInt(100);
		return value;
		
		
		
		
		
	}
}
