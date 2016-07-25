package week4_class1;


import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase1 extends OpenTapsWrapperForTestNG {

	
	@BeforeMethod
	public void pathToCreateLead() throws InterruptedException {

	
			clickByPartialLinkText("CRM/SFA");
			Thread.sleep(2000);
			clickByLinkText("Leads");
			clickByLinkText("Create Lead");
			Thread.sleep(2000);
		
	}
	@Test(invocationCount=2)
	public void createlead() throws InterruptedException {
		enterTextById("createLeadForm_companyName", "Charan1");
		enterTextById("createLeadForm_firstName", "Charan");
		enterTextById("createLeadForm_lastName", "Teja"); 
		selectByValue("createLeadForm_dataSourceId", "LEAD_COLDCALL");
		selectByValue("createLeadForm_marketingCampaignId", "CATRQ_AUTOMOBILE");
		enterTextById("createLeadForm_primaryEmail", "Straw1@gmail.com");
		enterTextById("createLeadForm_primaryPhoneNumber", "9876543210");
		clickByClassName("smallSubmit");
		// to get the number from the string we use substring
		String name = getTextById("viewLead_companyName_sp");
		name = name.substring(name.indexOf("(") + 1, name.indexOf(")"));
		System.out.println(name);

	}

	

}