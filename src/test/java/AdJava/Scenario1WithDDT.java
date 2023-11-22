package AdJava;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFWorkbookFactory;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import objectRepositry.LoginPage;

public class Scenario1WithDDT {

	public static void main(String[] args) throws IOException {
		// step 1:read all required data
		/*from common file*/
		FileInputStream fisp=new FileInputStream(".\\src\\test\\resources\\Commandata.properties");
		Properties p=new Properties();
		p.load(fisp);
		String BROWSER = p.getProperty("browser");
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		
		//READ FROM TESTDATA FROM EXCEL FILE
		FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb= WorkbookFactory.create(fise);
		String LASTNAME = wb.getSheet("Contects").getRow(1).getCell(2).getStringCellValue();
		
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
		 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		
		//login to app
		//driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
		//driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
		//driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		LoginPage lp=new LoginPage(driver);
		//lp.getUsernametxt();
		//lp.getPasswordtxt();
		//lp.getLoginbtn();
		lp.loginToApp(USERNAME, PASSWORD);
		
		
		
		
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
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("logout successfull");
		
		
		
		
	}

}
