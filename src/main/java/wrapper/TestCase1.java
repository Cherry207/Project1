package wrapper;

import org.junit.Test;

import wrapper.WrapperMethods;

public class TestCase1 extends WrapperMethods {
	
	String[][] data = {{"Charan1", "Charan", "Teja", "LEAD_COLDCALL", "CATRQ_AUTOMOBILE", "Straw1@gmail.com","9874563210"},
			{"Charan2", "Cherry", "Lucky", "LEAD_CONFERENCE", "CATRQ_CARNDRIVER", "Straw2@gmail.com","9874563211"}};

	@Test
	public void login() throws InterruptedException{
	
					
		launchBrowser("chrome", "http://demo1.opentaps.org/");
		enterTextById("username", "DemoSalesManager");
		enterTextById("password", "crmsfa");
		clickByClassName("decorativeSubmit");
		clickByPartialLinkText("CRM/SFA");
		Thread.sleep(2000);
		for (int i = 0; i < 2; i++) {
		clickByLinkText("Create Lead");
		Thread.sleep(2000);
		enterTextById("createLeadForm_companyName", data[i][0]);
		enterTextById("createLeadForm_firstName", data[i][1]);
		enterTextById("createLeadForm_lastName", data[i][2]);
		selectByValue("createLeadForm_dataSourceId", data[i][3]);
		selectByValue("createLeadForm_marketingCampaignId", data[i][4]);
		enterTextById("createLeadForm_primaryEmail", data[i][5]);
		enterTextById("createLeadForm_primaryPhoneNumber", data[i][6]);
		clickByClassName("smallSubmit");
		//to get the number from the string we use substring
		String name = getTextById("viewLead_companyName_sp");
		name = name.substring(name.indexOf("(")+1, name.indexOf(")"));
		System.out.println(name);
	}
}
}