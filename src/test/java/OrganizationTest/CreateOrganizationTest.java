package OrganizationTest;

import java.io.IOException;
import static org.testng.Assert.assertTrue;

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

public class CreateOrganizationTest extends BaseClass{

	@Test
	public void createNewOrganizationTest() throws IOException, InterruptedException
	{
		
				
				//READ FROM TESTDATA FROM EXCEL FILE
				
				String ORGNAME =eutil.readDataFromExcel("Organization", 1, 2)+jutil.getrandomnumber();
				
				
				//step4:navigate to organization link
				HomePage hp=new HomePage(driver);
				hp.clickOnOrgLnk();
				
				
				//step5:click on create org look up image
				OrganizationPage op=new OrganizationPage(driver);
				op.clickcreateOrglookup();
				
				//step 6:create new organization
				CreateNewOrgPage cnop=new CreateNewOrgPage(driver);
				cnop.createNewOrg(ORGNAME);
				
				//step 7:validation
				OrgInfoPage oip=new OrgInfoPage(driver);
				String orgheader = oip.getorgHeader();
				Assert.assertTrue(orgheader.contains(ORGNAME));
				System.out.println(orgheader);
				
	}

}
