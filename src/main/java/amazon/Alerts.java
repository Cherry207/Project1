package amazon;

import org.junit.Test;

import wrapper.WrapperMethods;

public class Alerts extends WrapperMethods {

	@Test
	public void login(){
		
		launchBrowser("Chrome", "http://t4t5.github.io/sweetalert/");
		clickByXPath("/html/body/div[1]/button");
		getAlertsText();
		acceptAlerts();
	}
}
