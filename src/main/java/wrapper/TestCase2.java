package wrapper;

import org.junit.Test;

import wrapper.WrapperMethods;

public class TestCase2 extends WrapperMethods {
	
		
		String[][] data = {{"Charan"},{"Cherry"}};

		@Test
		public void login() throws InterruptedException{
		
			for (int i = 0; i < 2; i++) 
			{			
			launchBrowser("chrome", "http://demo1.opentaps.org/");
			enterTextById("username", "DemoSalesManager");
			enterTextById("password", "crmsfa");
			clickByClassName("decorativeSubmit");
			clickByPartialLinkText("CRM/SFA");
			Thread.sleep(2000);
			clickByLinkText("Leads");
			clickByLinkText("Find Leads");
			enterTextByXPath("(//input[@name='firstName'])[3]", data[i][0]);
			clickByXPath("//button[contains(text(),'Find Leads')]");
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
			closeBrowser();
		}
}
}