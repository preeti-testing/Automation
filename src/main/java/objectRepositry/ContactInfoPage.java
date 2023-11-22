package objectRepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement contactHeadertxt;
	
	public ContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getContactinfo() {
		return contactHeadertxt;
	}
	
	//business library
	/**
	 * this method will return the contact header info text to caller
	 * @return
	 */
	public String getcontactHeader()
	{
		return contactHeadertxt.getText();
	}
	
	
}
