package AdJava;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class WriteInpropertyFile {

	public static void main(String[] args) throws IOException {
		Properties p=new Properties();
		p.setProperty("username","admin");
		p.setProperty("password","admin");
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\Commandata.properties");
		p.store(fos,"data inserted");
		System.out.println("property  successfull");
		
		
		
		
		
		
	}

}
