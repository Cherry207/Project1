package week4_class1;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase4 extends OpenTapsWrapperForTestNG {

	
	@BeforeMethod
	public void moveToEditLead() throws InterruptedException {

		clickByPartialLinkText("CRM/SFA");
		Thread.sleep(2000);
		clickByLinkText("Leads");
		clickByLinkText("Merge Leads");
	}

	@Test
	public void mergeLeads() throws InterruptedException {

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
	}

	@AfterMethod
	public void verifyLead() {
		String text = getTextByClassName("x-paging-info");
		verifyTextEqualsByClassName("x-paging-info", text);

	}
	
	
}
