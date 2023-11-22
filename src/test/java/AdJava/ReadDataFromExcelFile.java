package AdJava;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbookFactory;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//step 1 open file in java readable form
				FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
				
	//step 2:create a workbook
		Workbook book=WorkbookFactory.create(fis);
		
		//step 3:navigate to sheet
		Sheet sheet = book.getSheet("Contects");
		
		//step 4:navigate to required row
			Row row = sheet.getRow(6);	
			
			//step 5:navigate to required cell
			Cell cell = row.getCell(4);
			
			//step 6:get the value from cell
			String value = cell.getStringCellValue();
			System.out.println(value);
			
			
	}

}
