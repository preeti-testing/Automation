package AdJava;



import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import genericUtility.GenericExcelFile;


public class GenericUtilityExcelPractice {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		GenericExcelFile ex=new GenericExcelFile();
		String value = ex.readDataFromExcel("Organization", 1, 2);
		System.out.println(value);
	}

	
	
	
	
}
