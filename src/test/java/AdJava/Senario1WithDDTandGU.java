package AdJava;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import genericUtility.GenericExcelFile;
import genericUtility.WebDriverUtility;
import genericUtility.genericMethodForPropertyFile;
import genericUtility.genericMethodJava;

public class Senario1WithDDTandGU {

	public static void main(String[] args) throws IOException, InterruptedException {
		//create object for ll utilities file
		GenericExcelFile eutil=new GenericExcelFile();
		genericMethodForPropertyFile putil=new genericMethodForPropertyFile();
		genericMethodJava jutil=new genericMethodJava();
		WebDriverUtility wutil=new WebDriverUtility();
		
		
		// step 1:read all required data
				/*from common file*/
				String BROWSER = putil.readDataFromPropetyfile("browser");
				String URL= putil.readDataFromPropetyfile("url");
				String USERNAME = putil.readDataFromPropetyfile("username");
				String PASSWORD = putil.readDataFromPropetyfile("password");
				
				
				//READ FROM TESTDATA FROM EXCEL FILE
				
				String LASTNAME =eutil.readDataFromExcel("Contects", 1, 2);
				
				//launching the browser
				 WebDriver driver = null;
				 if(BROWSER.equalsIgnoreCase("CHROME"))
				 {
					 driver=new ChromeDriver();
				 }
				 else if(BROWSER.equalsIgnoreCase("edge"))
				 {
					 driver=new EdgeDriver();
				 }
				 else
				 {
					 System.out.println("Invalid broswer");
				 }
				 
				wutil.maximizeWindow(driver);
				wutil.waitForPageLoad(driver);
				driver.get(URL);
				
				//login to app
				driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
				driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
				driver.findElement(By.xpath("//input[@id='submitButton']")).click();
				
				// Navigate to contects
				driver.findElement(By.xpath("//a[.='Contacts']")).click();
				
				//create contects
				driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
			
				//enter requird field
				driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(LASTNAME);
				
				//save
				driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
				
				//validate
				String contectheader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if (contectheader.contains("Spiderman")) {
					System.out.println("validate");
					
				}
				else
				{
					System.out.println("validation failed");
				}
				
				//logout
				 WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				wutil.mouseHoverAction(driver, ele);
				
				Thread.sleep(1000);
				driver.findElement(By.linkText("Sign Out")).click();
				System.out.println("logout successfull");
				
				
		
		
		
		
		
		
	}

}
