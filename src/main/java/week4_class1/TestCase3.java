package week4_class1;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import wrapper.WrapperMethods;

public class TestCase3 extends WrapperMethods {

	
	@BeforeMethod
	public void pathToEditLead() throws InterruptedException {

		clickByPartialLinkText("CRM/SFA");
		Thread.sleep(2000);
		clickByLinkText("Leads");
		clickByLinkText("Find Leads");
	}

	@Test
	public void deleteLead() throws InterruptedException {

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
	}

	@AfterMethod
	public void verifyLead() {
		String text = getTextByClassName("x-paging-info");
		verifyTextEqualsByClassName("x-paging-info", text);
	}
	
	
}