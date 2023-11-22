package objectRepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContectPage {

	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement createcontactimg;
	
	public ContectPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreatecontactimg() {
		return createcontactimg;
	}
	
	//business library
	/**
	 * this method will click on create contact look up image
	 */
	public void clickOncreatecontactimg()
	{
		createcontactimg.click();
	}
	
	
	
	
}
