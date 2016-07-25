package wrapper;

import org.junit.Test;

import wrapper.WrapperMethods;

public class TestCase6 extends WrapperMethods{
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
		String leadid = getTextByXPath("(//a[@class='linktext'])[4]");
		System.out.println(leadid);
		Thread.sleep(2000);
		clickByXPath("(//a[@class='linktext'])[4]");
		clickByLinkText("Qualify Lead");
		clickByLinkText("Convert Lead");
		String parent = getWindowHandle();
		clickByXPath("//img[@alt='Lookup']");
		switchToChildWindow();
		String accountid = getTextByClassName("linktext");
		clickByClassName("linktext");
		closeBrowser();
		switchToParentWindow(parent);
		verifyTextContainsById("convertLeadForm_accountPartyId", accountid);
		clickByName("submitButton");
		String finalid = getTextByXPath("(//a[@class='linktext'])[5]");
		finalid = finalid.substring(finalid.indexOf("(")+1, finalid.indexOf(")"));
		if (accountid.equals(finalid)){
			System.out.println("Both are equal");
		}else {
			System.out.println("Both are unequal");
		}
}
}