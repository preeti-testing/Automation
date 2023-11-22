package genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


/**
 * this class consist of re usable method related to property file
 * @author preeti
 *
 */
public class genericMethodForPropertyFile {
	
	
	/**
	 * thid method will read the key and return the value
	 * @param key
	 * @return value
	 * @throws IOException
	 */

	public String readDataFromPropetyfile(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Commandata.properties");
		Properties p=new Properties();
		p.load(fis);
		 String value = p.getProperty(key);
		return value;
		
		
		
		
		
		
		
	}

}
