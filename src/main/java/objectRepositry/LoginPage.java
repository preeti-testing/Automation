package objectRepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {//step 1
	 //step 2 declaration
	@FindBy(name = "user_name")
	private WebElement usernametxt;
	@FindBy(name = "user_password")
	private WebElement passwordtxt;
	
	@FindBy(id = "submitButton")
	private WebElement loginbtn;
	
	//step 3 instantiation
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
//step 4 utilization

	public WebElement getUsernametxt() {
		return usernametxt;
	}

	public WebElement getPasswordtxt() {
		return passwordtxt;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}
	
	
	//business librery
	public void loginToApp(String USERNAME, String PASSWORD)
	{
		usernametxt.sendKeys(USERNAME);
		passwordtxt.sendKeys(PASSWORD);
		loginbtn.click();
		
	}
	
	
	
	
	
	
	
	
}
