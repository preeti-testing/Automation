package AdJava;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

public class Scenario2WithDDT {

	public static void main(String[] args) throws IOException {
		//read the data from property file
		FileInputStream fisp=new FileInputStream(".\\src\\test\\resources\\Commandata.properties");
		Properties p =new Properties();
		p.load(fisp);
		String BROWSER = p.getProperty("browser");
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		
		//READ THE DATA FROM EXCEL FILE
		FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fise);
		String ORGNAME = wb.getSheet("Organization").getRow(4).getCell(2).getStringCellValue();
		
		//launch browser
		WebDriver driver=null;
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
			
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			driver= new EdgeDriver();
		}
		else
		{
			System.out.println("invalid browser");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//login with credential
		driver.get(URL);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		
		//navigate to organization
		driver.findElement(By.linkText("Organizations")).click();
		
		//create new org
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		driver.findElement(By.className("detailedViewTextBox")).sendKeys(ORGNAME);

		//SAVE
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//validate
		String orgheader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (orgheader.contains("AllStates"))
		{
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
