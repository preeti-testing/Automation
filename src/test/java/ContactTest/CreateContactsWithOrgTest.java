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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.GenericExcelFile;
import genericUtility.WebDriverUtility;
import genericUtility.genericMethodForPropertyFile;
import genericUtility.genericMethodJava;
import objectRepositry.ContactInfoPage;
import objectRepositry.ContectPage;
import objectRepositry.CreateContactPage;
import objectRepositry.CreateNewOrgPage;
import objectRepositry.HomePage;
import objectRepositry.LoginPage;
import objectRepositry.OrgInfoPage;
import objectRepositry.OrganizationPage;

public class CreateContactsWithOrgTest extends BaseClass {

 @Test
 public void createNewContactsWithOrgTest() throws IOException, InterruptedException
 {
		
				
				
						
						//READ FROM TESTDATA FROM EXCEL FILE
						
						String ORGNAME =eutil.readDataFromExcel("Organization", 1, 2)+jutil.getrandomnumber();
						String LASTNAME = eutil.readDataFromExcel("Contects", 1, 2);
						
						
						
						
						//step 4:navigate to organization
						HomePage hp=new HomePage(driver);
						hp.clickOnOrgLnk();
						
						
						//step 5:click on create org look up image
						OrganizationPage op=new OrganizationPage(driver);
						op.clickcreateOrglookup();
						
						//step 6:create new org
						CreateNewOrgPage cnop=new CreateNewOrgPage(driver);
						cnop.createNewOrg(ORGNAME);
						
						//step 7:validate
						OrgInfoPage oip=new OrgInfoPage(driver);
						String orgheader=oip.getorgHeader();


						
						 Assert.assertTrue(orgheader.contains(ORGNAME));
						 System.out.println(orgheader);
						
						//step 8:navigate to contacts link
						hp.clickOnContectLnk();
						
						//step 9:click on create contacts look up image
						ContectPage cp=new ContectPage(driver);
						cp.clickOncreatecontactimg();
						
						//step 10:create new contact with lastname and org
						CreateContactPage ccp=new CreateContactPage(driver);
						ccp.createNewContact(driver, LASTNAME, ORGNAME);
						
						
						
						//step 11:validation
						ContactInfoPage cip=new ContactInfoPage(driver);
						   String contactheader = cip.getcontactHeader();
						  Assert.assertTrue(contactheader.contains(LASTNAME));
						  System.out.println(contactheader);
						   
						   
						   
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
	}

}
