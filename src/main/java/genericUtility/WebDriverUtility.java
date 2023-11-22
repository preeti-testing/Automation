package genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.bouncycastle.util.test.FixedSecureRandom.Source;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility {
	/**
	 * this method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	
	/**
	 * this method will minimiz the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	
	/**
	 * this method give the implicit wait to load the web page
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	
	/**
	 * this method will give the explicit wait to visible the web elemnt
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
		
		
	}
	
	
	
	/**
	 * this method gives the wait to web elemnt to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	

	/**
	 * this method will handle drop down with index
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element,int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}

	
	/**
	 * this method will handle drop down with value
	 * @param element
	 * @param value
	 */
	public void handleDropDown(WebElement element,String value)
	{
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	
	
	/**
	 * this method will handle drop down with visible text
	 * @param element
	 * @param visible
	 */
	public void handleDropDownVisibleText(String visible,WebElement element)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(visible);;
	}
	
	
	/**
	 * this method will perform double click action
	 * @param driver
	 * @param element
	 */
	 public void doubleClickAction(WebDriver driver,WebElement element)
	 {
		 Actions act= new Actions(driver);
		 act.doubleClick(element).perform();;
	 }
	  public void mouseHoverAction(WebDriver driver,WebElement element)
	  {
		  Actions act=new Actions(driver);
		  act.moveToElement(element).perform();
	  }
	 
	/**
	 * this method will do click and hold action on element
	 * @param driver
	 * @param element
	 */
	 public void clickAndHoldAction(WebDriver driver,WebElement element)
	 {
		 Actions act=new Actions(driver);
		 act.clickAndHold(element).perform();
	 }
	 
	 
	 /**
	  * this method will perform right click action on element
	  * @param driver
	  * @param element
	  */
	 public void rightClickAction(WebDriver driver,WebElement element)
	 {
		 Actions act=new Actions(driver);
		 act.contextClick(element).perform();
	 }
	 
	 
	 /**
	  * this method will perform drag and drop action on particular element
	  * @param driver
	  * @param src
	  * @param target
	  */
	 public void dragAndDropaction(WebDriver driver,WebElement src,WebElement target)
	 {
		 Actions act=new Actions(driver);
		 act.dragAndDrop(src, target);
		 
	 }
	 
	 
	 /**
	  * this method will move cursor down
	  * @param driver
	  */
	  public void scrollDownAction(WebDriver driver)
	  {
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		 js.executeScript("Window.scrollBy(0,500)", "");
	  }
	  
	  
	  /**
		  * this method will move cursor up
		  * @param driver
		  */
	  public void scrollUpAction(WebDriver driver)
	  {
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		 js.executeScript("Window.scrollBy(0,-500)", "");
	  }
	  
	  
	  /**
		  * this method will move cursor right
		  * @param driver
		  */
	  public void scrollRightAction(WebDriver driver)
	  {
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		 js.executeScript("Window.scrollBy(500,0)", "");
	  }
	  
	  
	  /**
		  * this method will move cursor left
		  * @param driver
		  */
	  public void scrollLeftAction(WebDriver driver)
	  {
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		 js.executeScript("Window.scrollBy(-500,0)", "");
	  }
	  
	  
	  /**
	   * this method will accept the alert pop up
	   * @param driver
	   */
	 public void acceptAlert(WebDriver driver)
	 {
		 driver.switchTo().alert().accept();;
	 }
	 
	 
	 /**
	  * this method will cancel the alert pop up
	  * @param driver
	  */
	 public void cancleAlert(WebDriver driver)
	 {
		 driver.switchTo().alert().dismiss();
	 }
	 
	 
	 /**
	  * this method will capture the alert text and return the text to caller
	  * @param driver
	  * @return
	  */
	 public String getAlertText(WebDriver driver)
	 {
		 String text = driver.switchTo().alert().getText();
		 return text;
	 }
	 /**
	  * this method will switch to frame by index
	  * @param driver
	  * @param index
	  */
	 public void switchToFrame(WebDriver driver,int index)
	 {
		 driver.switchTo().frame(index);
	 }
	 /**
	  * this method will switch to frame by name or id
	  * @param driver
	  * @param name
	  */
	 public void switchToFrame(WebDriver driver,String name)
	 {
		 driver.switchTo().frame(name);
	 }
	 /**
	  * this method will switch to frame by web element
	  * @param driver
	  * @param element
	  */
	 public void switchToFrame(WebDriver driver,WebElement element)
	 {
		 driver.switchTo().frame(element);
	 }
	 
	 /**
	  * this method will switch control to one window to another
	  * @param driver
	  * @param partialtitle
	  */
	 public void swithchToWindow(WebDriver driver,String partialtitle)
	 {
		 //step 1 capture all window id
		 Set<String> allid = driver.getWindowHandles();
		 
		 //step 2 navigate through each window id
		for (String windowid : allid) {
			
			//step 3 capture all windows title
			String acttitle = driver.switchTo().window(windowid).getTitle();
			
			//step 4 compare the actual title with expected partial window title
			if(acttitle.contains(partialtitle))
			{
				break;
			}
		}
	}
	 
	 /**
	  * this method will take screen shots and store it in required folder
	  * @param driver
	  * @param screeenShotName
	  * @return
	  * @throws IOException
	  */
	  public String takeScreenShots(WebDriver driver,String screeenShotName) throws IOException
	  {
		  TakesScreenshot ts=(TakesScreenshot) driver;
		  File src = ts.getScreenshotAs(OutputType.FILE);
		 File dst = new File(".\\ScreenShots\\"+screeenShotName+".png");
		  Files.copy(src, dst);
		  return dst.getAbsolutePath();//complete path of scrrenshot-extent reports
	  }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
