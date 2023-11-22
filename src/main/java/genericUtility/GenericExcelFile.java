package genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * to read the data from excel file 
 * @author preeti
 *
 */
public class GenericExcelFile {
	 /**
	  * this method take the sheet row and cell value and return the cell value
	  * @param key
	  * @param r
	  * @param c
	  * @return value
	  * @throws EncryptedDocumentException
	  * @throws IOException
	  */
	public String readDataFromExcel(String key,int r,int c) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String value = wb.getSheet(key).getRow(r).getCell(c).getStringCellValue();
		return value;
	}
	
	
	public Object[][] readMultipleDataFromExcel(String sheetname) throws EncryptedDocumentException, IOException
	{
		
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		 Sheet sh = wb.getSheet(sheetname);
		 int lastRow = sh.getLastRowNum();
		 int lastCell = sh.getRow(0).getLastCellNum();
		 
		 Object[][] data=new Object[lastRow][lastCell];
		 for(int i=0;i<lastRow;i++)
		 {
			 for(int j=0;j<lastCell;j++)
			 {
				 data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			 }
		 }
		
		return data;
		
		
		
		
		
	}
	
	
	
}
