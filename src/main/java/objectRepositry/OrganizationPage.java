package objectRepositry;

import org.apache.commons.compress.archivers.zip.X000A_NTFS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {//step 1
	
	//step2 declaration
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement createorgLookup;
	
	//step 3 instantiation
	public OrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}

	

	//step 4 utilization
	
	public WebElement getCreateorgbtn() {
		return createorgLookup;
	}
	
	
	//step 5 business library
	/**
	 * this method will click on create org look up
	 */
	public void clickcreateOrglookup()
	{
		createorgLookup.click();
	}
	
	
	
}
