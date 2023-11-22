package OrganizationTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.GenericExcelFile;
import genericUtility.WebDriverUtility;
import genericUtility.genericMethodForPropertyFile;
import genericUtility.genericMethodJava;
import objectRepositry.CreateNewOrgPage;
import objectRepositry.HomePage;
import objectRepositry.LoginPage;
import objectRepositry.OrgInfoPage;
import objectRepositry.OrganizationPage;

public class CreateOrgwithIndAndTypeTest extends BaseClass {

	@Test
	public void createOrgWithIndAndTypetest() throws IOException, InterruptedException

	{
		
				
				//READ FROM TESTDATA FROM EXCEL FILE
				
				String ORGNAME =eutil.readDataFromExcel("Organization", 1, 2)+jutil.getrandomnumber();
				String INDUSTRYNAME = eutil.readDataFromExcel("Organization", 7, 3);
				String TYPE = eutil.readDataFromExcel("Organization", 7, 4);
				
				
				//step4:navigate to organization link
				HomePage hp=new HomePage(driver);
				hp.clickOnOrgLnk();
				
				
				//step5:click on create org look up image
				OrganizationPage op=new OrganizationPage(driver);
				op.clickcreateOrglookup();
				
				//step 6:create new organization With industry name
				CreateNewOrgPage cnop=new CreateNewOrgPage(driver);
				cnop.createNewOrg(ORGNAME, INDUSTRYNAME, TYPE);
				
				//step 7:validation
				OrgInfoPage oip=new OrgInfoPage(driver);
				String orgheader = oip.getorgHeader();
				Assert.assertTrue(orgheader.contains(ORGNAME));
				System.out.println(orgheader);
				
	}


	}


