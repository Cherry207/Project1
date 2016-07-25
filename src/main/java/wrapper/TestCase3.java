package wrapper;

import org.junit.Test;

public class TestCase3 extends WrapperMethods{
 
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
		clickByXPath("//span[contains(text(),'Phone')]");
		enterTextByName("phoneNumber", "9874563210");
		clickByXPath("//button[contains(text(),'Find Leads')]");
		String leadid = getTextByXPath("(//a[@class='linktext'])[4]");
		Thread.sleep(2000);
		clickByXPath("(//a[@class='linktext'])[4]");
		clickByLinkText("Delete");
		clickByLinkText("Find Leads");
		enterTextByXPath("//input[@name='id']", leadid);
		clickByXPath("//button[contains(text(),'Find Leads')]");
		String text = getTextByClassName("x-paging-info");
		verifyTextEqualsByClassName("x-paging-info", text);
		}
}
