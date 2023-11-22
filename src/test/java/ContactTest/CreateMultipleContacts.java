package ContactTest;

import java.io.IOException;
import static org.testng.Assert.assertTrue;


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.GenericExcelFile;
import genericUtility.WebDriverUtility;
import genericUtility.genericMethodForPropertyFile;
import genericUtility.genericMethodJava;
import objectRepositry.ContactInfoPage;
import objectRepositry.ContectPage;
import objectRepositry.CreateContactPage;
import objectRepositry.HomePage;
import objectRepositry.LoginPage;


import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.GenericExcelFile;
import genericUtility.WebDriverUtility;
import genericUtility.genericMethodForPropertyFile;
import objectRepositry.ContactInfoPage;
import objectRepositry.ContectPage;
import objectRepositry.CreateContactPage;
import objectRepositry.HomePage;
import objectRepositry.LoginPage;

public class CreateMultipleContacts extends BaseClass {
	
	

	@Test(dataProvider="getData")
	public void  createMultipleContacts(String LASTNAME) throws IOException, InterruptedException 
	{
		//read data from excel sheet
		//String LASTNAME = eutil.readDataFromExcel("Contects", 1, 2);

		//step 4:navigate to contacts Link
		HomePage hp=new HomePage(driver);
		hp.clickOnContectLnk();
		
		
		//step 5:click on create new contact look up image
		 ContectPage cp=new ContectPage(driver);
		 cp.clickOncreatecontactimg();
		 
		//step 6: create new contact
		CreateContactPage ccp=new CreateContactPage(driver);
		ccp.createNewContact(LASTNAME);
		 
		//step 7:validate
		ContactInfoPage cip=new ContactInfoPage(driver);
		String contactheader = cip.getcontactHeader();
		 Assert.assertTrue(contactheader.contains(LASTNAME));
		  System.out.println(contactheader);
		
		
		
	}
	 
    @DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		return eutil.readMultipleDataFromExcel("CreateMultipleContacts");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
