package wrapper;

import org.junit.Test;

import wrapper.WrapperMethods;

public class TestCase5 extends WrapperMethods{
	@Test
	public void login() throws InterruptedException{
	
					
		launchBrowser("chrome", "http://demo1.opentaps.org/");
		enterTextById("username", "DemoSalesManager");
		enterTextById("password", "crmsfa");
		clickByClassName("decorativeSubmit");
		clickByPartialLinkText("CRM/SFA");
		Thread.sleep(2000);
		clickByLinkText("Leads");
		clickByLinkText("Find Leads");
		clickByXPath("//span[contains(text(),'Email')]");
		enterTextByName("emailAddress", "shy@g.com");
		clickByXPath("//button[contains(text(),'Find Leads')]");
		String leadid = getTextByXPath("(//a[@class='linktext'])[4]");
		System.out.println(leadid);
		Thread.sleep(2000);
		clickByXPath("(//a[@class='linktext'])[4]");
		String firstname = getTextById("viewLead_firstName_sp");
		clickByXPath("//a[contains(text(),'Duplicate Lead')]");
		verifyTextEqualsById("createLeadForm_firstName", firstname);
		clickByName("submitButton");
		String newleadid = getTextById("viewLead_companyName_sp");
		newleadid = newleadid.substring(newleadid.indexOf("(")+1, newleadid.indexOf(")"));
		System.out.println(newleadid);
		if (leadid.equals(newleadid)){
			System.out.println("both are equal");
		}else {
			System.out.println("Both are different");
		}
}
}