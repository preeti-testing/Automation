package AdJava;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteInexcelfile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//step 1 open file in java readable form
		
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
//step 2:create a workbook
		Workbook book=WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("Contects");
		Row row = sheet.createRow(6);
		Cell cl = row.createCell(4);
		cl.setCellValue("Batman");
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
		book.write(fos);
		book.close();
		System.out.println("data inserted");
	
	}

}
