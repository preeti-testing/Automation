package AdJava;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import genericUtility.GenericExcelFile;
import genericUtility.WebDriverUtility;
import genericUtility.genericMethodForPropertyFile;
import genericUtility.genericMethodJava;

public class Scenario5WithDDTandGU {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		
		
		
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
				
				String LASTNAME =eutil.readDataFromExcel("Contects", 4, 2);
				String ORGNAME = eutil.readDataFromExcel("Contects", 4, 3)+jutil.getrandomnumber();
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
				
				//step 5 navigate to organization
				driver.findElement(By.linkText("Organizations")).click();

					//step 6 click to create organization look up image
				driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
				
				//step 7 create org with mandatory field
				driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
				
				//step 8 save
				driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
				
				//step 9 validate
				String orgheader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if(orgheader.contains(ORGNAME))
				{
					System.out.println(orgheader);
					System.out.println("validate");
				}
				else
				{
					System.out.println("validation failed");
				}
				
				//step 10 navigate to contects link
				driver.findElement(By.xpath("//a[.='Contacts']")).click();
				
				//step 11 click on create contects look up image
				driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
				
				//step 12 create contect with mandatory field
				driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(LASTNAME);
				
				//step 13 click on org look up image
				driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
				
				//step 14 switch control to window child
				wutil.swithchToWindow(driver, "Accounts");
				System.out.println("switch to child window");
				
				//step 15 search for organization//Infosys90
				driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(ORGNAME);
				driver.findElement(By.name("search")).click();
				driver.findElement(By.xpath("//a[.='"+ORGNAME+"']")).click();
				
				//step 16 switch control back to parent
				wutil.swithchToWindow(driver, "Contects");
				System.out.println("switch back to parents");
				
				//step 17save
				driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
				
				//validate
				String contectheader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if (contectheader.contains(LASTNAME)) {
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
