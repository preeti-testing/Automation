package AdJava;

import java.io.IOException;

import genericUtility.genericMethodForPropertyFile;
import genericUtility.genericMethodJava;

public class GenericUtilityPractice {

	public static void main(String[] args) throws IOException {
		genericMethodForPropertyFile putil=new genericMethodForPropertyFile();
		String value = putil.readDataFromPropetyfile("browser");
		System.out.println(value);
		String value1 = putil.readDataFromPropetyfile("url");
		System.out.println(value1);
		
		genericMethodJava j=new genericMethodJava();
		String date = j.getsystemdateinformate();
		System.out.println(date);
		
		int random = j.getrandomnumber();
		System.out.println(random);
	}

}
