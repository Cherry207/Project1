package editlead;

import org.openqa.selenium.TimeoutException;

import org.testng.annotations.Test;

import homework2.OpenTaps;



public class EditLeads extends OpenTaps {
	
	@Test
	//(dependsOnMethods="homework2.CreateLead.createLead")
	public void editLead() throws InterruptedException{
		clickByLinkText("Leads");
		clickByLinkText("Find Leads");
		enterTextByXPath("(//input[@name='firstName'])[3]", "Charan");
		clickByXPath("//button[contains(text(),'Find Leads')]");
		Thread.sleep(2000);
		clickByXPath("(//a[@class='linktext'])[4]");
		verifyTitle("View Lead | opentaps CRM");
		clickByLinkText("Edit");
		selectByIndex("addDataSourceForm_dataSourceId", 4);
		clickByXPath("(//input[@name='submitButton'])[2]");
		selectByVisibleText("addMarketingCampaignForm_marketingCampaignId", "Road and Track");
		clickByXPath("(//input[@name='submitButton'])[3]");
		clickByClassName("smallSubmit");
		verifyTextContainsById("viewLead_dataSources_sp", "Existing Customer");
		verifyTextContainsById("viewLead_marketingCampaigns_sp", "Road and Track");
		
//		System.out.println("Im in Edit Lead");
		
//		throw new TimeoutException("SorryYourEditingProcessIsTooLate");
	}
	
}
