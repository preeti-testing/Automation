package objectRepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgInfoPage {

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement orgHeadertxt;
	
	public OrgInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrginfo() {
		return orgHeadertxt;
	}
	
	//business library
	/**
	 * this method will return org header text to caller
	 * @return
	 */
	public String getorgHeader()
	{

		 return orgHeadertxt.getText();
	}
	
	
	
	
	
	
}
