package objectRepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	//step 2 declaration
	@FindBy(linkText = "Organizations")
	private WebElement orglnk;
	
	@FindBy(linkText = "Contacts")
	private WebElement contectlnk;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminimg;

	@FindBy(linkText = "Sign Out")
	private WebElement signoutlnk;
	
	//step 3 instantiation
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	
	//step 4 utilization
	
	
	public WebElement getOrglink() {
		return orglnk;
	}

	public WebElement getContectlnk() {
		return contectlnk;
	}

	public WebElement getAdminimg() {
		return adminimg;
	}

	public WebElement getSignoutlnk() {
		return signoutlnk;
	}
	
	//business librery
	/**
	 * this method will click on organization link
	 */
	public void clickOnOrgLnk()
	{
		orglnk.click();
	}
	
	/**
	 * this method will click on contact link
	 */
	public void clickOnContectLnk()
	{
		contectlnk.click();
	}
	
	/**
	 * this method will click on sign out link
	 * @param driver
	 * @throws InterruptedException
	 */
	public void logoutOfApp(WebDriver driver) throws InterruptedException
	{
		mouseHoverAction(driver, adminimg);
		Thread.sleep(1000);
		signoutlnk.click();
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
