package AdJava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Driver;

public class HandleCalenderForAnyDateAndDom {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new EdgeDriver();
		 driver.get("https://www.makemytrip.com");
		 driver.manage().window().maximize();
		 
		 driver.findElement(By.className("commonModal__close")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.className("wewidgeticon we_close::before")).click();
		// driver.findElement(By.)
		 
		 
		 
		 
		 
	}
	 
	

}
