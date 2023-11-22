package AdJava;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class Scenario3 {

	public static void main(String[] args) {
		WebDriver driver=new EdgeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@id='submitButton']")).click();
         driver.findElement(By.xpath("//a[.='Organizations']")).click();
        
        driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
       driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("edge");
       //for radio button
       driver.findElement(By.xpath("//input[@value='T']")).click();
       //for drop down
       WebElement stage = driver.findElement(By.xpath("//select[@name='industry']"));
      Select stg = new Select(stage);
       stg.selectByValue("Chemicals");
       
      //for window popup with window id
       /*Thread.sleep(1000);
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
      Thread.sleep(1000);*/
      //for same multiple path
      driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
       //driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
       //driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		//Actions act = new Actions(driver);
	
		//act.moveToElement(ele).click();

       
	}

}
