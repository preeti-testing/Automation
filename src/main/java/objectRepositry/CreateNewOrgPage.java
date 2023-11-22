package objectRepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.WebDriverUtility;

public class CreateNewOrgPage extends WebDriverUtility{
	//step2 declaration
	@FindBy(name = "accountname")
	private WebElement organizationnametxt;
	
	@FindBy(name = "industry")
	private WebElement industryDropDown;
	
	@FindBy(name = "accounttype")
	private WebElement typeDropDown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	
	@FindBy(xpath = "//input[@title='Cancel [Alt+X]']")
	private WebElement cancelbtn;
	
	
	//step 3 instantiation
	public CreateNewOrgPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//step 4 utilization


	public WebElement getOrganizationnametxt() {
		return organizationnametxt;
	}


	public WebElement getSavebtn() {
		return savebtn;
	}


	public WebElement getCancelbtn() {
		return cancelbtn;
	}
	
	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}


	public WebElement getTypeDropDown() {
		return typeDropDown;
	}


	//business library
	/**
	 * this method will create new organization
	 * @param ORGNAME
	 */
	public void createNewOrg(String ORGNAME)
	{
		organizationnametxt.sendKeys(ORGNAME);
		savebtn.click();
	}
	
	/**
	 * this method will create new org with industry
	 * @param ORGNAME
	 * @param INDUSTRYNAME
	 */
	public void createNewOrg(String ORGNAME, String INDUSTRYNAME)
	{
		organizationnametxt.sendKeys(ORGNAME);
		industryDropDown.sendKeys(INDUSTRYNAME);
		handleDropDown(industryDropDown, INDUSTRYNAME);
		savebtn.click();
		
	}
	
	public void createNewOrg(String ORGNAME,String INDUSTRYNAME,String TYPE)
	{
		organizationnametxt.sendKeys(ORGNAME);
		handleDropDown(industryDropDown, INDUSTRYNAME);
		typeDropDown.sendKeys(TYPE);
		handleDropDown(typeDropDown, TYPE);
		savebtn.click();
		
	}
	
	
	
	
	

}
