package AdJava;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Scenario2 {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=new EdgeDriver();
		driver.get("http://localhost:8888");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@id='submitButton']")).click();
         driver.findElement(By.xpath("//a[.='Opportunities']")).click();
        //Thread.sleep(1000);
        driver.findElement(By.xpath("//img[@title='Create Opportunity...']")).click();
       driver.findElement(By.xpath("//input[@name='potentialname']")).sendKeys("sales");
       //for radio button
       driver.findElement(By.xpath("//input[@ value='U']")).click();
       //for drop down
       WebElement stage = driver.findElement(By.xpath("//select[@name='sales_stage']"));
      Select stg = new Select(stage);
       stg.selectByValue("Qualification");
       
      //for window popup with window id
       Thread.sleep(1000);
       driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
       Thread.sleep(1000);
       String mainid = driver.getWindowHandle();
		System.out.println(mainid);
       
        Set<String> allid = driver.getWindowHandles();
        System.out.println(allid);
       for (String id : allid) {
    	   if(!mainid.equals(id))
			{
				driver.switchTo().window(id);
				driver.findElement(By.xpath("//a[.='Qspider']")).click();
			}
   		
	}
      driver.switchTo().window(mainid);
      Thread.sleep(1000);
      //for same multiple path
      driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
       driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
       //driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		//Actions act = new Actions(driver);
	
		//act.moveToElement(ele).click();
       
       
       
       //step 7:verify the save
       String contectheader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
       if (contectheader.contains("sales")) {
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


