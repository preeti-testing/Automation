package AdJava;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws IOException {
		//step 1 open file in java readable form
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Commandata.properties");
		
		//step2 create an object of property class from java.util
		Properties p=new Properties();
		
		//step3 load the input stream into properties
		p.load(fis);
		
		//step 4 provied key to read the value
		String value = p.getProperty("username");
		System.out.println(value);
		String value1 = p.getProperty("password");
		System.out.println(value1);
	}

}
