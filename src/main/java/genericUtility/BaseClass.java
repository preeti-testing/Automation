package genericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepositry.HomePage;
import objectRepositry.LoginPage;

public class BaseClass {
	public GenericExcelFile eutil=new GenericExcelFile();
	public genericMethodForPropertyFile putil=new genericMethodForPropertyFile();
	public genericMethodJava jutil=new genericMethodJava();
	public WebDriverUtility wutil=new WebDriverUtility();
	public WebDriver driver=null;
	
	public static WebDriver sdriver;
	
	@BeforeSuite(alwaysRun = true)
	public void bsConfig()
	{
		System.out.println("DB connection succesful");
	}
	//@BeforeTest
	@BeforeClass(alwaysRun = true)
	public void bcConfig() throws IOException
	{
		String BROWSER = putil.readDataFromPropetyfile("browser");
		String URL= putil.readDataFromPropetyfile("url");
		if(BROWSER.equalsIgnoreCase("CHROME"))
		 {
			WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
			 System.out.println(BROWSER+"====browser launched===");
		 }
		 else if(BROWSER.equalsIgnoreCase("edge"))
		 {
			 WebDriverManager.edgedriver().setup();
			 driver=new EdgeDriver();
			 System.out.println(BROWSER+"====browser launched===");
		 }
		 else
		 {
			 System.out.println("Invalid broswer");
		 }
		sdriver=driver;
		wutil.maximizeWindow(driver);
		wutil.waitForPageLoad(driver);
		driver.get(URL);
	}

	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws IOException
	{
		String USERNAME = putil.readDataFromPropetyfile("username");
		String PASSWORD = putil.readDataFromPropetyfile("password");
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("login successful");
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void amConfig() throws InterruptedException
	{
		HomePage hp=new HomePage(driver);
		hp.logoutOfApp(driver);
	}
	//@AfterTest
	@AfterClass(alwaysRun = true)
	public void acConfig()
	{
		driver.quit();
	}
	@AfterSuite(alwaysRun = true)
	public void asConfig()
	{
		System.out.println("DB close succesful");
	}
}
