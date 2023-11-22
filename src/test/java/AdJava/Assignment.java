package AdJava;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
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

public class Assignment {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		GenericExcelFile eutil=new GenericExcelFile();
		genericMethodForPropertyFile putil=new genericMethodForPropertyFile();
		genericMethodJava jutil=new genericMethodJava();
		WebDriverUtility wutil=new WebDriverUtility();
		 WebDriver driver = null;
		// step 1:read all required data
				/*from common file*/
				String BROWSER = putil.readDataFromPropetyfile("browser");
				String URL= putil.readDataFromPropetyfile("url");
				String USERNAME = putil.readDataFromPropetyfile("username");
				String PASSWORD = putil.readDataFromPropetyfile("password");
				
				
				//step 2 READ FROM TESTDATA FROM EXCEL FILE
				
				String PRODUCTNAME =eutil.readDataFromExcel("Product", 1, 2);
				String VENDERNAME = eutil.readDataFromExcel("Vender", 1, 2)+jutil.getrandomnumber();
				//step 3 launching the browser
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
				
				//step 4 login to applicaton
				driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
				driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
				driver.findElement(By.xpath("//input[@id='submitButton']")).click();
				
				//STEP 5 navigate to vendor
				driver.findElement(By.linkText("More")).click();
				//step 6 create vendor
				WebElement ele = driver.findElement(By.linkText("Vendors"));
				wutil.mouseHoverAction(driver, ele);
				driver.findElement(By.linkText("Vendors")).click();
				//step 7 create vender look up image
				driver.findElement(By.xpath("//img[@alt='Create Vendor...']")).click();
				
				//step 8 enter mandatory field
				driver.findElement(By.name("vendorname")).sendKeys(VENDERNAME);
				
				//step 9 save
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				//step 10 validate
				String venderheader = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
				if(venderheader.contains(VENDERNAME))
				{
					System.out.println(venderheader);
					System.out.println("validation pass");
				}
				else
				{
					System.out.println("validation failed");
				}
				
				//step 11  navigate to product
				driver.findElement(By.linkText("Products")).click();
				
				//step 12  click on create product look up link
				driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
				
				//step 13 fill mandatory field product name
				driver.findElement(By.name("productname")).sendKeys(PRODUCTNAME);
				
				//step 14 click on vender lookup 
				driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
				 
				//step 15 switch to vender window
				wutil.swithchToWindow(driver, "Vender");
				 System.out.println("switch to child window");
				
				// step 16 search vender name
				 driver.findElement(By.name("search_text")).sendKeys(VENDERNAME);
				 driver.findElement(By.name("search")).click();
				 driver.findElement(By.xpath("//a[.='"+VENDERNAME+"']")).click();
				 
				 //step 17 switch control back to parent window
				 wutil.swithchToWindow(driver, "Product");
				 System.out.println("back to parent window");
				 
				 //step18 save
					
				 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
					
					//validate
					String productheader = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
					if (productheader.contains(PRODUCTNAME)) {
						System.out.println("validate");
						
					}
					else
					{
						System.out.println("validation failed");
					}
					
					//logout
					 WebElement ele1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
					wutil.mouseHoverAction(driver, ele1);
					
					Thread.sleep(1000);
					driver.findElement(By.linkText("Sign Out")).click();
					System.out.println("logout successfull");
				
				
				
				
				
				
				
				
				
				
				
				
				
				

	}

}
