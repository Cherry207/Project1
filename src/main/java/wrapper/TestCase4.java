package wrapper;

import org.junit.Test;

import wrapper.WrapperMethods;

public class TestCase4 extends WrapperMethods{
	 
	@Test
	public void login() throws InterruptedException{
	
					
		launchBrowser("chrome", "http://demo1.opentaps.org/");
		enterTextById("username", "DemoSalesManager");
		enterTextById("password", "crmsfa");
		clickByClassName("decorativeSubmit");
		clickByPartialLinkText("CRM/SFA");
		Thread.sleep(2000);
		clickByLinkText("Leads");
		clickByLinkText("Merge Leads");
		String parent = getWindowHandle();
		clickByXPath("(//img[@alt='Lookup'])[1]");
		switchToChildWindow();
		Thread.sleep(3000);
		enterTextByXPath("//input[@name='id']", "10019");
		clickByXPath("//button[contains(text(),'Find Leads')]");
		Thread.sleep(3000);
		clickByXPath("//a[@class='linktext']");
		Thread.sleep(2000);
		switchToParentWindow(parent);
		clickByXPath("(//img[@alt='Lookup'])[2]");
		switchToChildWindow();
		Thread.sleep(3000);
		enterTextByXPath("//input[@name='id']", "10020");
		clickByXPath("//button[contains(text(),'Find Leads')]");
		Thread.sleep(3000);
		clickByXPath("//a[@class='linktext']");
		switchToParentWindow(parent);
		clickByClassName("buttonDangerous");
		getAlertsText();
		acceptAlerts();
		clickByLinkText("Find Leads");
		enterTextByXPath("(//input[@class=' x-form-text x-form-field'])[24]", "10019");
		clickByXPath("//button[contains(text(),'Find Leads')]");
		String text = getTextByClassName("x-paging-info");
		verifyTextEqualsByClassName("x-paging-info", text);
		
		
}
}