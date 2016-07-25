package week4_class1;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase2 extends commonMethodsInAll {

	
	@BeforeMethod
	public void pathToEditLead() throws InterruptedException {

		clickByPartialLinkText("CRM/SFA");
		Thread.sleep(2000);
		clickByLinkText("Leads");
		clickByLinkText("Find Leads");
	}

	@Test
	public void editLead() {
		enterTextByXPath("(//input[@name='firstName'])[3]", "Charan");
		clickByXPath("//button[contains(text(),'Find Leads')]");
		clickByXPath("(//a[@class='linktext'])[4]");
		verifyTitle("View Lead | opentaps CRM");
		clickByLinkText("Edit");
		selectByIndex("addDataSourceForm_dataSourceId", 3);
		clickByXPath("(//input[@name='submitButton'])[2]");
		selectByVisibleText("addMarketingCampaignForm_marketingCampaignId", "Road and Track");
		clickByXPath("(//input[@name='submitButton'])[3]");
		clickByClassName("smallSubmit");
	}

	@AfterMethod
	public void verifyText() {
		verifyTextContainsById("viewLead_dataSources_sp", "Existing Customer");
		verifyTextContainsById("viewLead_marketingCampaigns_sp", "Road and Track");

	}

	

}
