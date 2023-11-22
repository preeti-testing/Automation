package AdJava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Login {

	public static void main(String[] args) throws Throwable {
		
		WebDriver driver=new EdgeDriver();
		driver.get("http://localhost:8888");
		
		//step 2: login with credential
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		
		//step 3:navigate to contects
        driver.findElement(By.xpath("//a[.='Contacts']")).click();
        Thread.sleep(1000);
        
        //step 4:create contects
        driver.findElement(By.xpath("1]")).click();
        
        //step 5:enter mandatory fields
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("pree");
        
        //step 6:save the contects
        driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
        
        //step 7:verify the save
        String contectheader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
        if (contectheader.contains("pree")) {
        	 System.out.println(contectheader);
        	 System.out.println("pass");
        	 }
        else
        {
        	System.out.println("fail");
        }
        
        //step 8:logout
        WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
        
        Actions act=new Actions(driver);
        act.moveToElement(ele).perform();
        driver.findElement(By.linkText("Sign Out")).click();
        System.out.println("logout is successfull");
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
	}

}
