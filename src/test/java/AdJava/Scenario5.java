package AdJava;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario5 {

	public static void main(String[] args) throws InterruptedException {
		//step 1 launching the browser
		WebDriver driver= new EdgeDriver();
		driver.manage().window().maximize();
		 //step 2 login to the application
		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//step 3 navigate to contect 
		driver.findElement(By.linkText("Contacts")).click();
		
		//step 4 create contect
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		driver.findElement(By.name("lastname")).sendKeys("singh");
		driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
		String mainid = driver.getWindowHandle();
		System.out.println(mainid);
		Set<String> allid = driver.getWindowHandles();
		System.out.println(allid);
		//step 5 switch to child id
		
		for (String winid : allid) {
			if(!winid.equals(allid))
			{
				
				driver.switchTo().window(winid);
				System.out.println("switch to child id");
				break;
			}
		}
		
		//step 6 search for Organization name
		
		driver.findElement(By.name("search_text")).sendKeys("edge");
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText("edge")).click();
		
		//step 7 switch control back to parents
		driver.switchTo().window(mainid);
		System.out.println("switch back to parent window");
		
		//step 8 save
		 driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
		
		//step 9 validate
		 String contectheader = driver.findElement(By.partialLinkText("//span[@class='dvHeaderText']")).getText();
		if(contectheader.contains("singh"))
		{
			System.out.println(contectheader);
			System.out.println("validate");
		}
		else
		{
			System.out.println("validation failed");
			
		}
		
		//step10 logout
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(ele);
		Thread.sleep(1000);
		driver.findElement(By.linkText("Sign Out")).click();
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
