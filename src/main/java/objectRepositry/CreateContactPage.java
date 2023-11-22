package objectRepositry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fasterxml.jackson.core.sym.Name;

import genericUtility.WebDriverUtility;

public class CreateContactPage extends WebDriverUtility {

	@FindBy(name = "lastname")
	private WebElement lastnametxt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	
	@FindBy(xpath = "//input[@title='Cancel [Alt+X]']")
	private WebElement cancelbtn;
	
	@FindBy(xpath = "(//img[@src='themes/softed/images/select.gif'])[1]")
	private WebElement orgnamelookupimg;
	
	
	@FindBy(id = "search_txt")
	private WebElement searchtxt;
	
	@FindBy(name = "search")
	private WebElement searchbtn;
	
	
	
	public CreateContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//utilization

	public WebElement getLastnametxt() {
		return lastnametxt;
	}


	public WebElement getSavebtn() {
		return savebtn;
	}


	public WebElement getCancelbtn() {
		return cancelbtn;
	}

	public WebElement getSearchtxt() {
		return searchtxt;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}
	
	public WebElement getOrgnamelookupimg() {
		return orgnamelookupimg;
	}

	//business lib
	/**
	 * this method will create contact with mendatory feild
	 * @param LASTNAME
	 */
	 public void createNewContact(String LASTNAME)
	 {
		 lastnametxt.sendKeys(LASTNAME);
		 savebtn.click();
	 }
	
	 /**
	  * this method will create new contect
	  * @param driver
	  * @param LASTNAME
	  * @param ORGNAME
	  */
	 public void createNewContact(WebDriver driver,String LASTNAME,String ORGNAME)
	 {
		 lastnametxt.sendKeys(LASTNAME);
		 orgnamelookupimg.click();
		swithchToWindow(driver, "Accounts");
		searchtxt.sendKeys(ORGNAME);
		searchbtn.click();
		driver.findElement(By.xpath("//a[.='"+ORGNAME+"']")).click();
		
		swithchToWindow(driver, "Contacts");
		savebtn.click();
		
		 
	 }
	 
	 
	 
	
	
	
	
}
