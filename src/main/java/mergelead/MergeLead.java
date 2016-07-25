package mergelead;

import org.testng.annotations.Test;

import homework2.OpenTaps;

public class MergeLead extends OpenTaps{

	@Test
	public void mergeLead() throws InterruptedException{
		clickByLinkText("Leads");
		clickByLinkText("Merge Leads");
		String parent = getWindowHandle();
		clickByXPath("(//img[@alt='Lookup'])[1]");
		switchToChildWindow();
		Thread.sleep(3000);
		enterTextByXPath("//input[@name='firstName']", "Cherry");
		clickByXPath("//button[contains(text(),'Find Leads')]");
		Thread.sleep(4000);
		clickByXPath("//a[@class='linktext']");
		Thread.sleep(5000);
		switchToParentWindow(parent);
		clickByXPath("(//img[@alt='Lookup'])[2]");
		switchToChildWindow();
		Thread.sleep(3000);
		enterTextByXPath("//input[@name='firstName']", "Charan");
		clickByXPath("//button[contains(text(),'Find Leads')]");
		Thread.sleep(3000);
		clickByXPath("//a[@class='linktext']");
		switchToParentWindow(parent);
		clickByClassName("buttonDangerous");
		acceptAlerts();
		clickByLinkText("Find Leads");
		enterTextByXPath("(//input[@class=' x-form-text x-form-field'])[24]", "Cherry");
		clickByXPath("//button[contains(text(),'Find Leads')]");
		String text = getTextByClassName("x-paging-info");
		verifyTextEqualsByClassName("x-paging-info", text);
		
//		System.out.println("Im in Merge lead");
		
	}
	
}
